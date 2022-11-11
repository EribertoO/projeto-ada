package modulo2.projetoCarrinhoDeCompras;

public class ModificadorPreco {

	private String nome;
	private String descricao;
	private ProdutoTipo produtoTipo;
	private Cliente cliente;
	private double valorPercentual;
	private double valorFixo;

	public double getValorPercentual() {
		return valorPercentual;
	}

	public double getValorFixo() {
		return valorFixo;
	}

	public ProdutoTipo getProdutoTipo() {
		return produtoTipo;
	}
	
	public Class<? extends Cliente> getClienteTipo() {
		return cliente.getClass();
	}

	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public ModificadorPreco(String nome, String descricao, ProdutoTipo produtoTipo, Cliente cliente, double valorPercentual, double valorFixo) {
		this.nome = nome;
		this.descricao = descricao;
		this.produtoTipo = produtoTipo;
		this.cliente = cliente;
		this.valorPercentual = valorPercentual;
		this.valorFixo = valorFixo;
	}

}
