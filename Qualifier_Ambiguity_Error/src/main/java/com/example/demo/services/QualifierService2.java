package com.example.demo.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.service.interfaces.IQualifierService;

@Service
@Qualifier("service2")
public class QualifierService2  implements IQualifierService{

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return "I am in Qualfier Service 2";
	}

}
