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
		
		cardapio.listarPratosBebidas();
	}

	public void criarPedido(Cardapio cardapio) throws SQLException {
		cardapio.listarPratosBebidas();
		
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
