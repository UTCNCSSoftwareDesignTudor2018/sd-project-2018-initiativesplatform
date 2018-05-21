package com.application.initiatives_platform.InitiativesPlatformServer.data.entity;

public class UserType {

	public String type;

	private UserType(String type) {
		super();
		this.type = type;
	}

	public static final UserType REGISTERED_USER = new UserType("RegisteredUser");

	public static final UserType CONTENT_SUPERVISOR = new UserType("ContentAdvisor");

	public static final UserType SYSTEM_ADMIN = new UserType("SystemAdmin");

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserType other = (UserType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
