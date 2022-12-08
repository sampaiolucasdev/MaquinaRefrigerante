package servidor;

public class Caixa {
	private double dinheiro_caixa = 0, dinheiro_vendas = 0;
	
	
	//metodo para realizar a valida��o do dinheiro inserido na maquina
	public boolean validar_insercao(String cash) throws Exception {
		try {
			double dinheiro_convertido = Double.parseDouble(cash);
			double[] dinheiro_aceito = { 0.5, 1.0, 2.0, 5.0, 10.0 };
			boolean return_flag = false;

			for (int i = 0; i < dinheiro_aceito.length; i++) {
				if (dinheiro_aceito[i] == dinheiro_convertido) {
					return_flag = true;
				}
			}

			return return_flag;
		} catch (Exception e) {
			return false;
		}
	}
	//metodo para adicionar o dinheiro no caixa
	public void add_dinheiro_no_caixa(String cash) throws Exception {
		if (this.validar_insercao(cash)) {
			this.dinheiro_caixa = this.dinheiro_caixa + Double.parseDouble(cash);
			this.relatorio_de_caixa();
		} else {
			throw new Exception("Insira um valor valido para o troco!");
		}
	}
	//metodo para adi��o de dinheiro das vendas
	public void add_dinheiro_vendas(double cash) {
		this.dinheiro_vendas = this.dinheiro_vendas + cash;
	}
	//metodo para obter os valores das vendas que foram realizadas
	public double obter_retorno_da_venda(double produto_preco, double valor_venda_produto) throws Exception {
		double troco = valor_venda_produto-produto_preco;
		
		if (troco > this.dinheiro_caixa) {
			throw new Exception("Saldo insuficiente para troco!");
		}
		
		this.dinheiro_caixa = this.dinheiro_caixa-troco;
		return troco;
	}
	//relatorio de caixa
	public void relatorio_de_caixa() {
		System.out.println("\n\n======================================");
		System.out.println("             SALDO DO CAIXA           ");
		System.out.println("======================================");
		System.out.printf("======== Disponível: %.2f   ==========\n", this.dinheiro_caixa);
		System.out.printf("======= Receita de Vendas:%.2f  ===== \n", this.dinheiro_vendas);
		System.out.println("======================================");
	}
}
