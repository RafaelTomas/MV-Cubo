package br.com.loja.imposto;

import java.math.BigDecimal;

import br.com.loja.orcamento.Orcamento;

public interface Imposto {
	
	public BigDecimal calcular(Orcamento orcamento);
}
