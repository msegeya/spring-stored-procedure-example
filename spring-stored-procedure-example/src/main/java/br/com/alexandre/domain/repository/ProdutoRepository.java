package br.com.alexandre.domain.repository;

import br.com.alexandre.domain.model.Produto;

public interface ProdutoRepository {
	public void atualizaPreco(final Produto produto);
}
