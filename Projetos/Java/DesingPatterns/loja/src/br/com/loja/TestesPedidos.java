package br.com.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.loja.pedido.GeraPedido;
import br.com.loja.pedido.GeraPedidoHandler;
import br.com.loja.pedido.acao.EnviarEmailPedido;
import br.com.loja.pedido.acao.SalvarPedidonoBancoDeDados;

public class TestesPedidos {

	public static void main(String[] args) {
		String cliente = "Rafael Tomás";
		BigDecimal valorOrcamento = new BigDecimal("300");
		int quantidadeItens = Integer.parseInt("2");
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(
				Arrays.asList(new SalvarPedidonoBancoDeDados(), new EnviarEmailPedido())
				);
		handler.execute(gerador);
	}

}
