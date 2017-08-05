package jp.co.nasuramsn.sitewarapper.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Interface For Logging when target starts
public interface AspectFunctionsForController {
	public void beforeFunction(JoinPoint jp);
	public void afterReturnFunction(JoinPoint jp);
	public void afterThrowFunction(JoinPoint jp);
}
