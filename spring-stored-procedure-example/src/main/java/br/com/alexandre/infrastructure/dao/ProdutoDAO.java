package br.com.alexandre.infrastructure.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import br.com.alexandre.domain.model.Produto;
import br.com.alexandre.domain.repository.ProdutoRepository;

public class ProdutoDAO extends StoredProcedure implements ProdutoRepository {

	private static final String PROCEDURE_NAME = "atualizaPreco";
	
	public ProdutoDAO(final DataSource ds) {
		super(ds, PROCEDURE_NAME);
		declareParameter(new SqlParameter("P_CODIGO", Types.INTEGER));
		declareParameter(new SqlParameter("P_PRECO", Types.DECIMAL));
		declareParameter(new SqlOutParameter("P_RETORNO", Types.INTEGER));
	}

	@Override
	public void atualizaPreco(Produto produto) {
		final Map<String, Object> entrada = new HashMap<String, Object>();
		entrada.put("P_CODIGO", produto.getId());
		entrada.put("P_PRECO", produto.getPreco());

		final Map<String, Object> retorno = super.execute(entrada);

		final Integer codigo = (Integer) retorno.get("P_RETORNO");
		
		if (codigo != 0) {
			throw new RuntimeException("Ocorreu um erro ao executar a procedure");
		}
	}		

}
