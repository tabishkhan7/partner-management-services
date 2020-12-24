package io.mosip.pmp.partner.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.mosip.kernel.core.authmanager.authadapter.model.AuthUserDetails;
import io.mosip.kernel.core.exception.ExceptionUtils;
import io.mosip.kernel.core.exception.ServiceError;
import io.mosip.kernel.core.http.RequestWrapper;
import io.mosip.kernel.core.http.ResponseWrapper;
import io.mosip.kernel.core.util.DateUtils;
import io.mosip.pmp.authdevice.exception.ValidationException;
import io.mosip.pmp.partner.constant.PartnerManageEnum;
import io.mosip.pmp.partner.dto.AuditRequestDto;
import io.mosip.pmp.partner.dto.AuditResponseDto;

@Component
public class AuditUtil {

	@Autowired
	RestTemplate restTemplate;

	@Value("${mosip.kernel.masterdata.audit-url}")
	private String auditUrl;

	@Autowired
	private ObjectMapper objectMapper;

	/** The Constant UNKNOWN_HOST. */
	private static final String UNKNOWN_HOST = "Unknown Host";

	private String hostIpAddress = null;

	private String hostName = null;
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AuditUtil.class);

	/** The Constant APPLICATION_ID. */
	private static final String APPLICATION_ID = "MOSIP_7";

	/** The Constant APPLICATION_NAME. */
	private static final String APPLICATION_NAME = "2PARTNER_MANAGEMENT";
	
	private volatile AtomicInteger eventCounter;

	@Autowired
	private Environment env;

	public String getServerIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			return UNKNOWN_HOST;
		}
	}

	public String getServerName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			return UNKNOWN_HOST;
		}
	}

	@PostConstruct
	public void getHostDetails() {
		hostIpAddress = getServerIp();
		hostName = getServerName();
	}
	
	public void auditRequest(String eventName, String eventType, String description, String eventId) {
	setAuditRequestDto(eventName, eventType, description, eventId);
	}
	
	public void auditRequest(String eventName, String eventType, String description) {
		String eventId = "ADM-" + eventCounter.incrementAndGet();
		//setAuditRequestDto(eventName, eventType, description, eventId);
	}

	public void setAuditRequestDto(PartnerManageEnum PartnerManageEnum) {
		AuditRequestDto auditRequestDto = new AuditRequestDto();

		auditRequestDto.setHostIp(hostIpAddress);
		auditRequestDto.setHostName(hostName);
		auditRequestDto.setApplicationId(PartnerManageEnum.getApplicationId());
		auditRequestDto.setApplicationName(PartnerManageEnum.getApplicationName());
		auditRequestDto.setSessionUserId(getUserId());
		auditRequestDto.setSessionUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		auditRequestDto.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		auditRequestDto.setActionTimeStamp(DateUtils.getUTCCurrentDateTime());
		auditRequestDto.setDescription(PartnerManageEnum.getDescription());
		auditRequestDto.setEventType(PartnerManageEnum.getType());
		auditRequestDto.setEventName(PartnerManageEnum.getName());
		auditRequestDto.setModuleId(PartnerManageEnum.getModuleId());
		auditRequestDto.setModuleName(PartnerManageEnum.getModuleName());
		auditRequestDto.setEventId(PartnerManageEnum.getEventId());
		auditRequestDto.setId(PartnerManageEnum.getId());
		auditRequestDto.setIdType(PartnerManageEnum.getIdType());
		callAuditManager(auditRequestDto);
	}

	private void callAuditManager(AuditRequestDto auditRequestDto) {

		RequestWrapper<AuditRequestDto> auditReuestWrapper = new RequestWrapper<>();
		auditReuestWrapper.setRequest(auditRequestDto);
		HttpEntity<RequestWrapper<AuditRequestDto>> httpEntity = new HttpEntity<>(auditReuestWrapper);
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(auditUrl, HttpMethod.POST, httpEntity, String.class);
			String responseBody = response.getBody();
			getAuditDetailsFromResponse(responseBody);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void setAuditRequestDto(String eventName, String eventType, String description, String eventId) {
		AuditRequestDto auditRequestDto = new AuditRequestDto();
		if (!validateSecurityContextHolder()) {

		}

		auditRequestDto.setEventId(eventId);
		auditRequestDto.setId("NO_ID");
		auditRequestDto.setIdType("NO_ID_TYPE");
		auditRequestDto.setEventName(eventName);
		auditRequestDto.setEventType(eventType);
		auditRequestDto.setModuleId("PMP-AUT");
		auditRequestDto.setModuleName("partner service");
		auditRequestDto.setDescription(description);
		auditRequestDto.setActionTimeStamp(DateUtils.getUTCCurrentDateTime());
		auditRequestDto.setHostIp(hostIpAddress);
		auditRequestDto.setHostName(hostName);
		auditRequestDto.setApplicationId(APPLICATION_ID);
		auditRequestDto.setApplicationName(APPLICATION_NAME);
		auditRequestDto.setSessionUserId(SecurityContextHolder.getContext().getAuthentication().getName());
		auditRequestDto.setSessionUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		auditRequestDto.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());

		// if current profile is local or dev donot call this method
		if (Arrays.stream(env.getActiveProfiles()).anyMatch(environment -> (environment.equalsIgnoreCase("local")))) {
			LOGGER.info("Recieved Audit : " + auditRequestDto.toString());

		} else {
			callAuditManager(auditRequestDto);
		}

	}

	private AuditResponseDto getAuditDetailsFromResponse(String responseBody) throws Exception {

		List<ServiceError> validationErrorsList = null;
		validationErrorsList = ExceptionUtils.getServiceErrorList(responseBody);
		AuditResponseDto auditResponseDto = null;
		if (!validationErrorsList.isEmpty()) {
			throw new ValidationException(validationErrorsList);
		}
		ResponseWrapper<AuditResponseDto> responseObject = null;
		try {

			responseObject = objectMapper.readValue(responseBody,
					new TypeReference<ResponseWrapper<AuditResponseDto>>() {
					});
			auditResponseDto = responseObject.getResponse();
		} catch (IOException | NullPointerException exception) {
			throw exception;
		}

		return auditResponseDto;
	}

	private String getUserId() {
		if (Objects.nonNull(SecurityContextHolder.getContext())
				&& Objects.nonNull(SecurityContextHolder.getContext().getAuthentication())
				&& Objects.nonNull(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof AuthUserDetails) {
			return ((AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
					.getUserId();
		} else {
			return SecurityContextHolder.getContext().getAuthentication().getName();
		}
	}

	private boolean validateSecurityContextHolder() {
		Predicate<SecurityContextHolder> contextPredicate = i -> SecurityContextHolder.getContext() != null;
		Predicate<SecurityContextHolder> authPredicate = i -> SecurityContextHolder.getContext()
				.getAuthentication() != null;
		Predicate<SecurityContextHolder> principlePredicate = i -> SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal() != null;
		return contextPredicate.and(authPredicate).and(principlePredicate) != null;

	}

}
