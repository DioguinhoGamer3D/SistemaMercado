package br.ufpb.dcx.diogo.sistemamercado.gui;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;
import br.ufpb.dcx.diogo.sistemamercado.GerenciaEstoque;
import br.ufpb.dcx.diogo.sistemamercado.controller.*;

import javax.swing.*;
import java.awt.*;

public class MercadoGUI extends JFrame {
        JLabel linha1, linha2;
        ImageIcon mercadoImg = new ImageIcon("./imgs/MercadoPOO.jpg");
        ImageIcon cadImg = new ImageIcon("./imgs/icons/add_icon.png");
        ImageIcon pesqImg = new ImageIcon("./imgs/icons/search_icon.png");
        ImageIcon removeImg = new ImageIcon("./imgs/icons/remove_icon.png");
        ImageIcon altImg = new ImageIcon("./imgs/icons/change_icon.png");
        ImageIcon saveImg = new ImageIcon("./imgs/icons/save_icon.png");
        ImageIcon exitImg = new ImageIcon("./imgs/icons/exit_icon.png");
        JButton botaoCadastrar, botaoPesquisar, botaoRemover, botaoAlterar, botaoSalvar, botaoSair;
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
        botaoSalvar = new JButton("Salvar", saveImg);
        botaoSalvar.setBackground(new Color(254, 255, 239));
        botaoSalvar.addActionListener(new MercadoSaveController(estoque,this));
        botaoSair = new JButton("Sair",exitImg);
        botaoSair.setBackground(new Color(254, 255, 239));
        botaoSair.addActionListener(new MercadoExitController(estoque,this));
        getContentPane().setLayout(new GridLayout(4,2));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
        getContentPane().add(botaoCadastrar);
        getContentPane().add(botaoRemover);
        getContentPane().add(botaoPesquisar);
        getContentPane().add(botaoAlterar);
        getContentPane().add(botaoSalvar);
        getContentPane().add(botaoSair);
    }
    public static void main(String [] args){
                JFrame janela = new MercadoGUI();
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}