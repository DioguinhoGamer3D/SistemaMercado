package br.ufpb.dcx.diogo.sistemamercado.controller;

import br.ufpb.dcx.diogo.sistemamercado.Estoque;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MercadoLoadController implements ActionListener {
    private Estoque estoque;
    private JFrame janelaPrincipal;

    public MercadoLoadController(Estoque estoque, JFrame janelaPrincipal){
        this.estoque=estoque;
        this.janelaPrincipal=janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            JOptionPane.showMessageDialog(janelaPrincipal, "Dados recuperados com sucesso!");
            estoque.recuperarDados();
        } catch (IOException p){
            JOptionPane.showMessageDialog(janelaPrincipal,"Erro ao recuperar dados!");
        }
    }
}
