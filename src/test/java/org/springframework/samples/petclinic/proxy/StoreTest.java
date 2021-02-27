package org.springframework.samples.petclinic.proxy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StoreTest {

	@Test
	public void testPay(){
		Payment cashPerf= new CashPerf();	// CashPerf()로 생성 -> Client code(Store, Cash)에 별다른 코드 추가 없이 성능 측정되는 Payment를 가지게 해준다.
		Store store = new Store(cashPerf);
		store.buySomething(100);
	}

	@Test
	public void testPay2(){
		Payment cashPerf= new Cash();	// Cash()로 생성 -> 성능 측정이 되지 않는 Payment를 가지게 해준다.
		Store store = new Store(cashPerf);
		store.buySomething(100);
	}
}
