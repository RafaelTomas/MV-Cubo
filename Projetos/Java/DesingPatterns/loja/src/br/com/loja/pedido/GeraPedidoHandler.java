package br.com.loja.pedido;

import java.time.LocalDateTime;

import br.com.loja.orcamento.Orcamento;

public class GeraPedidoHandler {
	//construtor com injecao de dependencias:repo, serv
	
	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(),dados.getQuantidadeItens());	
		
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		System.out.println("Salvar pedido no Banco de dados ");
		System.out.println("Nota Fiscal");
	}

}
