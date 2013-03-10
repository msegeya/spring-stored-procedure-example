package br.com.alexandre.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable {

	private static final long serialVersionUID = -607600111889352295L;
	private final Integer id;
	private final BigDecimal preco;
	
	public Produto(Integer id, BigDecimal preco) {
		super();
		this.id = id;
		this.preco = preco;
	}
	
	public Integer getId() {
		return id;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
	
}
