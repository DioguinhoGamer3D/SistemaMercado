package br.ufpb.dcx.diogo.sistemamercado.controller;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MercadoSaveController implements ActionListener {
    private Estoque estoque;
    private JFrame janelaPrincipal;

    public MercadoSaveController(Estoque estoque, JFrame janelaPrincipal){
        this.estoque=estoque;
        this.janelaPrincipal=janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            estoque.salvarDados();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        JOptionPane.showMessageDialog(janelaPrincipal, "Dados salvos com sucesso!");
    }
}
