package modulo2.projetoCarrinhoDeCompras;

public class Produto {

	private String nome;
	private String descricao;
	private ProdutoTipo tipo;
	private double preco;

	public ProdutoTipo getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public Produto(String nome, String descricao, ProdutoTipo tipo, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.preco = preco;
	}
	
}

enum ProdutoTipo {

	ALIMENTACAO, COSMETICO, HIGIENE, PRODUTO_LIMPEZA, ELETRONICO, VESTUARIO

}
