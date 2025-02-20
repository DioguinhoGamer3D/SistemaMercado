package br.ufpb.dcx.diogo.sistemamercado;

public class ProdutoInexistenteException extends Exception{
    public ProdutoInexistenteException(String msg){
        super(msg);
    }
}
