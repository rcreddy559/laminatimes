package com.laminatimes.apigatewayservice;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("url")
public class UriConfiguration {
	private String holiday;
	private String apiGateway;
	private String auth;
	private String config;
	private String leave;
	private String user;

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	public String getApiGateway() {
		return apiGateway;
	}

	public void setApiGateway(String apiGateway) {
		this.apiGateway = apiGateway;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UriConfiguration{" +
				"holiday='" + holiday + '\'' +
				", apiGateway='" + apiGateway + '\'' +
				", auth='" + auth + '\'' +
				", config='" + config + '\'' +
				", leave='" + leave + '\'' +
				", user='" + user + '\'' +
				'}';
	}
}
