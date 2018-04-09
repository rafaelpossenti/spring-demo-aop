package com.possenti.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is were we add all our related advices for logging 
	
	//@BeforeAdvice
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=========> Executing @Before advice on addAccount()");
	}
	
}
