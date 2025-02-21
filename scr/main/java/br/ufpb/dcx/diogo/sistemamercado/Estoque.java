package br.ufpb.dcx.diogo.sistemamercado;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface Estoque {
    // Adiciona um novo produto ao estoque
    public void cadastrarProduto(String codigoProduto, String nomeProduto, int quantidade, double preco) throws ProdutoJaExisteException;

    // Pesquisa produtos com quantidade abaixo de um limite especificado
    public List<Produto> pesquisarProdutosComBaixoEstoque(int limite);

    // Remove um produto pelo codigo
    public void removerProduto(String codigoProduto) throws ProdutoInexistenteException;

    // Pesquisa produtos por codigo
    public Produto pesquisaProduto(String codigoProduto) throws ProdutoInexistenteException;

    // Verifica preço do produto
    public double pesquisaPreco(String codigoProduto) throws ProdutoInexistenteException;

    // Alterar a quantidade
    public void alterarQuantidade(String codigoProduto, int novaQuantidade) throws ProdutoInexistenteException;

    // Alterar o nome
    public void alterarNome(String codigoProduto, String novoNome) throws ProdutoInexistenteException;

    // Alterar o preço
    public void alterarPreco(String codigoProduto, double novoPreco) throws ProdutoInexistenteException;

    // Pesquisar todos os produtos
    public List<Produto> pesquisaTodosOsProdutos();

    // Salva os dados do estoque em um arquivo
    public void salvarDados() throws IOException;

    // Recupera os dados do estoque de um arquivo
    public void recuperarDados() throws IOException;
}
