package br.ufpb.dcx.diogo.sistemamercado.controller;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoadFont {
    public static Font loadCustomFont(String lugar, float tamanho){
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("./imgs/Font/Oswald-VariableFont_wght.ttf"));
            return customFont.deriveFont(tamanho);
        }catch (FontFormatException | IOException d){
            d.printStackTrace();
            return new Font("Serif",Font.PLAIN, (int) tamanho);
        }
    }
}
