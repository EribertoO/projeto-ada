package modulo2.projetoCarrinhoDeCompras;

/**
 * @author Daniel Franco, Eriberto Oliveira, Gabriel Kendy,
 * 		   Lucas Barbosa, Mateus Cirilo, Murilo Vidotto
 * 
 * Equipe Azul
 * 
 */

public class TestaCarrinho {

	public static void main(String[] args) {

		Produto farinha = new Produto("Farinha", "Farinha de trigo ASA BRANCA", ProdutoTipo.ALIMENTACAO, 7);
		Produto notebook = new Produto("Notebook", "Notebook DELL i5", ProdutoTipo.ELETRONICO, 2500);
		Produto detergente = new Produto("Detergente", "Detergente IPÊ LIMÃO", ProdutoTipo.PRODUTO_LIMPEZA, 5);
		Produto headset = new Produto("Headset", "Headset BARATIN", ProdutoTipo.ELETRONICO, 99);
		Produto camisa = new Produto("Camisa", "Camisa marca KENDY", ProdutoTipo.VESTUARIO, 300);
		
		ModificadorPreco promocaoTec = new ModificadorPreco("PromoçãoTEC", "Promoção para a Era da Tecnologia",
				ProdutoTipo.ELETRONICO, new ClientePF("",""), -0.05, -100);
		ModificadorPreco impostoComida = new ModificadorPreco("Imposto", "Imposto para compra de alimentos por empresas",
				ProdutoTipo.ALIMENTACAO, new ClientePJ("",""), +0.1, +1);
		ModificadorPreco frete = new ModificadorPreco("Frete", "Frente só de roupa",
				ProdutoTipo.VESTUARIO, new ClientePF("",""), +0.05, +0);
		
		Cliente jorge = new ClientePF("Jorge","123");

		Carrinho carrinho = new Carrinho(jorge);

		carrinho.adicionarItem(detergente, 13)
				.adicionarItem(farinha, 7)
				.adicionarItem(notebook, 2)
				.adicionarItem(headset, 2)
				.adicionarItem(camisa, 3)
				.printa();

		carrinho.adicionarModificador(promocaoTec)
				.adicionarModificador(impostoComida)
				.adicionarModificador(frete)
				.removerItem(detergente)
				.printa();

		carrinho.adicionarItem(farinha, 7)
				.printa();

		carrinho.modificarQuantidadeItem(headset, 100)
				.printa();

		carrinho.removerItem(detergente)
				.adicionarItem(headset, -400)
				.adicionarItem(headset, 0)
				.modificarQuantidadeItem(headset, 0)
				.printa();

	}

}
