package br.ufpb.dcx.diogo.sistemamercado.controller;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MercadoExitController implements ActionListener {
    private Estoque estoque;
    private JFrame janelaPrincipal;

    public MercadoExitController(Estoque estoque, JFrame janelaPrincipal){
        this.estoque=estoque;
        this.janelaPrincipal=janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}