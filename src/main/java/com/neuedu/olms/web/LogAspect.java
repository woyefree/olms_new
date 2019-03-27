package com.neuedu.olms.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class LogAspect {
	
	private static Logger log = Logger.getLogger(LogAspect.class);
	
	public void before() {
		ServletRequestAttributes rs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = rs.getRequest();
		
		log.info(req.getRemoteAddr() + "�����ַ��" + req.getRequestURI());
		Enumeration<String> keys = req.getParameterNames();
		log.info("���������");
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			log.info(key + ":" + req.getParameter(key));
		}
	}
	public void afterReturning(Object retVal) {
		log.info("����i��Ϣ:" + retVal);
	}
}
