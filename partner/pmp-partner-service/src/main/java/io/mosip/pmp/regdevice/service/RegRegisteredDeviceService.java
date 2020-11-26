package io.mosip.pmp.regdevice.service;

import io.mosip.pmp.authdevice.dto.DeRegisterDevicePostDto;
import io.mosip.pmp.authdevice.dto.PageResponseDto;
import io.mosip.pmp.authdevice.dto.RegisteredDevicePostDto;
import io.mosip.pmp.authdevice.dto.SearchDto;
import io.mosip.pmp.authdevice.entity.RegisteredDevice;
import io.mosip.pmp.partner.dto.PartnerSearchDto;

public interface RegRegisteredDeviceService {
	public String deRegisterDevice(DeRegisterDevicePostDto deRegisterDevicePostDto);

	public String signedRegisteredDevice(RegisteredDevicePostDto registeredDevicePostDto) throws Exception;

	public <E> PageResponseDto<RegisteredDevice> searchEnity(Class<E> entity, SearchDto dto);
}
