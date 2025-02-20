package br.ufpb.dcx.diogo.sistemamercado;

public class ProdutoJaExisteException extends Exception{
    public ProdutoJaExisteException(String msg){
        super(msg);
    }
}
