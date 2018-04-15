package com.possenti.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.weaver.tools.cache.GeneratedCachedClassHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.possenti.aopdemo.Account;
import com.possenti.aopdemo.dao.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.possenti.aopdemo.service.*.getFortune(..))")
	public Object arroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		// display the method signature
		String method = proceedingJoinPoint.getSignature().toShortString(); 
		logger.info("Executing @around on Method:" + method);
		
		long begin = System.currentTimeMillis();
		
		//execute the method
		Object result = proceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		logger.info("\n=====>Duration: " + duration/ 1000.0 + " seconds");
		
		return result;
	}
	
	
	@After("execution(* com.possenti.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		// display the method signature
		String method = joinPoint.getSignature().toShortString(); 
		logger.info("Executing @after on Method:" + method);
	}
	
	
	
	@AfterThrowing(
			pointcut="execution(* com.possenti.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="excep")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,Throwable excep) {
		// display the method signature
		String method = joinPoint.getSignature().toShortString(); 
		logger.info("Executing @afterThrowing on Method:" + method);
		
		logger.info("EXCEPTION========> " + excep);
	}
	
	
	///add a new advice for @AfterRerturning on the findAccounts method 
	@AfterReturning(
			pointcut="execution(* com.possenti.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint,
												List<Account> result) {
		// display the method signature
		String method = joinPoint.getSignature().toShortString(); 
		logger.info("Executing @afterReturning on Method:" + method);
		
		logger.info("RESULT========> " + result);
		
		convertAccountsNamesToUpperCase(result);
		
		logger.info("RESULT========> " + result);
		
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
		logger.info("\n=========> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature(); 
		logger.info("Method:" + methodSig);
		
		// display method arguments 
		
		//get the args
		Object[]  args = joinPoint.getArgs();
		
		//loop thru args
		for(Object arg : args) {
			logger.info(arg.toString());
			if(arg instanceof Account) {
				Account account = (Account) arg; 
				logger.info("account name: " + account.getName());
				logger.info("account level: " + account.getLevel());
			}
		}
		
	}
	
	
}
