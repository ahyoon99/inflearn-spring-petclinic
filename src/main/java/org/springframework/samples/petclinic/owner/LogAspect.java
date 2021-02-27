package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect {

	Logger logger = LoggerFactory.getLogger(LogAspect.class);

	// LogExecutionTime이라는 애노테이션 주변에 아래 코드들을 적용하겠다라는 의미이다.
	// 이 애노테이션을 사용하면 method안에서 joinPoint라는 parameter를 받을 수 있다.
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {	// joinPoint는 target(@LogExecutionTime이 붙은 method)이다.
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		// joinPoint를 실행하겠다. 그리고 결과가 있다면 proceed로 받겠다.
		Object proceed = joinPoint.proceed();

		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());

		// joinPoint 실행 결과가 있다면 받아서 리턴해주겠다.
		return proceed;
	}
}
