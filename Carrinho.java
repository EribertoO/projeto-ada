package modulo2.projetoCarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Printavel {

	private Cliente cliente;
	private List<Produto> produtos = new ArrayList<>();
	private List<Integer> quantidades = new ArrayList<>();
	private List<ModificadorPreco> modificadores = new ArrayList<>();
	private double valorTotal = 0;

	public double getValorTotal() {
		return valorTotal;
	}

	public Carrinho(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Carrinho(Cliente cliente, List<Produto> listaProdutos) {
		this.cliente = cliente;
		for (Produto produto : listaProdutos) {
			this.adicionarItem(produto, 1);
		}
	}
	
	@Override
	public String toString() {
		return String.format("%15s %10s %10s %10s %15s %10s %10s \n", "PRODUTO", "PRECO", "QUANT", "PARCIAL", "MOD",
				"VALOR", "TOTAL");
	}

	@Override
	public void printa() {
		System.out.println("Prezado(a) cliente " + cliente.getNome() + ", esse é o seu carrinho: \n");
		System.out.println(this);
		double somaTotal = 0;
		double parcialLinha;
		double modLinha = 0;
		String nomeMod = "";
		for (int i = 0; i < this.produtos.size(); i++) {
			modLinha = 0;
			parcialLinha = this.quantidades.get(i) * this.produtos.get(i).getPreco();
			for (ModificadorPreco modificadorPreco : modificadores) {
				if (modificadorPreco.getProdutoTipo() == this.produtos.get(i).getTipo()
						&& modificadorPreco.getClienteTipo() == this.cliente.getClass()) {
					modLinha = parcialLinha * modificadorPreco.getValorPercentual() + modificadorPreco.getValorFixo();
					if (parcialLinha + modLinha < 0) {
						modLinha = -1 * parcialLinha;
					}
					nomeMod = modificadorPreco.getNome();
				}
				if (nomeMod.isEmpty()) nomeMod = "ISENTO";
			}
			somaTotal += parcialLinha + modLinha;
			System.out.printf("%15s %10.2f %10d %10.2f %15s %10.2f %10.2f \n", this.produtos.get(i).getNome(),
					this.produtos.get(i).getPreco(), this.quantidades.get(i), parcialLinha, nomeMod, modLinha,
					parcialLinha + modLinha);
		}
		this.valorTotal = somaTotal;
		System.out.printf("%75s %10.2f \n\n","Valor Total:", somaTotal);
	}

	public Carrinho adicionarItem(Produto produto, int quantidade) {
		System.out.println(">>> Adicionando " + produto.getDescricao() + ", quantidade: " + quantidade);
		if (quantidade <= 0) {
			System.out.println("Erro ao adicionar item. Quantidade inválida. \n");
			return this;
		}
		if (this.produtos.contains(produto)) {
			int indice = this.produtos.indexOf(produto);
			int quantidadeAnterior = this.quantidades.get(indice);
			this.quantidades.set(indice, quantidadeAnterior + quantidade);
			System.out.println(
					"O produto " + produto.getDescricao() + " foi adicionado ao carrinho " + quantidade + " vezes. \n");
		} else {
			this.produtos.add(produto);
			this.quantidades.add(quantidade);
			System.out.println("O produto " + produto.getDescricao() + " foi adicionado ao carrinho. \n");
		}
		return this;
	}

	public Carrinho removerItem(Produto produto) {
		System.out.println(">>> Removendo " + produto.getDescricao());
		if (this.produtos.contains(produto)) {
			int indice = this.produtos.indexOf(produto);
			this.produtos.remove(indice);
			this.quantidades.remove(indice);
			System.out.println("O produto " + produto.getDescricao() + " foi removido do carrinho. \n");
		} else {
			System.out.println(
					"Erro ao remover item. O produto " + produto.getDescricao() + " não consta no carrinho. \n");
		}
		return this;
	}

	public Carrinho modificarQuantidadeItem(Produto produto, int novaQuantidade) {
		System.out.println(">>> Modificando " + produto.getDescricao() + ", nova quantidade: " + novaQuantidade);
		if (novaQuantidade <= 0) {
			System.out.println("Erro ao modificar item. Quantidade inválida. Use a função Remover Item. \n");
			return this;
		}
		if (this.produtos.contains(produto)) {
			int indice = this.produtos.indexOf(produto);
			this.quantidades.set(indice, novaQuantidade);
			System.out.println("A quantidade do produto " + produto.getDescricao() + " foi modificada para "
					+ novaQuantidade + " \n");
		} else {
			System.out.println(
					"Erro ao modificar item. O produto " + produto.getDescricao() + " não consta no carrinho. \n");
		}
		return this;
	}

	public Carrinho adicionarModificador(ModificadorPreco mod) {
		System.out.println(">>> Adicionando " + mod.getNome());
		if (!this.modificadores.contains(mod)) {
			this.modificadores.add(mod);
			System.out.println(mod.getDescricao() + " adicionado(a) ao carrinho. \n");
		} else {
			System.out.println(mod.getDescricao() + " já foi aplicado no carrinho. \n");
		}
		return this;
	}

}
