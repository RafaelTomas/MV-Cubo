package br.com.loja.pedido.acao;

import br.com.loja.pedido.Pedido;

public class SalvarPedidonoBancoDeDados implements AcaoaposGerarPedido {
	
	public void executarAcao(Pedido pedido) {
		System.out.println("Enviando pedidol ao banco de dados");
	}


}
