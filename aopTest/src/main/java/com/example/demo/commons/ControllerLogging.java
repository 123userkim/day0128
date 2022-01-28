package com.example.demo.commons;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//자동스캔
@Component
@Aspect//aop설정
public class ControllerLogging {
/*	
		//execution(public * com.example.demo.controller..*(..))포인트 컷의 아이디를 
		//mypoint라고 주기
		@Pointcut("execution(public * com.example.demo.controller..*(..))")
		public void mypoint() {
			
		}
		
		//@Around반드시 joinpoint를 가져야함
		//메소드 안에서 타깃을 동작함
		
		@Around("mypoint()")
		public  Object around(ProceedingJoinPoint joinPoint) {
			
			//joinPoint으로 타깃이 되는 메소드 이름을 알 수 있음
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName +"동작전입니다.");
		long start = System.currentTimeMillis();
			
			
			Object re = null;
			
			try {
				  re= 	joinPoint.proceed();
					//타깃이되는 메소드를 호출함
					//이 명령어를 기준으로 윛쪽에 작성하면 타깃이 동작하기 전에 수행
					//이 명령어 아래쪽에 작성하면 타깃이 동작한 후에 수행
			}catch (Throwable e) {
				// TODO: handle exception
			}
			long end = System.currentTimeMillis();
			System.out.println(methodName +"동작후입니다.");
			System.out.println("걸린시간 : "+(end-start));
		
			return re;			
		}
	
	/*	
		//공통관심사항으로 무조건 이 메소드를 동작시켜야 함
		//위의 메소드들이 동작하기 전에, 로깅이 먼저 동작함
		@Before("mypoint()")
		public void pro() {
			System.out.println("로깅입니다.");
		}
	*/	
		
	/*	@Before("mypoint()") 
		public void pro2() {
			System.out.println("변경된 로깅입니다.");
		}
		
	*/
		
	/*	
		@After("mypoint()") 
		public void pro2() {
			System.out.println("변경된 로깅입니다.");
		}
		
	*/
}
