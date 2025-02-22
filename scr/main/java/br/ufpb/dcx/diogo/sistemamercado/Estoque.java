package br.ufpb.dcx.diogo.sistemamercado;

import java.io.IOException;
import java.util.List;

public interface Estoque {

    public void cadastrarProduto(String codigoProduto, String nomeProduto, int quantidade, double preco) throws ProdutoJaExisteException;

    public List<Produto> pesquisarProdutosComBaixoEstoque(int limite);

    public void removerProduto(String codigoProduto) throws ProdutoInexistenteException;

    public Produto pesquisaProduto(String codigoProduto) throws ProdutoInexistenteException;

    public double pesquisaPreco(String codigoProduto) throws ProdutoInexistenteException;

    public void alterarQuantidade(String codigoProduto, int novaQuantidade) throws ProdutoInexistenteException;

    public void alterarNome(String codigoProduto, String novoNome) throws ProdutoInexistenteException;

    public void alterarPreco(String codigoProduto, double novoPreco) throws ProdutoInexistenteException;

    public List<Produto> pesquisaTodosOsProdutos();

    public void salvarDados() throws IOException;

    public void recuperarDados() throws IOException;
}
