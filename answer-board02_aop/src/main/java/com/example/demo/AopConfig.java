package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	private void mypoint() {
		
	}
	
	@Before("mypoint()")
	//선택적으로 joinpoint를 넣어서
	//타킷메소드의 이름을 알아옴
	public void beforeJoin(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"타깃메소드 동작전");
		
		//타깃 메소드의 첫번째 매개변수를 갖고 옴
		//HttpServletRequest request로 형변환
		HttpServletRequest request =(HttpServletRequest) joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip= request.getRemoteAddr();
		System.out.println("uri:"+uri);
		System.out.println("ip:"+ip);
		System.out.println("==========================");
	}
}
