package com.example.demo.dto;

import java.util.List;

public class EmployeeColumnDto {
	String token;
	
	List<EmployeeDataDto> data;

	public String getToken() {
		return token;
	}

	public EmployeeColumnDto setToken(String token) {
		this.token = token;
		return this;
	}

	public List<EmployeeDataDto> getData() {
		return data;
	}

	public EmployeeColumnDto setData(List<EmployeeDataDto> data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "EmployeeColumnDto [token=" + token + ", data=" + data + "]";
	}


}
