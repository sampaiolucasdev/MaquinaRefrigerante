package servidor;

import java.util.Scanner;

import cliente.Compra;

public class Soda {
	static Caixa cashdesk = new Caixa();
	static Maquina machine = new Maquina();
	static Compra purchase = new Compra();


	public static void main(String[] args) {
		String validate_process = "";
		Scanner input = new Scanner(System.in);

		System.out.println("====== MAQUINA DE REFRIGERANTE ======\n");
		

		// adicionar dinheiro no caixa que ser� usado como reembolso em dinheiro
		System.out.println("Dinheiro Inserido!\n============ INSTRUÇÕES =============\n");
		System.out.println("Cédulas Aceitas: \n R$ 2,00 | R$ 5,00 | R$ 10,0 ");
		System.out.println("Moedas Aceitas: \n R$ 1,00 | R$ 0,50");
		System.out.println("- DIGITE 'sair' A QUALQUER MOMENTO PARA ENCERRAR!");
		System.out.println("======================================");
		do {
			System.out.println("\nDigite a quantidade de dinheiro que deseja inserir: \n");
			String cash = input.nextLine();

			if (cash.equals("sair")) {
				validate_process = "sair";
				continue;
			}

			try {
				cashdesk.add_dinheiro_no_caixa(cash);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("\n\n");
		} while (!validate_process.equals("sair"));
		validate_process = "";
		// fim para adicionar dinheiro no reembolso em dinheiro


		// routine to add products on machine
		System.out.println("====================================");
		System.out.println("         CADASTRO DE PRODUTOS!      ");
		System.out.println("====================================\n- Insira nome e preço do produto abaixo:  \n");
		System.out.println(
				"- DIGITE 'sair' A QUALQUER MOMENTO PARA ENCERRAR! \n\n");
		do {

			System.out.print("Nome: ");
			String name = input.nextLine();
			if (name.equals("sair")) {
				validate_process = "sair";
				continue;
			}

			System.out.print("Preço: ");
			String price = input.nextLine();
			if (price.equals("sair")) {
				validate_process = "sair";
				continue;
			}

			double converted_price;
			try {
				converted_price = Double.parseDouble(price);
			} catch (Exception e) {
				System.out.println("Insira um preço valido;");
				continue;
			}

			machine.add_produto_na_maquina(name, converted_price);
			System.out.println("\n\n");
		} while (!validate_process.equals("sair"));
		validate_process = "";
		// end of routine to add products

		// routine to execute a purchase
		if (machine.validar_estoque()) {
			System.out.println("-----------------------------------------------");
			System.out.println("\nInserido o dinheiro pra pagamento na maquina!\n");
			System.out.println("==========================================");
			System.out.println("               INSTRUÇÕES                 ");
			System.out.println("==========================================");
			System.out.println("\nCédulas Aceitas: \n R$ 2,00 | R$ 5,00 | R$ 10,0 ");
			System.out.println("Moedas Aceitas: \n R$ 1,00 | R$ 0,50 ");
			System.out.println("\n- DIGITE 'sair' A QUALQUER MOMENTO PARA ENCERRAR!\n");
			System.out.println("==========================================");

			machine.exibir_itens_disponiveis_no_catalogo();
			String paycash;
			do {
				System.out.println("\nInsira o dinheiro para pagamento ou digite 'sair'!");
				paycash = input.nextLine();

				if (paycash.equals("sair")) {
					validate_process = "sair";
					continue;
				}

				try {
					purchase.adicionar_dinheiro_de_compra(cashdesk, paycash);
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("\n\n");
			} while (!validate_process.equals("sair"));
			validate_process = "";

			try {
				machine.exibir_itens_disponiveis_no_catalogo();
				System.out.print("\nSelecione o produto digitando seu código: ");
				int product_code = input.nextInt();
				purchase.realizar_compra(machine, cashdesk, product_code);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("Estoque vazio!");
		}
		// fim da realiza��o da compra
      input.close();
	}

}