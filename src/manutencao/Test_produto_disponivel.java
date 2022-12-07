package manutencao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produtos.Produtos;

class get_product_from_catalog {
	@Test
	@DisplayName("check_is_product_available")
	void verifique_produto_disponivel() {
		Maquina mchine = new Maquina();
		assertNotNull(mchine.obter_produto_do_catalogo(0));
	}

	private void assertNotNull(Produtos get_product_from_catalog) {
		// TODO Auto-generated method stub
		
	}
}
