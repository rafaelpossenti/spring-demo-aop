package com.possenti.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is were we add all our related advices for logging 
	
	@Pointcut("execution(* com.possenti.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	//create pointcut for getter methods 
	@Pointcut("execution(* com.possenti.aopdemo.dao.*.get*(..))")
	private void getter() {};
	
	//create pointcut for setter methos 
	@Pointcut("execution(* com.possenti.aopdemo.dao.*.set*(..))")
	private void setter() {};
	
	//create point: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {};
	
	
	
	
	//@BeforeAdvice
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=========> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n=========> Performing API Analytics");
	}
	
}
