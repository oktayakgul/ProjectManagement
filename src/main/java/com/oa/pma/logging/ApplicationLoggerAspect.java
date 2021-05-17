package com.oa.pma.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.oa.pma.controller..*)")
	public void definePackagePointcuts(){
		// empty method just to name the location specified in the pointcut
	}
	
	@Around ("definePackagePointcuts()") // at Before you dont have any info, args
	public Object logBefore(ProceedingJoinPoint jp){
		log.debug("\n-----------------------------Before-----------------------------\n {}.{} with arguments [s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),
				Arrays.toString(jp.getArgs()));
		log.debug("\n----------------------------------------------------------------\n");
		
		Object o = null;
		try {
			o = jp.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		log.debug("\n-----------------------------After------------------------------\n {}.{} with arguments [s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),
				(jp.getArgs().length != 0 ? (jp.getArgs()[0]) : "null here")); //burası daha anlaşılır olarak düzeltilebilir. array tostring override et
		log.debug("\n----------------------------------------------------------------\n");
		
		return o;
	}
	
	public static String objectToJson(Object value){
		ObjectMapper mapper = new ObjectMapper();
		String str = null;
		try {
			str = mapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
