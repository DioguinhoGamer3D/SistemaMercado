package br.ufpb.dcx.diogo.sistemamercado;

import java.io.*;
import java.util.*;

public class GerenciaEstoque implements Estoque{

    private Map<String, Produto> produtos;

    public GerenciaEstoque() {
            this.produtos = new HashMap<>();
    }

    public void cadastrarProduto(String codigoProduto, String nomeProduto, int quantidade, double preco)
            throws ProdutoJaExisteException{
        if(produtos.containsKey(codigoProduto)){
            throw new ProdutoJaExisteException("Já existe produto com código: "+codigoProduto);
        } else{
            Produto produto = new Produto(codigoProduto, nomeProduto, quantidade, preco);
            produtos.put(codigoProduto, produto);
        }
    }

    public Produto pesquisaProduto(String codigoProduto) throws ProdutoInexistenteException {
        if(produtos.containsKey(codigoProduto)){
            return produtos.get(codigoProduto);
        }
        throw new ProdutoInexistenteException("Não existe produto com o código: "+codigoProduto);
    }

    public List<Produto> pesquisarProdutosComBaixoEstoque(int limite) throws ProdutoInexistenteException{
            List<Produto> produtosComBaixoEstoque = new ArrayList<>();
            for (Produto produto : produtos.values()) {
                if (produto.getQuantidade() < limite) {
                    produtosComBaixoEstoque.add(produto);
                }
            }
            if(produtosComBaixoEstoque.isEmpty()){
                throw new ProdutoInexistenteException("Não existe produto com menos que essa quantidade no estoque.");
            } else {
                return produtosComBaixoEstoque;
            }
    }

    public void removerProduto(String codigoProduto) throws ProdutoInexistenteException {
        if (!produtos.containsKey(codigoProduto)) {
            throw new ProdutoInexistenteException("Produto não encontrado: " + codigoProduto);
        }
        produtos.remove(codigoProduto);
    }

    public double pesquisaPreco(String codigoProduto) throws ProdutoInexistenteException {
        return pesquisaProduto(codigoProduto).getPreco();
    }

    public void alterarNome(String codigoProduto, String novoNome) throws ProdutoInexistenteException {
        pesquisaProduto(codigoProduto).setNomeProduto(novoNome);
    }

    public void alterarPreco(String codigoProduto, double novoPreco) throws ProdutoInexistenteException{
        pesquisaProduto(codigoProduto).setPreco(novoPreco);
    }

    public void alterarQuantidade(String codigoProduto, int novaQuantidade) throws ProdutoInexistenteException {
        pesquisaProduto(codigoProduto).setQuantidade(novaQuantidade);
    }

    public List<Produto> pesquisaTodosOsProdutos() {
        return new ArrayList<>(produtos.values());
    }

    public void recuperarDados() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("estoque.dat"))) {
            produtos = (Map<String, Produto>) in.readObject();
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IOException("Erro ao recuperar dados do estoque", e);
        }
    }

    public void salvarDados() throws IOException {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("estoque.dat"))) {
                out.writeObject(produtos);
            }
    }
}