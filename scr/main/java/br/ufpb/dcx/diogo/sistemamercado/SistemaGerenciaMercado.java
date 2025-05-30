package br.ufpb.dcx.diogo.sistemamercado;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class SistemaGerenciaMercado {

    public static void main(String[] args) throws IOException {
        GerenciaEstoque sistema = new GerenciaEstoque();
        try {
            sistema.recuperarDados();
            JOptionPane.showMessageDialog(null, "Bem-vinde!\n Seus dados foram recuperados!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado!\n " +
                    "Seus dados não foram recuperados!");
        }
        while(true){
            String[] opcoes = {"Cadastrar", "Remover", "Alterar", "Pesquisar","Salvar", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
            switch (escolha){
                case 0:
                    try {
                        String codigoProdutoACadastrar = JOptionPane.showInputDialog("Qual o código do produto?");
                        String nomeProduto = JOptionPane.showInputDialog("Qual o nome do produto?");
                        int quantProduto = Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade de produto?"));
                        double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do produto?"));
                        try {
                            sistema.cadastrarProduto(codigoProdutoACadastrar, nomeProduto, quantProduto, precoProduto);
                            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                        } catch (ProdutoJaExisteException e) {
                            JOptionPane.showMessageDialog(null, "Já existe produto com esse código!");
                        }
                    } catch (NumberFormatException e ){
                        JOptionPane.showMessageDialog(null, "Por favor, insira um número valido!");
                    }
                    break;
                case 1:
                    try {
                        String codigoProdutoARemover =JOptionPane.showInputDialog("Qual o código do produto que deseja remover?");
                        sistema.removerProduto(codigoProdutoARemover);
                        JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                    } catch (ProdutoInexistenteException e ){
                        JOptionPane.showMessageDialog(null,"Produto não existe!");
                    }
                    break;
                case 2:
                    String[] opcoesAlterar={"Alterar nome", "Alterar quantidade", "Alterar preço"};
                    String escolhaParaAlterar = (String) JOptionPane.showInputDialog(null, "Escolha uma opção: "
                            ,"Menu",JOptionPane.QUESTION_MESSAGE, null, opcoesAlterar, opcoesAlterar[0]);
                    if(escolhaParaAlterar!=null) {
                        switch (escolhaParaAlterar) {
                            case "Alterar nome":
                                try {
                                    String codigoParaAlterarNome = JOptionPane.showInputDialog("Qual o código do produto?");
                                    String novoNome = JOptionPane.showInputDialog("Qual o novo nome do produto?");
                                    sistema.alterarNome(codigoParaAlterarNome, novoNome);
                                    JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
                                    break;
                                } catch (ProdutoInexistenteException e) {
                                    JOptionPane.showMessageDialog(null, "Produto não existe!");
                                }
                                break;
                            case "Alterar quantidade":
                                try {
                                    String codigoParaAlterarQuantidade = JOptionPane.showInputDialog("Qual o código do produto?");
                                    int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Qual a nova quantidade?"));
                                    sistema.alterarQuantidade(codigoParaAlterarQuantidade, novaQuantidade);
                                    JOptionPane.showMessageDialog(null, "Quantidade alterada com sucesso!");
                                    break;
                                } catch (ProdutoInexistenteException e) {
                                    JOptionPane.showMessageDialog(null, "Produto não existe!");
                                }
                                break;
                            case "Alterar preço":
                                try {
                                    String codigoParaAlterarPreco = JOptionPane.showInputDialog("Qual o código do produto?");
                                    double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Qual o novo preço?"));
                                    sistema.alterarPreco(codigoParaAlterarPreco, novoPreco);
                                    JOptionPane.showMessageDialog(null, "Preço alterado com sucesso!");
                                    break;
                                } catch (ProdutoInexistenteException e) {
                                    JOptionPane.showMessageDialog(null, "Produto não existe!");
                                }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Voltando pro menu...");
                        break;
                    }
                    break;
                case 3:
                    String[] opcoesPesquisar={"Pesquisar produto", "Pesquisar preço do produto", "Pesquisar produtos com baixo estoque"};
                    String escolhaParaPesquisar = (String) JOptionPane.showInputDialog(null, "Escolha uma opção: "
                            ,"Menu",JOptionPane.QUESTION_MESSAGE, null, opcoesPesquisar, opcoesPesquisar[0]);
                    if (escolhaParaPesquisar!=null) {
                        switch (escolhaParaPesquisar) {
                            case "Pesquisar produto":
                                try {
                                    String codigoProdutoPesquisado = JOptionPane.showInputDialog("Qual o código do produto?");
                                    Produto produto = sistema.pesquisaProduto(codigoProdutoPesquisado);
                                    JOptionPane.showMessageDialog(null, produto.toString());
                                    break;
                                } catch (ProdutoInexistenteException e) {
                                    JOptionPane.showMessageDialog(null, "Produto não existe!");
                                }
                                break;
                            case "Pesquisar preço do produto":
                                try {
                                    String codigoPesquisarPreco = JOptionPane.showInputDialog("Qual o código do produto?");
                                    double produtoPreco = sistema.pesquisaPreco(codigoPesquisarPreco);
                                    JOptionPane.showMessageDialog(null, "Produto com preço de: R$" + produtoPreco);
                                    break;
                                } catch (ProdutoInexistenteException e) {
                                    JOptionPane.showMessageDialog(null, "Produto não existe!");
                                }
                                break;
                            case "Pesquisar produtos com baixo estoque":
                                try {
                                    int limite = Integer.parseInt(JOptionPane.showInputDialog("Qual o limite?"));
                                    List<Produto> produtosPoucos = sistema.pesquisarProdutosComBaixoEstoque(limite);
                                    JOptionPane.showMessageDialog(null, "Produto: " + produtosPoucos.toString());
                                    break;
                                } catch (ProdutoInexistenteException e) {
                                    JOptionPane.showMessageDialog(null, "Produto não existe!");
                                }
                                break;
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Voltando pro menu...");
                        break;
                    }
                    break;
                case 4:
                    sistema.salvarDados();
                    JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0);
                    break;
            }
        }
    }
}