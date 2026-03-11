package com.msedcl.main.aspects;

import com.msedcl.main.config.SpringConfiguration;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* com.msedcl.main.service.*.*(..))")
	public void serviceMethod() {
	}

	@Around("serviceMethod()")
	public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Around before method :: " + proceedingJoinPoint.getSignature().getName());

		proceedingJoinPoint.proceed();

		System.out.println("Around after method :: " + proceedingJoinPoint.getSignature().getName());

	}

	@After("serviceMethod()")
	public void afterAdvice(JoinPoint jointPoint) {
		System.out.println("After method :: " + jointPoint.getSignature().getName());
	}

	@Before("serviceMethod()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before method :: " + joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();
		System.out.println("Parameter " + args[0]);
		if (args[0].toString().contains("!")) {
			System.out.println("Invalid Char supplied !!");
		}
	}
}
