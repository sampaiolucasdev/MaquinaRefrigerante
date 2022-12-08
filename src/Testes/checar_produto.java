package Testes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import servidor.Maquina;
import servidor.Produtos;

class get_product_from_catalog {
	@Test
	@DisplayName("Checar Produto")
	void checar_produto() {
		Maquina mchine = new Maquina();
		assertNotNull(mchine.obter_produto_do_catalogo(0));
	}

	private void assertNotNull(Produtos get_product_from_catalog) {
		// TODO Auto-generated method stub
		
	}
}
