package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import servidor.Caixa;

class Verificar_dinheiro {

	@Test
	@DisplayName("check_entered_cash")
	void verificar_insercao() {
		
		Caixa cashdesk = new Caixa();
		assertAll("validation", () -> assertTrue(cashdesk.validar_insercao("0.50")),
				() -> assertTrue(cashdesk.validar_insercao("1")),
				() -> assertTrue(cashdesk.validar_insercao("2")),
				() -> assertTrue(cashdesk.validar_insercao("5")),
				() -> assertTrue(cashdesk.validar_insercao("10")));
	}

}
