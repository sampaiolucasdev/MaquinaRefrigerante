package Testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import servidor.Maquina;


class AddProductOnMachineTest {
	@Test
	@DisplayName("Cadastrar Produto")
	void teste_adicionar_produto_maquina() {

		Maquina machine = new Maquina();

		machine.add_produto_na_maquina("Coca", 6);

		machine.add_produto_na_maquina("Guaraná", 4.5);

		machine.add_produto_na_maquina("Soda", 7.5);

		machine.add_produto_na_maquina("Kuat", 5);

	}

}