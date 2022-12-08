package Testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import servidor.Maquina;


class ValidateStockTest {

	@Test
	@DisplayName("Checar Estoque")
	void checar_estoque() {

		Maquina machine = new Maquina();
		machine.add_produto_na_maquina("Guarana", 6.5);
		assertTrue(machine.validar_estoque());
	}
	
}

