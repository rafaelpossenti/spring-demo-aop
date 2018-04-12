package com.possenti.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.possenti.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	//@BeforeAdvice
	@Before("com.possenti.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=========> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature(); 
		System.out.println("Method:" + methodSig);
		
		// display method arguments 
		
		//get the args
		Object[]  args = joinPoint.getArgs();
		
		//loop thru args
		for(Object arg : args) {
			System.out.println(arg);
			if(arg instanceof Account) {
				Account account = (Account) arg; 
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
		
	}
	
	
}
