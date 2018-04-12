package com.possenti.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.possenti.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	//create pointcut for getter methods 
	@Pointcut("execution(* com.possenti.aopdemo.dao.*.get*(..))")
	public void getter() {};
	
	//create pointcut for setter methos 
	@Pointcut("execution(* com.possenti.aopdemo.dao.*.set*(..))")
	public void setter() {};
	
	//create point: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {};
}
