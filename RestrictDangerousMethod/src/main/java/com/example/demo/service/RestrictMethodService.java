package com.example.demo.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.example.demo.annotation.RestrictMethod;
import com.example.demo.exception.RestrictMethodException;

//import com.example.demo.exception.RestrictMethodException;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RestrictMethodService {

	private final HttpServletRequest request;

	public RestrictMethodService(HttpServletRequest request) {
		this.request = request;
	}

	@Around("@within(com.example.demo.annotation.RestrictMethod) || @annotation(com.example.demo.annotation.RestrictMethod)")
	public Object restrictMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		Class<?> targetClass = joinPoint.getTarget().getClass();
		RestrictMethod restrictMethodAnnotation = targetClass.getAnnotation(RestrictMethod.class);
		if (restrictMethodAnnotation != null) {
			boolean restrict = restrictMethodAnnotation.value();
			if (restrict) { // If restriction is enabled, check the HTTP method
				String method = request.getMethod();
				if (HttpMethod.GET.matches(method) || HttpMethod.POST.matches(method)) {
					return joinPoint.proceed();
				} else {
					System.out.println("Inside Not Allowed Method: " + method);
					throw new RestrictMethodException("Method Not Allowed. Only POST and GET methods are allowed.");
				}
			}
		}
		return joinPoint.proceed();
	}

}
