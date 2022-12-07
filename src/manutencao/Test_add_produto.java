package manutencao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AddProductOnMachineTest {
	@Test
	@DisplayName("test_add_product_on_macinhe")
	void teste_adicionar_produto_maquina() {

		Maquina machine = new Maquina();

		machine.add_produto_na_maquina("coca-cola", 7.5);

		machine.add_produto_na_maquina("fanta", 5);

		machine.add_produto_na_maquina("guarana jesus", 4.5);

		machine.add_produto_na_maquina("pepsi pode ser", 6);

	}

}