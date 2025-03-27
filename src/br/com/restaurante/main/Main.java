package br.com.restaurante.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.restaurante.exceptions.OpcaoInvalidoException;
import br.com.restaurante.model.Bebida;
import br.com.restaurante.model.Cardapio;
import br.com.restaurante.model.Pedido;
import br.com.restaurante.model.Prato;

public class Main {

	public static void main(String[] args) throws OpcaoInvalidoException {

		System.out.println("Bem-Vindo ao Delivery do nosso Restaurante");
		
		Cardapio cardapio = new Cardapio();
		
		
	}
	
	public void listarPratosBebidas(Cardapio cardapio) {
		System.out.println("###### CARDÁPIO ######");
		
		for (Prato prato : cardapio.getPratos().values()) {
			prato.exibirPrato();
		}
		
		for (Bebida bebida : cardapio.getBebidas().values()) {
			bebida.exibirBebida();
		}
	}

	public void criarPedido(Cardapio cardapio) {
		listarPratosBebidas(cardapio);
		
		Scanner input = new Scanner(System.in);

		System.out.println("Selecione os pratos que deseja (digite 0 para finalizar): ");
		
		List<Prato> pratos = new ArrayList<Prato>();
		
		int codigoSelecionado = -1;
		while (codigoSelecionado != 0) {
			codigoSelecionado = input.nextInt();
			
			Prato prato = cardapio.getPratos().get(codigoSelecionado);
			if (prato == null) {
				throw new OpcaoInvalidoException("Prato inválido!");
			}
			else {
				pratos.add(prato);
			}
		}

		System.out.println("Selecione as bebidas que deseja (digite 0 para finalizar): ");
		
		List<Bebida> bebidas = new ArrayList<Bebida>();
		
		codigoSelecionado = -1;
		while (codigoSelecionado != 0) {
			codigoSelecionado = input.nextInt();
			
			Bebida bebida = cardapio.getBebidas().get(codigoSelecionado);
			if (bebida == null) {
				throw new OpcaoInvalidoException("Opção inválida!");
			}
			else {
				bebidas.add(bebida);
			}
		}

		System.out.println("Digite o endereço de entrega: ");
		String endereco = input.next();
		
		Pedido pedido = new Pedido(endereco, pratos, bebidas);
		pedido.fazerPedido();
	}
	
	public void verificarStatus() {
		
	}
}
