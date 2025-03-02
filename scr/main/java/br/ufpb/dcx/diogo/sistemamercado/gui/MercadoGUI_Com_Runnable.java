package br.ufpb.dcx.diogo.sistemamercado.gui;

import javax.swing.*;

public class MercadoGUI_Com_Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame janela = new MercadoGUI();
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
