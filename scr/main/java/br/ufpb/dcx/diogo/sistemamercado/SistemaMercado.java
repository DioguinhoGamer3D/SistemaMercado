package br.ufpb.dcx.diogo.sistemamercado;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class SistemaMercado {

    public static void main(String[] args) throws ProdutoJaExisteException, ProdutoInexistenteException, IOException {
        GerenciaEstoque sistema = new GerenciaEstoque();
        try {
            sistema.recuperarDados();
            JOptionPane.showMessageDialog(null, "Pronto!\n Seus dados foram recuperados!");
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
                    String codigoProdutoACadastrar = JOptionPane.showInputDialog("Qual o código do produto?");
                    String nomeProduto = JOptionPane.showInputDialog("Qual o nome do produto?");
                    int quantProduto = Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade de produto?"));
                    double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do produto?"));
                    sistema.cadastrarProduto(codigoProdutoACadastrar,nomeProduto,quantProduto,precoProduto);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    break;
                case 1:
                    String codigoProdutoARemover =JOptionPane.showInputDialog("Qual o código do produto que deseja remover?");
                    sistema.removerProduto(codigoProdutoARemover);
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                    break;
                case 2:
                    String[] opcoesAlterar={"Alterar nome", "Alterar quantidade", "Alterar preço"};
                    String escolhaParaAlterar = (String) JOptionPane.showInputDialog(null, "Escolha uma opção: "
                            ,"Menu",JOptionPane.QUESTION_MESSAGE, null, opcoesAlterar, opcoesAlterar[0]);
                    switch (escolhaParaAlterar){
                        case "Alterar nome":
                            String codigoParaAlterarNome = JOptionPane.showInputDialog("Qual o código do produto?");
                            String novoNome = JOptionPane.showInputDialog("Qual o novo nome do produto?");
                            sistema.alterarNome(codigoParaAlterarNome,novoNome);
                            JOptionPane.showMessageDialog(null,"Nome alterado com sucesso!");
                            break;
                        case "Alterar quantidade":
                            String codigoParaAlterarQuantidade = JOptionPane.showInputDialog("Qual o código do produto?");
                            int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Qual a nova quantidade?"));
                            sistema.alterarQuantidade(codigoParaAlterarQuantidade,novaQuantidade);
                            JOptionPane.showMessageDialog(null, "Quantidade alterada com sucesso!");
                            break;
                        case "Alterar preço":
                            String codigoParaAlterarPreco = JOptionPane.showInputDialog("Qual o código do produto?");
                            double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Qual o novo preço?"));
                            sistema.alterarPreco(codigoParaAlterarPreco, novoPreco);
                            JOptionPane.showMessageDialog(null, "Preço alterado com sucesso!");
                            break;
                    }
                    break;
                case 3:
                    String[] opcoesPesquisar={"Pesquisar produto", "Pesquisar preço do produto", "Pesquisar produtos com baixo estoque"};
                    String escolhaParaPesquisar = (String) JOptionPane.showInputDialog(null, "Escolha uma opção: "
                            ,"Menu",JOptionPane.QUESTION_MESSAGE, null, opcoesPesquisar, opcoesPesquisar[0]);
                    switch (escolhaParaPesquisar){
                        case "Pesquisar produto":
                            String codigoProdutoPesquisado = JOptionPane.showInputDialog("Qual o código do produto?");
                            Produto produto = sistema.pesquisaProduto(codigoProdutoPesquisado);
                            JOptionPane.showMessageDialog(null, produto.toString());
                            break;
                        case "Pesquisar preço do produto":
                            String codigoPesquisarPreco = JOptionPane.showInputDialog("Qual o código do produto?");
                            double produtoPreco = sistema.pesquisaPreco(codigoPesquisarPreco);
                            JOptionPane.showMessageDialog(null, "Produto com preço de: R$"+produtoPreco);
                            break;
                        case "Pesquisar produtos com baixo estoque":
                            int limite = Integer.parseInt(JOptionPane.showInputDialog("Qual o limite?"));
                            List<Produto> produtosPoucos = sistema.pesquisarProdutosComBaixoEstoque(limite);
                            JOptionPane.showMessageDialog(null,"Produto: "+produtosPoucos.toString());
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

            }
        }
    }
}