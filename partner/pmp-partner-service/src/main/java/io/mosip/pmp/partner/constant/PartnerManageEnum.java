package io.mosip.pmp.partner.constant;

public enum PartnerManageEnum {

	Partner_Registration("PMS_PRT_101", AuditConstant.AUDIT_USER, "Register PARTNER", "Calling API to register partner",
			AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID", "NO_ID_TYPE",
			AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	CREATE_PARTNER_SUCCESS("PMS_PRT_200", AuditConstant.AUDIT_USER, "Register PARTNER",
			"Calling API to create PARTNER is success", AuditConstant.PARTNER_MODULE_ID,
			AuditConstant.PARTNER_MODULE_NAME, "NO_ID", "NO_ID_TYPE", AuditConstant.APPLICATION_NAME,
			AuditConstant.APPLICATION_ID),
	PARTNER_INVALID_EMAIL_CREATE("PMS_PRT_401", AuditConstant.AUDIT_SYSTEM, "Create PARTNER request",
			"Invalid email id", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_INVALID_EMAIL_UPDATE("PMS_PRT_416", AuditConstant.AUDIT_SYSTEM, "Update PARTNER request",
			"Invalid email id for PARTNER id - %s", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME,
			"%s", "PARTNER ID", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_NAME_EXISTS_UPDATE("PMS_PRT_402", AuditConstant.AUDIT_SYSTEM, "Update PARTNER request",
			"PARTNER is already registered  for id - %s", AuditConstant.PARTNER_MODULE_ID,
			AuditConstant.PARTNER_MODULE_NAME, "%s", "PARTNER ID", AuditConstant.APPLICATION_NAME,
			AuditConstant.APPLICATION_ID),
	PARTNER_NAME_EXISTS_CREATE("PMS_PRT_417", AuditConstant.AUDIT_SYSTEM, "Create PARTNER request",
			"PARTNER is already registered with organization name", AuditConstant.PARTNER_MODULE_ID,
			AuditConstant.PARTNER_MODULE_NAME, "NO_ID", "NO_ID_TYPE", AuditConstant.APPLICATION_NAME,
			AuditConstant.APPLICATION_ID),
	POLICY_GROUP_ABSENT_CREATE("PMS_PRT_419", AuditConstant.AUDIT_SYSTEM, "Create PARTNER request",
			"POLICY GROUP Does Not Exist", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	CREATE_PARTNER_API_KEY("PMS_PRT_112", AuditConstant.AUDIT_USER, "Create PARTNER Key",
			"Successfully created PARTNER key", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME,
			"%s", "PARTNER ID", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	CREATE_PARTNER_API_KEY_SUCCESS("PMS_PRT_212", AuditConstant.AUDIT_USER, "Created PARTNER Key",
			"Successfully created PARTNER key", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME,
			"%s", "PARTNER ID", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_ABSENT("PMS_PRT_421", AuditConstant.AUDIT_SYSTEM, "Create PARTNER API Key request",
			"PARTNER is not present", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_POLICY_MAPPING_NOT_EXISTS("PMS_PRT_423", AuditConstant.AUDIT_SYSTEM, "Add Biometric Extractors request",
			"PARTNER_POLICY mapping is not present", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME,
			"NO_ID", "NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_NOT_ALLOWED("PMS_PRT_425", AuditConstant.AUDIT_SYSTEM, "PARTNER not allowed", "PARTNER is not allowed",
			AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID", "NO_ID_TYPE",
			AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	EMAIL_NOT_ALLOWED("PMS_PRT_429", AuditConstant.AUDIT_SYSTEM, "Email not allowed", "Email is not allowed",
			AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID", "NO_ID_TYPE",
			AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	CERTIFICATE_NOT_UPLOADED("PMS_PRT_431", AuditConstant.AUDIT_SYSTEM, "Create Partner", "Certificate upload failure",
			AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID", "NO_ID_TYPE",
			AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_ID_LENGTH_EXCEPTION("PMS_PRT_452", AuditConstant.AUDIT_SYSTEM, "Create Partner",
			"Certificate upload failure", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_API_KEY_REQUEST_APPROVED("PMS_PRT_222", AuditConstant.AUDIT_SYSTEM, "Create Partner",
			"PARTNER API KEY APPROVED", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_API_KEY_REQUEST_APPROVE("PMS_PRT_122", AuditConstant.AUDIT_SYSTEM, "Create Partner",
			"PARTNER API KEY APPROVED", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_BIOMETRICS_CREATE("PMS_PRT_111", AuditConstant.AUDIT_SYSTEM, "Create Partner",
			"CREATING BIOMETRICS", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_BIOMETRICS_CREATE_SUCCESS("PMS_PRT_211", AuditConstant.AUDIT_SYSTEM, "Create Partner",
			"PARTNER BIOMETRICS CREATED", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_POLICY_MAP_CREATE("PMS_PRT_121", AuditConstant.AUDIT_SYSTEM, "Create Partner Policy Map",
			"Creating partner policy map", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	PARTNER_POLICY_MAP_CREATE_SUCCESS("PMS_PRT_221", AuditConstant.AUDIT_SYSTEM, "Create Partner Policy Map",
			"Creating partner policy map success", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	CREATE_UPDATE_CONTACT_DETAILS("PMS_PRT_144", AuditConstant.AUDIT_SYSTEM, "Create Partner Policy Map",
			"Creating or updating contact details", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	CREATE_UPDATE_CONTACT_DETAILS_SUCCESS("PMS_PRT_244", AuditConstant.AUDIT_SYSTEM, "Create Partner Policy Map",
			"Creating or updating contact details", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	GET_PARTNER_DETAILS("PMS_PRT_149", AuditConstant.AUDIT_SYSTEM, "GET PARTNER",
			"Getting partner details", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	GET_PARTNER_DETAILS_SUCCESS("PMS_PRT_249", AuditConstant.AUDIT_SYSTEM, "GET PARTNER",
			"Getting partner details", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	GET_PARTNER_API_KEY("PMS_PRT_159", AuditConstant.AUDIT_SYSTEM, "GET PARTNER",
			"Getting partner api details", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	GET_PARTNER_API_KEY_SUCCESS("PMS_PRT_259", AuditConstant.AUDIT_SYSTEM, "GET PARTNER",
			"Getting partner api keys", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	GET_PARTNER_CERTIFICATE("PMS_PRT_169", AuditConstant.AUDIT_SYSTEM, "GET PARTNER",
			"Getting partner certificate", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID),
	GET_PARTNER_CERTIFICATE_SUCCESS("PMS_PRT_269", AuditConstant.AUDIT_SYSTEM, "GET PARTNER",
			"Getting partner certificate", AuditConstant.PARTNER_MODULE_ID, AuditConstant.PARTNER_MODULE_NAME, "NO_ID",
			"NO_ID_TYPE", AuditConstant.APPLICATION_NAME, AuditConstant.APPLICATION_ID);

	private final String eventId;

	private final String type;

	private String name;

	private String description;

	private String moduleId;

	private String moduleName;

	private String id;

	private String idType;

	private String applicationId;

	private String applicationName;

	private PartnerManageEnum(String eventId, String type, String name, String description, String moduleId,
			String moduleName, String id, String idType, String applicationId, String applicationName) {
		this.eventId = eventId;
		this.type = type;
		this.name = name;
		this.description = description;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.id = id;
		this.idType = idType;
		this.applicationId = applicationId;
		this.applicationName = applicationName;

	}

	public String getEventId() {
		return eventId;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getModuleId() {
		return moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public String getId() {
		return id;
	}

	public String getIdType() {
		return idType;
	}

	public void setDescription(String des) {
		this.description = des;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApplicationName() {
		return applicationName;
	}

	/*
	 * Replace %s value in description and id with second parameter passed
	 */

	public static PartnerManageEnum getPartnerManageEnumWithValue(PartnerManageEnum e, String s) {
		e.setDescription(String.format(e.getDescription(), s));
		if (e.getId().equalsIgnoreCase("%s"))
			e.setId(s);
		return e;
	}

}
