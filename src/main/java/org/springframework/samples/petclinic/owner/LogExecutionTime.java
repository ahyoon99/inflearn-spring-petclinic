package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)	// 이 어노테이션을 어디에 쓸 수 있는지 target을 사용하여 method에다 쓸 것이라고 알려준다.
@Retention(RetentionPolicy.RUNTIME)	// 이 어노테이션 정보를 언제까지 유지할 것인가. Runtime까지 유지할 것이다.
public @interface LogExecutionTime {

}
