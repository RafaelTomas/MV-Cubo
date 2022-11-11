package br.com.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.loja.orcamento.Orcamento;
import br.com.loja.pedido.acao.AcaoaposGerarPedido;

public class GeraPedidoHandler {
	
	private List<AcaoaposGerarPedido> acoes;
		
	public GeraPedidoHandler(List<AcaoaposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(),dados.getQuantidadeItens());	
		
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		acoes.forEach(a -> a.executarAcao(pedido));
	}

}
