package br.ufpb.dcx.diogo.sistemamercado.controller;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;
import br.ufpb.dcx.diogo.sistemamercado.ProdutoInexistenteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MercadoRemoveController implements ActionListener {
    private Estoque estoque;
    private JFrame janelaPrincipal;

    public MercadoRemoveController(Estoque estoque, JFrame janela) {
        this.estoque = estoque;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String codigoProdutoARemover =JOptionPane.showInputDialog(janelaPrincipal, "Qual o código do produto que deseja remover?");
            estoque.removerProduto(codigoProdutoARemover);
            JOptionPane.showMessageDialog(janelaPrincipal, "Produto removido com sucesso!");
        } catch (ProdutoInexistenteException d){
            JOptionPane.showMessageDialog(janelaPrincipal,"Produto não existe!");
        }
    }
}