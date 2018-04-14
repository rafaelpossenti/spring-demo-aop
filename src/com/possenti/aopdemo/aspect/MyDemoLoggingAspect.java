package com.possenti.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterThrowing(
			pointcut="execution(* com.possenti.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="excep")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,Throwable excep) {
		// display the method signature
		String method = joinPoint.getSignature().toShortString(); 
		System.out.println("Executing @afterThrowing on Method:" + method);
		
		System.out.println("EXCEPTION========> " + excep);
	}
	
	
	///add a new advice for @AfterRerturning on the findAccounts method 
	@AfterReturning(
			pointcut="execution(* com.possenti.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint,
												List<Account> result) {
		// display the method signature
		String method = joinPoint.getSignature().toShortString(); 
		System.out.println("Executing @afterReturning on Method:" + method);
		
		System.out.println("RESULT========> " + result);
		
		convertAccountsNamesToUpperCase(result);
		
		System.out.println("RESULT========> " + result);
		
	}
	
	
	private void convertAccountsNamesToUpperCase(List<Account> result) {
		for(Account account: result) {	
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}	
	}


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
