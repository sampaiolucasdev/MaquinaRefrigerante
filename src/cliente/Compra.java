package cliente;

import servidor.Caixa;
import servidor.Maquina;
import servidor.Produtos;

public class Compra {
	private double valor_pagamento;
	//metodo para realizar a compra dos refrigerantes
	public void realizar_compra(Maquina machine, Caixa cashdesk, int codigo_produto) throws Exception {
		Produtos produto_escolhido = machine.obter_produto_do_catalogo(codigo_produto);

		if (produto_escolhido.getPrice() > this.valor_pagamento) {
			throw new Exception("Valor inválido! Insira um valor conforme as instruções anteriores.");
		}
		//remover produto do catalogo
		machine.remover_produto_do_catalogo(produto_escolhido);
		//adicionar o dinheiro das vendas
		cashdesk.add_dinheiro_vendas(this.valor_pagamento);
		System.out.println("======================================");
		System.out.println("     COMPRA REALIZADA COM SUCESSO!    ");
		System.out.println("======================================");
		System.out.println("           Produto: " + produto_escolhido.getName());
		System.out.printf("           Valor: %.2f \n", produto_escolhido.getPrice());
		System.out.printf("           Pagamento: %.2f \n", this.valor_pagamento);
		double payback = cashdesk.obter_retorno_da_venda(produto_escolhido.getPrice(), this.valor_pagamento);
		System.out.printf("           Troco: %.2f \n", payback);
		System.out.println("======================================");
		cashdesk.relatorio_de_caixa();
		this.valor_pagamento = 0;
	}
	//metodo para adicionar o dinheiro para compra
	public void adicionar_dinheiro_de_compra(Caixa cashdesk, String cash) throws Exception {
		if (cashdesk.validar_insercao(cash)) {
			this.valor_pagamento = this.valor_pagamento + Double.parseDouble(cash);
		} else {
			throw new Exception("Insira um valor válido!");
		}
	}
}
