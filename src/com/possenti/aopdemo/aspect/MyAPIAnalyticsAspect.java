package com.possenti.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyAPIAnalyticsAspect {
	
	@Before("com.possenti.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("\n=========> Performing API Analytics");
	}
}
