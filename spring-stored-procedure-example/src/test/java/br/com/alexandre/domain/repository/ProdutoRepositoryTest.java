package br.com.alexandre.domain.repository;


import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.alexandre.domain.model.Produto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-Test.xml"})
public class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Test
	public void testExecuteIntegerBigDecimal() {
		final Produto produto = new Produto(2, new BigDecimal(1500.10));
		produtoRepository.atualizaPreco(produto);
	}

}
