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
        ImageIcon mercadoImg = new ImageIcon("./imgs/MercadoPOO.jpg");
        ImageIcon cadImg = new ImageIcon("./imgs/icons/add_icon.png");
        ImageIcon pesqImg = new ImageIcon("./imgs/icons/search_icon.png");
        ImageIcon removeImg = new ImageIcon("./imgs/icons/remove_icon.png");
        ImageIcon altImg = new ImageIcon("./imgs/icons/change_icon.png");
        JButton botaoCadastrar, botaoPesquisar, botaoRemover, botaoAlterar;
        Estoque estoque = new GerenciaEstoque();

        public MercadoGUI() {
            setTitle("Sistema Gerencia de Mercado");
            setSize(800, 600);
            setLocation(150, 150);
            setResizable(false);
            getContentPane().setBackground(new Color(254, 255, 239));
            linha1 = new JLabel("Sistema para gerenciar um mercado", JLabel.CENTER);
            linha1.setForeground(Color.red);
            linha1.setFont(new Font("Serif", Font.BOLD, 24));
            linha2 = new JLabel(mercadoImg, JLabel.CENTER);
            botaoCadastrar = new JButton("Cadastrar produto", cadImg);
            botaoCadastrar.setBackground(new Color(254, 255, 239));
            botaoCadastrar.addActionListener(new MercadoCadController(estoque,this));
            botaoRemover = new JButton("Remover produto",removeImg);
            botaoRemover.setBackground(new Color(254, 255, 239));
            botaoRemover.addActionListener(new MercadoRemoveController(estoque,this));
            botaoPesquisar = new JButton("Pesquisar produto", pesqImg);
            botaoPesquisar.setBackground(new Color(254, 255, 239));
            botaoPesquisar.addActionListener(new MercadoSeachController(estoque,this));
            botaoAlterar = new JButton("Alterar Produto", altImg);
            botaoAlterar.setBackground(new Color(254, 255, 239));
            botaoAlterar.addActionListener(new MercadoChangeController(estoque,this));
            getContentPane().setLayout(new GridLayout(3,2));
            getContentPane().add(linha1);
            getContentPane().add(linha2);
            getContentPane().add(botaoCadastrar);
            getContentPane().add(botaoRemover);
            getContentPane().add(botaoPesquisar);
            getContentPane().add(botaoAlterar);
        }
            public static void main(String [] args){
                JFrame janela = new MercadoGUI();
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
}