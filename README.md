Projeto carrinho de compras – blue squad 

 

O programa foi elaborado de maneira a conter apenas o essencial para realizar as tarefas solicitadas no enunciado. As classes ClientePF e ClientePJ estendem a classe Cliente, herdando seu único atributo, nome; elas guardam respectivamente CPF e CNPJ e possuem getters e setters padrão. 

Há uma classe ModificadorPreco feita por composição cujos atributos incluem cliente e produtoTipo (enum); esse modificador é adicionado ao carrinho para aplicar descontos e taxas extras. Em tese, o modificador depende principalmente dos tipos de cliente e produto para ser aplicado. 

A classe Produto é composta pelos atributos nome, descrição, tipo e preco, e por seus getter e setters. Também é nessa classe que está a enum com os tipos de produtos. 

A classe Carrinho contém a lógica e os métodos relacionados a inserção e remoção de produtos, modificação de quantidades, listagem dos produtos adicionados e aplicação de modificadores de preço. Utilizando listas e generics, o carrinho guarda produtos, quantidades e modificadores separadamente. Além disso, ele também possui um cliente e um valorTotal. 

O método listarItens() imprime no console a lista de itens formatada. O método adicionarItem() verifica se a quantidade solicitada é maior que 0 imprime mensagem de erro em caso contrário. removerItem() checa se o produto cuja remoção foi solicitada consta no carrinho. O método modificarQuantidadeItem() faz as duas checagens anteriores. 

Quanto aos princípios SOLID, o programa tem as seguintes características: 

- single responsibility – toda a lógica do programa está na classe Carrinho 

- open-closed – o uso da enum ProdutoTipo na classe Produto é um exemplo 

- liskov substitution – na classe ModificadorPreco, há um método que retorna o tipo de cliente; no código, há utilização do wildcard, que representa qualquer classe que extenda Cliente (isto é, ClientePF e ClientePJ)
