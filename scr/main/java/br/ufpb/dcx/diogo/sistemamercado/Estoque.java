package br.ufpb.dcx.diogo.sistemamercado;

import java.io.IOException;
import java.util.Collection;

public interface Estoque {
    // Adiciona um novo produto ao estoque
    public void cadastrarProduto(String codigoProduto, String nomeProduto, int quantidade, double preco) throws ProdutoJaExisteException;

    // Pesquisa produtos com quantidade abaixo de um limite especificado
    public Collection<Produto> pesquisarProdutosComBaixoEstoque(int limite);

    // Remove um produto pelo codigo
    public void removerProduto(String codigoProduto) throws ProdutoInexistenteException;

    // Salva os dados do estoque em um arquivo
    public void salvarDados() throws IOException;

    // Recupera os dados do estoque de um arquivo
    public void recuperarDados() throws IOException;
}
