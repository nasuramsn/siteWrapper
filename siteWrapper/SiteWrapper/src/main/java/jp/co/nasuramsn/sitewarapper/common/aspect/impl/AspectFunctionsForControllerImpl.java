package jp.co.nasuramsn.sitewarapper.common.aspect.impl;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import jp.co.nasuramsn.sitewarapper.common.aspect.AspectFunctionsForController;
@Aspect
@Component
// Class For Logging when target starts
public class AspectFunctionsForControllerImpl implements AspectFunctionsForController {

	private Logger logger = Logger.getLogger(AspectFunctionsForControllerImpl.class);

	@Before("execution(* jp.co.nasuramsn.sitewarapper.app.controller.*.*(..))")
	public void beforeFunction(JoinPoint jp) {
		//System.out.println("Execute開始: " + jp.getSignature());
		logger.info("Execute開始: " + jp.getSignature());
	}

	@AfterReturning("execution(* jp.co.nasuramsn.sitewarapper.app.controller.*.*(..))")
	public void afterReturnFunction(JoinPoint jp) {
		//System.out.println("Execute正常終了: " + jp.getSignature());
		logger.info("Execute正常終了: " + jp.getSignature());
	}

	@AfterThrowing("execution(* jp.co.nasuramsn.sitewarapper.app.controller.*.*(..))")
	public void afterThrowFunction(JoinPoint jp) {
		//System.out.println("Execute例外終了: " + jp.getSignature());
		logger.info("Execute例外終了: " + jp.getSignature());
	}
}
