package manutencao;

import java.util.ArrayList;

import produtos.Produtos;

public class Maquina {
	private int contagem_produtos = 0;
	private ArrayList<Produtos> produtos = new ArrayList<Produtos>();
	//metodo de adicionar produto na maquina
	public void add_produto_na_maquina(String name, double preco) {
		this.produtos.add(new Produtos(contagem_produtos, name, preco));
		System.out.println("\nProduto adicionado!");
		this.contagem_produtos++;
	}
	//valida��o de estoque
	public boolean validar_estoque() {
		return !this.produtos.isEmpty();
	}
	//exibir produtos disponiveis
	public void exibir_itens_disponiveis_no_catalogo() {
		// code block to display array list
		System.out.println("codigo | nome | preço");
		for (int i = 0; i < this.produtos.size(); i++) {
			System.out.println(this.produtos.get(i).getId() + "      | " + this.produtos.get(i).getName() + " | "
					+ this.produtos.get(i).getPrice());
		}
	}
	//obter os proodutos do catalogo
	public Produtos obter_produto_do_catalogo(int codigo_produto) {
		for (int i = 0; i < this.produtos.size(); i++) {
			System.out.println(this.produtos.get(i).getId());
			if (this.produtos.get(i).getId() == codigo_produto) {
				return this.produtos.get(i);
			}
		}

		return null;
	}
	//remover produto quando for realizado a venda
	public void remover_produto_do_catalogo(Produtos produto) {
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i).getId() == produto.getId()) {
				this.produtos.remove(produto);
			}
		}
	}
}
