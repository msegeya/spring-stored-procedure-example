CREATE TABLE Produto (
	id INTEGER NOT NULL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	preco DECIMAL(10,2) NOT NULL
);

INSERT INTO Produto (id, nome, preco) VALUES (1, 'TV', 1500.00);
INSERT INTO Produto (id, nome, preco) VALUES (2, 'Computador', 4500.00);
INSERT INTO Produto (id, nome, preco) VALUES (3, 'Sofá', 799.99);

CREATE OR REPLACE FUNCTION atualizaPreco(integer, decimal) RETURNS integer AS $BODY$
DECLARE
	P_CODIGO ALIAS for $1;
	P_PRECO ALIAS for $2;
BEGIN
	BEGIN
		UPDATE Produto SET preco = P_PRECO WHERE id = P_CODIGO;
	EXCEPTION WHEN others THEN
		RETURN 1;
	END;
	RETURN 0;
END;
$BODY$
LANGUAGE plpgsql VOLATILE;