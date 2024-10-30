package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

@Configuration
public class Config {
	
	    @Bean
	    public ObjectMapper buildObjectMapper() {
	    	ObjectMapper mapper = new ObjectMapper();
	    	mapper.registerModule(new JSR310Module());
	        mapper.setSerializationInclusion(Include.NON_NULL);
	        return mapper;
	    }
	}


