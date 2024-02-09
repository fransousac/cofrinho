package uninter;

import java.util.Scanner;

public class Menu {
	
	//Utilizamos a classe scanner para obter dados do usuário
	private Scanner sc;
	private Cofrinho cofrinho;
	
	public Menu() {
		//A variável sc será inicializada quando instanciarmos o objeto menu
		sc = new Scanner(System.in);
		cofrinho = new Cofrinho(); //Instanciamos o cofrinho
		
	}
	
	public void exibirMenuPrincipal() {
		System.out.println("COFRINHO:");
		System.out.println("1-Adicionar moeda");
		System.out.println("2-Remover moeda");
		System.out.println("3-Listar moedas");
		System.out.println("4-Calcular valor total convertido para real");
		System.out.println("0-Encerrar");
		
		// o next permite a digitação de um valor e guarda ele
		String opcaoSelecionada = sc.next();
		
		//Aqui fazemos o tratamento dos casos
		switch(opcaoSelecionada) {
			case "0":
				System.out.println("Fim do programa!");
				break;
				
			case "1":
				exibirSubMenuAdicionarMoedas();
				exibirMenuPrincipal();
				break;
				
			case "2":
				exibirSubMenuRemoverMoedas();
				exibirMenuPrincipal();
				break;
				
				
			case "3":
				cofrinho.listagemMoedas();
				exibirMenuPrincipal();
				break;
				
			case "4":
				double valorTotalConvertido = cofrinho.totalConvertido();
				//Transforma o valor double em uma string
				String valorTotalConvertidoTextual = String.format("%.2f", valorTotalConvertido);
				valorTotalConvertidoTextual = valorTotalConvertidoTextual.replace(".", ",");
				System.out.println("O valor total convertido para real? R$" + valorTotalConvertidoTextual);
				exibirMenuPrincipal();
				break;
			
			
			default:
				System.out.println("Opcao invalida!");
				exibirMenuPrincipal();
				break;
			
		}
	} 
	//Colocamos o submenu aqui para evitar um codigo muito longo no menu
	private void exibirSubMenuAdicionarMoedas() {
		System.out.println("Escolha Moeda");
		System.out.println("1 - Real:");
		System.out.println("2 - Dolar");
		System.out.println("3 - Euro");
		
		int opcaoMoeda = sc.nextInt();
		System.out.println("Digite o valor:");
		
		//Aqui convertemos a vírgula de um valor para ponto.
		String valorTextualMoeda = sc.next();
		
		valorTextualMoeda = valorTextualMoeda.replace(",", ".");
		double valorMoeda = Double.valueOf(valorTextualMoeda);
		
		Moeda moeda = null;
		
		if (opcaoMoeda == 1) {
			moeda = new Real(valorMoeda);
		} else if (opcaoMoeda == 2) {
			moeda = new Dolar(valorMoeda);
		} else if (opcaoMoeda == 3){
			moeda = new Euro(valorMoeda);
		} else {
			System.out.println("Não existe essa moeda!");
			exibirMenuPrincipal();
		}
		
		cofrinho.adicionar(moeda);
		
		
	}
	private void exibirSubMenuRemoverMoedas() {
		System.out.println("Escolha Moeda");
		System.out.println("1 - Real:");
		System.out.println("2 - Dolar");
		System.out.println("3 - Euro");
		
		int opcaoMoeda = sc.nextInt();
		System.out.println("Digite o valor:");
		
		//Aqui convertemos a vírgula de um valor para ponto.
		String valorTextualMoeda = sc.next();
		
		valorTextualMoeda = valorTextualMoeda.replace(",", ".");
		double valorMoeda = Double.valueOf(valorTextualMoeda);
		
		Moeda moeda = null;
		
		if (opcaoMoeda == 1) {
			moeda = new Real(valorMoeda);
		} else if (opcaoMoeda == 2) {
			moeda = new Dolar(valorMoeda);
		} else if (opcaoMoeda == 3){
			moeda = new Euro(valorMoeda);
		} else {
			System.out.println("Não existe essa moeda!");
			exibirMenuPrincipal();
		}
		
		cofrinho.remover(moeda);
	}
}
