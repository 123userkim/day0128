package com.example.demo.commons;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {
	 
		//예외에 대한 정보도 알고 싶고, 타깃메소드에 대한 정보도 알고자 할 때
		//반드시 JoinPoint를 첫 번째 매개변수로 두어야 함
		@AfterThrowing(pointcut = "execution(public * com.example.demo.dao..*(..))", 
				throwing="ex") 
		//특정 예외를 한정지을 수 있음: Exception
		public void afterError(JoinPoint joinPoint, Exception ex) {
			String methodName = joinPoint.getSignature().toShortString();		
			System.out.println("---------------------------------");
			System.out.println(methodName+"타깃메소드에서 다음의 예외가 발생하였습니다.");
			System.out.println(ex.getMessage());
			System.out.println("---------------------------------");
			//타깃메소드에서 다음의 예외가 발생하였습니다./ by zero
			
		}
		
		
/*
		//타깃이 되는 메소드가 정상적으로 종료하거나 오류가 나거나 반드시 동작하는 어드바이스
		@After("daoPoint()")
		public void after(JoinPoint joinPoint) {
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName + "메소드가 종료하였습니다.");
		}
		
/*		
		//@AfterThrowing: 타깃이 되는 메소드가 비정상 종료되었을 때
		@AfterThrowing("daoPoint()")
		public void afterError(JoinPoint joinPoint) {
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName + "메소드가 비정상 종료되었습니다.");
		}
/*		
		//@AfterReturning : 타깃이 되는 메소드가 성공적으로 완료되었을 때 가동하는 
		@AfterReturning("daoPoint()")
		public void  afterOK(JoinPoint joinPoint) {
			String methodName = joinPoint.getSignature().toShortString();
			
			System.out.println( methodName +"동작 후 입니다.");
		}
	
	/*	
		//@Pointcut("execution(public int com.example.demo.dao..*(..))")
		//라고 한다면 메소드 반환값이 int인 것만 해당한다는 말임
		@Pointcut("execution(public int com.example.demo.dao..*(..))")
		public void daoPoint() {
			
		}
		
		@After("daoPoint()")
		public void  after() {
			System.out.println("타깃 메소드 동작 후 입니다.");
		}
*/
	
	
}
