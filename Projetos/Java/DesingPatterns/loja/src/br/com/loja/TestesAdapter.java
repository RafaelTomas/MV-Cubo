package br.com.loja;

import java.math.BigDecimal;

import br.com.loja.http.ApacheHttpAdapter;
import br.com.loja.orcamento.ItemOrcamento;
import br.com.loja.orcamento.Orcamento;
import br.com.loja.orcamento.RegistroOrcamento;

public class TestesAdapter {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(BigDecimal.TEN));
		orcamento.aprovar();
		orcamento.finalizar();

		RegistroOrcamento registro = new RegistroOrcamento(new ApacheHttpAdapter());
		registro.registrar(orcamento);
	}

}
