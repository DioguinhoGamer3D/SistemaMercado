package br.ufpb.dcx.diogo.sistemamercado.gui;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;
import br.ufpb.dcx.diogo.sistemamercado.GerenciaEstoque;

import javax.swing.*;

public class MercadoGUI_Com_Menu extends JFrame{
        JLabel linha1, linha2;
        ImageIcon mercadoImg = new ImageIcon("./imgs/MercadoPOO.jpg");
        Estoque estoque = new GerenciaEstoque();
        JMenuBar barraDoMenu = new JMenuBar();

        public MercadoGUI_Com_Menu(){
            setTitle();
        }
}
