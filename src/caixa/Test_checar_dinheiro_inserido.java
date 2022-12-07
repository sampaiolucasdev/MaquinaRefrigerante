package caixa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test_checar_dinheiro_inserido {

	@Test
	@DisplayName("check_entered_cash")
	void checar_inserido_em_dinheiro() {
		
		Caixa cashdesk = new Caixa();
		assertAll("validation", () -> assertTrue(cashdesk.validar_dinheiro_inserido("0.50")),
				() -> assertTrue(cashdesk.validar_dinheiro_inserido("1")),
				() -> assertTrue(cashdesk.validar_dinheiro_inserido("2")),
				() -> assertTrue(cashdesk.validar_dinheiro_inserido("5")),
				() -> assertTrue(cashdesk.validar_dinheiro_inserido("10")));
	}

}
