package br.com.loja;

import java.math.BigDecimal;

import br.com.loja.orcamento.ItemOrcamento;
import br.com.loja.orcamento.Orcamento;

public class TestesComposite {

	public static void main(String[] args) {
		Orcamento antigo = new Orcamento();
		antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));

		Orcamento novo = new Orcamento();
		novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		novo.adicionarItem(antigo);

		System.out.println(novo.getValor());
	}

}
