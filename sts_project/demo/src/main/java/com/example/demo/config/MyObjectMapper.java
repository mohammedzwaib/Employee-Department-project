//package com.example.demo.config;
//
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//
//@Component
//public class MyObjectMapper extends ObjectMapper{
//
//	private static final long serialVersionUID = -19511231076249430L;
//
//	public MyObjectMapper() {
//		super();
//
//		this.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//		this.registerModule(new JavaTimeModule());
//	}
//	
//}
//
//
