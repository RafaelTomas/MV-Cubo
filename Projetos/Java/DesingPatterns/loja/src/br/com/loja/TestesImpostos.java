package br.com.loja;

import java.math.BigDecimal;

import br.com.loja.imposto.CalculadoraDeImposto;
import br.com.loja.imposto.ICMS;
import br.com.loja.imposto.ISS;
import br.com.loja.imposto.Imposto;
import br.com.loja.orcamento.Orcamento;

public class TestesImpostos {

	public static void main(String[] args) {

		Orcamento orcamento = new Orcamento(new BigDecimal("3500"));
		CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
		System.out.println(calculadora.calcular(orcamento, new ICMS()));

	}

}
