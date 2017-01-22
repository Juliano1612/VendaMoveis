/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleEstoque;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rafael
 */
public class JPanelListaDePedidosDeReposicaoTest {
    
    private PedidoEstoque caso[] = new PedidoEstoque[5];
    
    public JPanelListaDePedidosDeReposicaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ControlaPedidoEstoque cntrlpe = new ControlaPedidoEstoque();
        
        /*  Teste 0: Pedido de Reposição de Estoque (PRE) vazio
            Não há nenhum produto cadastrado nele. É tratado como um pedido
            automaticamente efetivado, e portanto processado. */
        caso[0] = cntrlpe.getPedidoEstoque("teste0");
        
        /*  Teste 1: PRE não processado
        Esse pedido possui dois produtos cadastrados, com quantidades ainda não
        atendidas. Lista de itens atendidos:
            Banheira do Gugu: 0/1
            A: 0/2 */
        caso[1] = cntrlpe.getPedidoEstoque("teste1");
        
        /*  Teste 2: PRE processado, com quantidades parcialmente atendidas
        Esse pedido possui dois produtos cadastrados, cujas quantidades foram
        parcialmente atendidas. Lista de itens atendidos:
            Banheira do Gugu: 1/2
            A: 2/3 */
        caso[2] = cntrlpe.getPedidoEstoque("teste2");
        
        /*  Teste 3: PRE processado, completamente efetivado
        Esse pedido possui três produtos cadastrados, cujas quantidades foram
        totalmente atendidas. Lista de itens atendidos:
            Banheira do Gugu: 10/10
            A: 3/3
            Correção do algoritmo X: 7/7 */
        caso[3] = cntrlpe.getPedidoEstoque("teste3");
        
        /*  Teste 4: PRE processado, cancelado
        Esse pedido possui três produtos cadastrados, mas foi cancelado.
        Lista de itens atendidos:
            Cadeira chair Omcilon 2: 0/1
            Mesa table Wood: 0/3
            Correção do algoritmo X: 0/2 */     
        caso[4] = cntrlpe.getPedidoEstoque("teste4");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updatePedidosEstoque method, of class JPanelListaDePedidosDeReposicao.
     */
    @Test
    public void testUpdatePedidosEstoque() {
        
    }

    /**
     * Test of isPedidoProcessado method, of class JPanelListaDePedidosDeReposicao.
     */
    @Test
    public void testIsPedidoProcessado() {
        System.out.println("Testando isPedidoProcessado()...");
        JPanelListaDePedidosDeReposicao t = new JPanelListaDePedidosDeReposicao();
        
        assertTrue(t.isPedidoProcessado(caso[0])); System.out.println("\tCaso 0: OK!");
        assertFalse(t.isPedidoProcessado(caso[1])); System.out.println("\tCaso 1: OK!");
        assertTrue(t.isPedidoProcessado(caso[2])); System.out.println("\tCaso 2: OK!");
        assertTrue(t.isPedidoProcessado(caso[3])); System.out.println("\tCaso 3: OK!");
        assertTrue(t.isPedidoProcessado(caso[4])); System.out.println("\tCaso 4: OK!");
        
        t.setEnabled(false);
    }

    /**
     * Test of quantTotalItens method, of class JPanelListaDePedidosDeReposicao.
     */
    @Test
    public void testQuantTotalItens() {
        System.out.println("Testando QuantTotalItens()...");
        JPanelListaDePedidosDeReposicao t = new JPanelListaDePedidosDeReposicao();
        
        assertEquals(0, t.quantTotalItens(caso[0])); System.out.println("\tCaso 0: OK!");
        assertEquals(3, t.quantTotalItens(caso[1])); System.out.println("\tCaso 1: OK!");
        assertEquals(5, t.quantTotalItens(caso[2])); System.out.println("\tCaso 2: OK!");
        assertEquals(20, t.quantTotalItens(caso[3])); System.out.println("\tCaso 3: OK!");
        assertEquals(6, t.quantTotalItens(caso[4])); System.out.println("\tCaso 4: OK!");
        
        t.setEnabled(false);
    }

    /**
     * Test of quantTotalItensAtendidos method, of class JPanelListaDePedidosDeReposicao.
     */
    @Test
    public void testQuantTotalItensAtendidos() {
        System.out.println("Testando QuantTotalItensAtendidos()...");
        JPanelListaDePedidosDeReposicao t = new JPanelListaDePedidosDeReposicao();
        
        assertEquals(0, t.quantTotalItensAtendidos(caso[0])); System.out.println("\tCaso 0: OK!");
        assertEquals(0, t.quantTotalItensAtendidos(caso[1])); System.out.println("\tCaso 1: OK!");
        assertEquals(3, t.quantTotalItensAtendidos(caso[2])); System.out.println("\tCaso 2: OK!");
        assertEquals(20, t.quantTotalItensAtendidos(caso[3])); System.out.println("\tCaso 3: OK!");
        assertEquals(0, t.quantTotalItensAtendidos(caso[4])); System.out.println("\tCaso 4: OK!");
        
        t.setEnabled(false);
    }
    
}
