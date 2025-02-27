package br.ufpb.dcx.diogo.sistemamercado.controller;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;
import br.ufpb.dcx.diogo.sistemamercado.ProdutoInexistenteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MercadoChangeController implements ActionListener {
    private Estoque estoque;
    private JFrame janelaPrincipal;

    public MercadoChangeController(Estoque estoque, JFrame janela) {
        this.estoque = estoque;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] opcoesAlterar={"Alterar nome", "Alterar quantidade", "Alterar preço"};
        String escolhaParaAlterar = (String) JOptionPane.showInputDialog(janelaPrincipal, "Escolha uma opção: "
                ,"Menu",JOptionPane.QUESTION_MESSAGE, null, opcoesAlterar, opcoesAlterar[0]);
        if(escolhaParaAlterar!=null) {
            switch (escolhaParaAlterar) {
                case "Alterar nome":
                    try {
                        String codigoParaAlterarNome = JOptionPane.showInputDialog("Qual o código do produto?");
                        String novoNome = JOptionPane.showInputDialog("Qual o novo nome do produto?");
                        estoque.alterarNome(codigoParaAlterarNome, novoNome);
                        JOptionPane.showMessageDialog(janelaPrincipal, "Nome alterado com sucesso!");
                        break;
                    } catch (ProdutoInexistenteException d) {
                        JOptionPane.showMessageDialog(janelaPrincipal, "Produto não existe!");
                    }
                    break;
                case "Alterar quantidade":
                    try {
                        String codigoParaAlterarQuantidade = JOptionPane.showInputDialog("Qual o código do produto?");
                        int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Qual a nova quantidade?"));
                        estoque.alterarQuantidade(codigoParaAlterarQuantidade, novaQuantidade);
                        JOptionPane.showMessageDialog(janelaPrincipal, "Quantidade alterada com sucesso!");
                        break;
                    } catch (ProdutoInexistenteException d) {
                        JOptionPane.showMessageDialog(janelaPrincipal, "Produto não existe!");
                    }
                    break;
                case "Alterar preço":
                    try {
                        String codigoParaAlterarPreco = JOptionPane.showInputDialog("Qual o código do produto?");
                        double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Qual o novo preço?"));
                        estoque.alterarPreco(codigoParaAlterarPreco, novoPreco);
                        JOptionPane.showMessageDialog(janelaPrincipal, "Preço alterado com sucesso!");
                        break;
                    } catch (ProdutoInexistenteException d) {
                        JOptionPane.showMessageDialog(janelaPrincipal, "Produto não existe!");
                    }
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Voltando pro menu...");
        }
    }
}