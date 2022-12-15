package br.com.loja;

import java.math.BigDecimal;

import br.com.loja.imposto.ICMS;
import br.com.loja.imposto.ISS;
import br.com.loja.imposto.Imposto;
import br.com.loja.orcamento.ItemOrcamento;
import br.com.loja.orcamento.Orcamento;

public class TestesImposto {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200")));

		Imposto imposto = new ICMS(new ISS(null));
		System.out.println(imposto.calcular(orcamento));
	}

}
