package br.ufpb.dcx.diogo.sistemamercado.gui;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;
import br.ufpb.dcx.diogo.sistemamercado.GerenciaEstoque;
import br.ufpb.dcx.diogo.sistemamercado.controller.MercadoCadController;
import br.ufpb.dcx.diogo.sistemamercado.controller.MercadoChangeController;
import br.ufpb.dcx.diogo.sistemamercado.controller.MercadoRemoveController;
import br.ufpb.dcx.diogo.sistemamercado.controller.MercadoSeachController;

import javax.swing.*;
import java.awt.*;

public class MercadoGUI extends JFrame {
        JLabel linha1, linha2;
        ImageIcon mercadoImg = new ImageIcon("./imgs/bolo.jpg");
        ImageIcon cadImg = new ImageIcon("./imgs/icons/add_person.png");
        ImageIcon pesqImg = new ImageIcon("./imgs/icons/search_person.png");
        ImageIcon removeImg = new ImageIcon("./imgs/icons/remove_person.png");
        ImageIcon altImg = new ImageIcon("");
        JButton botaoCadastrar, botaoPesquisar, botaoRemover, botaoAlterar;
        Estoque estoque = new GerenciaEstoque();

        public MercadoGUI() {
            setTitle("Sistema Gerencia de Mercado");
            setSize(800, 600);
            setLocation(150, 150);
            setResizable(false);
            getContentPane().setBackground(Color.white);
            linha1 = new JLabel("Sistema para gerenciar um mercado", JLabel.CENTER);
            linha1.setForeground(Color.red);
            linha1.setFont(new Font("Serif", Font.BOLD, 24));
            linha2 = new JLabel(mercadoImg, JLabel.CENTER);
            botaoCadastrar = new JButton("Cadastrar produto", cadImg);
            botaoCadastrar.addActionListener(new MercadoCadController(estoque,this));
            botaoRemover = new JButton("Remover produto",removeImg);
            botaoRemover.addActionListener(new MercadoRemoveController(estoque,this));
            botaoPesquisar = new JButton("Pesquisar produto", pesqImg);
            botaoPesquisar.addActionListener(new MercadoSeachController(estoque,this));
            botaoAlterar = new JButton("Alterar Produto", altImg);
            botaoAlterar.addActionListener(new MercadoChangeController(estoque,this));
            getContentPane().setLayout(new GridLayout(4,2));
            getContentPane().add(linha1);
            getContentPane().add(botaoCadastrar);
            getContentPane().add(linha2);
            getContentPane().add(botaoPesquisar);
            getContentPane().add(new JLabel());
            getContentPane().add(botaoRemover);
            getContentPane().add(linha2);
            getContentPane().add(botaoAlterar);
        }
            public static void main(String [] args){
                JFrame janela = new MercadoGUI();
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
}