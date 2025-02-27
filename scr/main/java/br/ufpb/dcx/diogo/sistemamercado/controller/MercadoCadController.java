package br.ufpb.dcx.diogo.sistemamercado.controller;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;
import br.ufpb.dcx.diogo.sistemamercado.ProdutoJaExisteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MercadoCadController implements ActionListener {
    private Estoque estoque;
    private JFrame janelaPrincipal;

    public MercadoCadController(Estoque estoque, JFrame janela){
        this.estoque=estoque;
        this.janelaPrincipal=janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String codigoProdutoACadastrar = JOptionPane.showInputDialog(janelaPrincipal, "Qual o código do produto?");
            String nomeProduto = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do produto?");
            int quantProduto = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual a quantidade de produto?"));
            double precoProduto = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal, "Qual o preço do produto?"));
            try {
                estoque.cadastrarProduto(codigoProdutoACadastrar, nomeProduto, quantProduto, precoProduto);
                JOptionPane.showMessageDialog(janelaPrincipal, "Produto cadastrado com sucesso!");
            } catch (ProdutoJaExisteException d) {
                JOptionPane.showMessageDialog(janelaPrincipal, "Já existe produto com esse código!");
            }
        } catch (NumberFormatException d){
            JOptionPane.showMessageDialog(janelaPrincipal, "Por favor, insira um número valido!");
        }
    }
}