package br.com.loja;

import java.math.BigDecimal;

import br.com.loja.desconto.CalculadoraDeDesconto;
//import br.com.loja.imposto.CalculadoraDeImposto;
//import br.com.loja.imposto.ICMS;
//import br.com.loja.imposto.ISS;
//import br.com.loja.imposto.Imposto;
import br.com.loja.orcamento.Orcamento;

public class TestesImpostos {

	public static void main(String[] args) {

		Orcamento primeiro = new Orcamento(new BigDecimal("200"),6);
		Orcamento segundo = new Orcamento(new BigDecimal("1000"),1);
		
//		CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
//		System.out.println(calculadora.calcular(primeiro, new ICMS()));
//		System.out.println(calculadora.calcular(segundo, new ISS()));
		
		CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
		System.out.println(calculadora.calcular(primeiro));
		System.out.println(calculadora.calcular(segundo));
		
	}

}
