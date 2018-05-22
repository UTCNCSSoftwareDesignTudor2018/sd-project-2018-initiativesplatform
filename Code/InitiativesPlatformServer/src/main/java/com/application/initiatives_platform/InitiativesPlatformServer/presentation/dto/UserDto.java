package com.application.initiatives_platform.InitiativesPlatformServer.presentation.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {

	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;

	@NotNull
	@NotEmpty
	private String idNumber;

	@NotNull
	@NotEmpty
	private String email;

	@NotNull
	@NotEmpty
	private String phone;

	@NotNull
	@NotEmpty
	private String address;

	@NotNull
	@NotEmpty
	private String userName;

	@NotNull
	@NotEmpty
	private String password;

	public UserDto() {
		super();
	}

	public UserDto(@NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName,
			@NotNull @NotEmpty String idNumber, @NotNull @NotEmpty String email, @NotNull @NotEmpty String phone,
			@NotNull @NotEmpty String address, @NotNull @NotEmpty String userName, @NotNull @NotEmpty String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", idNumber=" + idNumber + ", email="
				+ email + ", phone=" + phone + ", address=" + address + ", userName=" + userName + ", password="
				+ password + "]";
	}
}
