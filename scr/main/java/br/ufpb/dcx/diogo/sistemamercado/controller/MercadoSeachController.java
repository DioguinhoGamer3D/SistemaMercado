package br.ufpb.dcx.diogo.sistemamercado.controller;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;
import br.ufpb.dcx.diogo.sistemamercado.Produto;
import br.ufpb.dcx.diogo.sistemamercado.ProdutoInexistenteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MercadoSeachController implements ActionListener {
    private Estoque estoque;
    private JFrame janelaPrincipal;

    public MercadoSeachController(Estoque estoque, JFrame janela) {
        this.estoque = estoque;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] opcoesPesquisar={"Pesquisar produto", "Pesquisar preço do produto", "Pesquisar produtos com baixo estoque"};
        String escolhaParaPesquisar = (String) JOptionPane.showInputDialog(null, "Escolha uma opção: "
                ,"Menu",JOptionPane.QUESTION_MESSAGE, null, opcoesPesquisar, opcoesPesquisar[0]);
        if (escolhaParaPesquisar!=null) {
            switch (escolhaParaPesquisar) {
                case "Pesquisar produto":
                    try {
                        String codigoProdutoPesquisado = JOptionPane.showInputDialog(janelaPrincipal, "Qual o código do produto?");
                        Produto produto = estoque.pesquisaProduto(codigoProdutoPesquisado);
                        JOptionPane.showMessageDialog(janelaPrincipal, produto.toString());
                        break;
                    } catch (ProdutoInexistenteException d) {
                        JOptionPane.showMessageDialog(janelaPrincipal, "Produto não existe!");
                    }
                    break;
                case "Pesquisar preço do produto":
                    try {
                        String codigoPesquisarPreco = JOptionPane.showInputDialog(janelaPrincipal, "Qual o código do produto?");
                        double produtoPreco = estoque.pesquisaPreco(codigoPesquisarPreco);
                        JOptionPane.showMessageDialog(janelaPrincipal, "Produto com preço de: R$" + produtoPreco);
                        break;
                    } catch (ProdutoInexistenteException d) {
                        JOptionPane.showMessageDialog(janelaPrincipal, "Produto não existe!");
                    }
                    break;
                case "Pesquisar produtos com baixo estoque":
                    try {
                        int limite = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o limite?"));
                        List<Produto> produtosPoucos = estoque.pesquisarProdutosComBaixoEstoque(limite);
                        JOptionPane.showMessageDialog(janelaPrincipal, "Produto: " + produtosPoucos.toString());
                        break;
                    } catch (ProdutoInexistenteException d) {
                        JOptionPane.showMessageDialog(janelaPrincipal, "Produto não existe!");
                    }
                    break;
            }
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal, "Voltando pro menu...");
        }
    }
}