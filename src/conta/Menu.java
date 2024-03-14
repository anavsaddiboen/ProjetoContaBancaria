package conta;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.repository.InMemoryRepository;

public class Menu {

	private static ContaController controle = new ContaController(new InMemoryRepository(new LinkedList<Conta>()));

	public static void main(String[] args) {
		Menu.telaInicial();
	}

	private static void telaInicial() {

		StringBuilder telaInicial = new StringBuilder();
		telaInicial.append("*****************************************************************************************\n");
		telaInicial.append("***************************** BEM-VINDO AO BANCO, INVENÇÃO! *****************************\n");
		telaInicial.append("*****************************************************************************************\n");
		telaInicial.append("*                                                                                       *\n");
		telaInicial.append("*****************************************************************************************\n");
		telaInicial.append("* O QUE DESEJA FAZER?                                                                   *\n");
		telaInicial.append("*                                                                                       *\n");
		telaInicial.append("* 1. CRIAR UMA NOVA CONTA                                                               *\n");
		telaInicial.append("* 2. ACESSAR CONTA                                                                      *\n");
		telaInicial.append("* 3. LISTAR TODAS AS CONTAS                                                             *\n");
		telaInicial.append("* 4. ENCERRAR UMA CONTA                                                                 *\n");
		telaInicial.append("* 5. SAIR                                                                               *\n");
		telaInicial.append("*****************************************************************************************\n");
		System.out.println(telaInicial.toString());

		try (Scanner scan = new Scanner(System.in)) {
			boolean telaValida = false;

			while (!telaValida) {
				System.out.print("Opção: ");
				int tela = scan.nextInt();
				switch (tela) {
				case 1:
					Menu.telaCadastroConta();
					telaValida = true;
					break;
				case 2:
					Menu.telaAcessoConta();
					telaValida = true;
					break;
				case 3:
					Menu.telaListaContas();
					telaValida = true;
					break;
				case 4:
					Menu.telaEncerraConta();
					telaValida = true;
					break;
				case 5:
					Menu.telaSaida();
					telaValida = true;
					break;
				default:
					System.out.println("Valor inválido. Tente novamente.");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("O valor inserido não é um número inteiro.");
		}
	}

	private static void telaCadastroConta() {
		Scanner scan = new Scanner(System.in);
		System.out.println("*****************************************************************************************");
		System.out.println("*                               CRIAR UMA NOVA CONTA                                    *");
		System.out.println("*****************************************************************************************");
		System.out.println("*    DIGITE O NOME DO CLIENTE:                                                          *");
		System.out.println("*****************************************************************************************");
		String nome = scan.nextLine();
		System.out.println("*****************************************************************************************");	
		System.out.println("*    SELECIONE O TIPO DE CONTA:                                                         *");
		System.out.println("*                                                                                       *");
		System.out.println("*    1. CONTA CORRENTE                                                                  *");
		System.out.println("*    2. CONTA POUPANÇA                                                                  *");
		System.out.println("*****************************************************************************************");
		int opcao = scan.nextInt();
		 
		switch (opcao) {
		case 1:
			Conta conta = new ContaCorrente(nome, 1);
			controle.cadastrar(conta);
			System.out.println("*    CADASTRO CONTA CORRENTE                                                            *");
			break;
		
		case 2:
			System.out.println("*    CADASTRO CONTA POUPANÇA                                                            *");
			break;
		default:
			System.out.println("*    Opção Inválida, tente novamente!                                                   *\n");
			Menu.telaCadastroConta();
		}
		
	}

	private static void telaAcessoConta() {
		System.out.println("telaAcessoConta");
	}

	private static void telaListaContas() {
		System.out.println("telaListaContas");
	}

	private static void telaEncerraConta() {
		System.out.println("telaEncerraConta");
	}

	private static void telaSaida() {
		System.exit(0);
	}
}
