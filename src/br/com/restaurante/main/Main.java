package br.com.restaurante.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.restaurante.exceptions.OpcaoInvalidoException;
import br.com.restaurante.model.Bebida;
import br.com.restaurante.model.Cardapio;
import br.com.restaurante.model.Pedido;
import br.com.restaurante.model.Prato;

public class Main {

	public static void main(String[] args) throws OpcaoInvalidoException, SQLException {

		System.out.println("Bem-Vindo ao Delivery do nosso Restaurante");
		
		Cardapio cardapio = new Cardapio();

		Pedido pedido = criarPedido(cardapio);

		verificarStatus(1, pedido);



	}

	public static  Pedido criarPedido(Cardapio cardapio) throws SQLException {
		cardapio.listarPratosBebidas();
		
		Scanner input = new Scanner(System.in);

		System.out.println("Selecione os pratos que deseja (digite 0 para finalizar): ");
		int codigoSelecionado = -1;
		
		List<Prato> pratos = new ArrayList<Prato>();

		while (codigoSelecionado != 0) {
			codigoSelecionado = input.nextInt();

			if(codigoSelecionado != 0) {
				Prato prato = cardapio.getPratos().get(codigoSelecionado);
				if (prato == null) {
					throw new OpcaoInvalidoException("Prato inválido!");
				}
				else {
					pratos.add(prato);
				}
			}

		}

		System.out.println("Selecione as bebidas que deseja (digite 0 para finalizar): ");
		
		List<Bebida> bebidas = new ArrayList<Bebida>();
		
		codigoSelecionado = -1;
		while (codigoSelecionado != 0) {
			codigoSelecionado = input.nextInt();

			if(codigoSelecionado != 0) {
				Bebida bebida = cardapio.getBebidas().get(codigoSelecionado);
				if (bebida == null) {
					throw new OpcaoInvalidoException("Opção inválida!");
				}
				else {
					bebidas.add(bebida);
				}
			}

		}

		System.out.println("Digite o endereço de entrega: ");
		String endereco = input.next();
		
		Pedido pedido = new Pedido(endereco, pratos, bebidas);
		pedido.fazerPedido();

		return pedido;
	}
	
	public static void verificarStatus(Integer idPedido, Pedido pedido) throws SQLException {
		System.out.println("Digite o id do pedido: ");

		Scanner input = new Scanner(System.in);
		idPedido = input.nextInt();

		pedido.verificarStatus(idPedido);
	}
}
