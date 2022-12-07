package caixa;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.Exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class get_sale_paybackTest {
	@Test
	@DisplayName("check_payback_amount")
	void verificar_valor_reembolso() throws Exception {
		
		Caixa cashdesk = new Caixa();
		cashdesk.add_dinheiro_no_caixa("10");
		assertEquals(1.5, cashdesk.obter_retorno_da_venda(5.5, 7), "5.5 - 7 \r\n" + "deve ser igual 1.5");	
	}
	
	@Test
	@DisplayName("exceptionTesting")
	void verificar_dinheiro_disponivel_caixa() throws Exception {
		Caixa cashdesk = new Caixa();
		Exception exception = assertThrows(Exception.class, () -> cashdesk.obter_retorno_da_venda(5.5, 7));
		assertEquals("Saldo insuficiente para troco!", exception.getMessage());
	}
}