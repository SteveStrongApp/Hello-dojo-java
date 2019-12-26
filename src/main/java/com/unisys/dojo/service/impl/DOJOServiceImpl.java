package com.unisys.dojo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisys.dojo.domain.Response;
import com.unisys.dojo.payload.ResponseDetails;
import com.unisys.dojo.repository.ResponseRepository;
import com.unisys.dojo.service.IdojoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DOJOServiceImpl implements IdojoService{
	@Autowired
	private ResponseRepository responseRepository;
	public void submitResponse(ResponseDetails responseDetails) {
		//log.info("testing service");
		//log.info("result="+responseDetails.getUserId());		
		ModelMapper modelMapper = new ModelMapper();
		Response response = modelMapper.map(responseDetails, Response.class);
		responseRepository.save(response);
		//log.info("Saved successfully");
		
	}

}
