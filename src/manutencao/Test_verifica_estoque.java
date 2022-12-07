package manutencao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ValidateStockTest {

	@Test
	@DisplayName("verificar disponibilidade de estoque")
	void verificar_disponibilidade_estoque() {

		Maquina machine = new Maquina();
		machine.add_produto_na_maquina("coca-cola", 6.5);
		assertTrue(machine.validar_estoque());
	}
	
}

