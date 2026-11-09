package com.betacom.ju;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyProvaTest {
	
	@Test
	public void calcolaTest() {
		MyProva p = new MyProva();
		
		Assertions.assertThat(p.calcola(5, 2)).isEqualTo(7);
	}
}
