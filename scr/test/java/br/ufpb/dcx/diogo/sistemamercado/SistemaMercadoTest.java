package br.ufpb.dcx.diogo.sistemamercado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaMercadoTest {

    GerenciaEstoque sistema;

    @BeforeEach
    void setUp(){
        this.sistema = new GerenciaEstoque();
    }

    @Test
    public void testaGerenciaEstoque(){
        assertTrue(sistema.pesquisaTodosOsProdutos().isEmpty());
        assertThrows(ProdutoInexistenteException.class,()-> sistema.pesquisaProduto("001"));
    }
    @Test
    public void testaCadastraEPesquisaProduto(){
        try{
            sistema.pesquisaProduto("001");
            fail("Deveria falhar pois não tem nenhum produto ainda");
        } catch (ProdutoInexistenteException e){
            //certo
        }
        try{
            sistema.cadastrarProduto("001","Arroz", 5, 4.99);
            Produto a = sistema.pesquisaProduto("001");
            assertEquals("Arroz",a.getNomeProduto());
            assertEquals(5, a.getQuantidade());
            assertEquals(4.99, a.getPreco());
            sistema.cadastrarProduto("002","Feijão",2,6.99);
            Produto f = sistema.pesquisaProduto("002");
            assertEquals("Feijão",f.getNomeProduto());
            assertEquals(2, f.getQuantidade());
            assertEquals(6.99, f.getPreco());
        } catch(ProdutoInexistenteException | ProdutoJaExisteException e){
            fail("Não deveria lançar excewção");
        }
    }
    @Test
    public void testaPesquisarProdutosComBaixoEstoque() throws ProdutoInexistenteException {
        try {
            sistema.cadastrarProduto("001","Arroz", 5, 4.99);
            assertThrows(ProdutoInexistenteException.class, ()->sistema.pesquisarProdutosComBaixoEstoque(5));
            sistema.cadastrarProduto("002","Feijão", 2, 6.99);
            assertEquals(sistema.pesquisarProdutosComBaixoEstoque(5).size(), 1);
            sistema.cadastrarProduto("003","Macarrão", 1, 3.99);
            assertEquals(sistema.pesquisarProdutosComBaixoEstoque(5).size(), 2);
        } catch (ProdutoJaExisteException e){
            fail("Não deveria lançar exceção");
        }
    }
    @Test
    public void testaRemoverProduto(){
        assertThrows(ProdutoInexistenteException.class,()-> sistema.removerProduto("001"));
        try{
            sistema.cadastrarProduto("001","Arroz", 5, 4.99);
            assertTrue(sistema.pesquisaTodosOsProdutos().size()==1);
            sistema.removerProduto("001");
            assertEquals(sistema.pesquisaTodosOsProdutos().size(), 0);
        } catch (ProdutoJaExisteException | ProdutoInexistenteException e){
            fail("Não deveria lançar exceção");
        }
    }
    @Test
    public void testaPesquisaPreco(){
        assertThrows(ProdutoInexistenteException.class,()-> sistema.pesquisaPreco("001"));
        try{
            sistema.cadastrarProduto("001","Arroz", 5, 4.99);
            assertEquals(sistema.pesquisaPreco("001"),4.99);
        } catch (ProdutoJaExisteException | ProdutoInexistenteException e){
            fail("Não deveria lançar exceção");
        }
    }
    @Test
    public void testaAlterarQuantidade(){
        assertThrows(ProdutoInexistenteException.class,()-> sistema.alterarQuantidade("001", 1));
        try{
            sistema.cadastrarProduto("001","Arroz", 5, 4.99);
            sistema.alterarQuantidade("001", 1);
            assertEquals(sistema.pesquisaProduto("001").getQuantidade(),1);
        }catch (ProdutoJaExisteException | ProdutoInexistenteException e){
            fail("Não deveria lançar exceção");
        }
    }
    @Test
    public void testaAlterarPreco(){
        assertThrows(ProdutoInexistenteException.class,()-> sistema.alterarPreco("001", 1.00));
        try{
            sistema.cadastrarProduto("001","Arroz", 5, 4.99);
            sistema.alterarPreco("001", 1.00);
            assertEquals(sistema.pesquisaProduto("001").getPreco(),1.00);
        }catch (ProdutoJaExisteException | ProdutoInexistenteException e){
            fail("Não deveria lançar exceção");
        }
    }
    @Test
    public void testaAlterarNome(){
        assertThrows(ProdutoInexistenteException.class,()-> sistema.alterarNome("001", "Macarrão"));
        try{
            sistema.cadastrarProduto("001","Arroz", 5, 4.99);
            sistema.alterarNome("001", "Macarrão");
            assertEquals(sistema.pesquisaProduto("001").getNomeProduto(),"Macarrão");
        }catch (ProdutoJaExisteException | ProdutoInexistenteException e){
            fail("Não deveria lançar exceção");
        }
    }
}
