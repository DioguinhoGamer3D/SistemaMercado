package br.ufpb.dcx.diogo.sistemamercado;

import java.io.*;
import java.util.*;

public class GerenciaEstoque implements Estoque{

    private Map<String, Produto> produtos;

    public GerenciaEstoque() {
            this.produtos = new HashMap<>();
    }

    public void cadastrarProduto(String codigoProduto, String nomeProduto, int quantidade, double preco) throws ProdutoJaExisteException{
        if(produtos.containsKey(codigoProduto)){
            throw new ProdutoJaExisteException("Já existe produto com código"+codigoProduto);
        } else{
            Produto produto = new Produto(codigoProduto, nomeProduto, quantidade, preco);
            produtos.put(codigoProduto, produto);
        }
    }

    public Collection<Produto> pesquisarProdutosComBaixoEstoque(int limite) {
            List<Produto> produtosComBaixoEstoque = new ArrayList<>();
            for (Produto produto : produtos.values()) {
                if (produto.getQuantidade() < limite) {
                    produtosComBaixoEstoque.add(produto);
                }
            }
            return produtosComBaixoEstoque;
        }
        public void removerProduto(String codigoProduto) throws ProdutoInexistenteException {
            if (!produtos.containsKey(codigoProduto)) {
                throw new ProdutoInexistenteException("Produto não encontrado: " + codigoProduto);
            }
            produtos.remove(codigoProduto);
        }

        public void salvarDados() throws IOException {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("estoque.dat"))) {
                out.writeObject(produtos);
            }
        }
        public void recuperarDados() throws IOException {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("estoque.dat"))) {
                produtos = (Map<String, Produto>) in.readObject();
            } catch (ClassNotFoundException e) {
                throw new IOException("Erro ao recuperar dados do estoque", e);
            }
        }
}
