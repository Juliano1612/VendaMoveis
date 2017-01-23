/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleEstoque;

import ControleProduto.Produto;
import java.util.Date;
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
public class ControlaProdPedEstoqueTest {
    
    ControlaProdPedEstoque cppe;
    ProdPedEstoque caso[] = new ProdPedEstoque[5];
    
    public ControlaProdPedEstoqueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cppe = new ControlaProdPedEstoque();
        Date dt = new Date();
        Produto p = new Produto("1", "GUGUSBATHTUB", 0);
        PedidoEstoque pe = new PedidoEstoque("teste5");
        
        caso[0] = new ProdPedEstoque("teste0" + dt.getTime());
        caso[0].setQuantidade(0);
        caso[0].setStat(3);
        caso[0].setProduto(p);
        caso[0].setPedidoEstoque(pe);
        
        caso[1] = new ProdPedEstoque("teste1" + dt.getTime());
        caso[1].setQuantidade(-1);
        caso[1].setStat(3);
        caso[1].setProduto(p);
        caso[1].setPedidoEstoque(pe);
                
        caso[2] = new ProdPedEstoque("teste2" + dt.getTime());
        caso[2].setQuantidade(1);
        caso[2].setStat(3);
        caso[2].setProduto(p);
        caso[2].setPedidoEstoque(pe);
                
        caso[3] = new ProdPedEstoque("teste3" + dt.getTime());
        caso[3].setQuantidade(99);
        caso[3].setStat(3);
        caso[3].setProduto(p);
        caso[3].setPedidoEstoque(pe);
               
        caso[4] = new ProdPedEstoque("teste4" + dt.getTime());
        caso[4].setQuantidade(100);
        caso[4].setStat(3);
        caso[4].setProduto(p);
        caso[4].setPedidoEstoque(pe);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of persisteProdPedEstoque method, of class ControlaProdPedEstoque.
     */
    @Test
    public void testPersisteProdPedEstoque() {
        System.out.println("Testando PersisteProdPedEstoque()...");
        assertFalse(cppe.persisteProdPedEstoque(caso[0])); System.out.println("Caso 0: OK!");
        assertFalse(cppe.persisteProdPedEstoque(caso[1])); System.out.println("Caso 1: OK!");
        assertTrue(cppe.persisteProdPedEstoque(caso[2])); System.out.println("Caso 2: OK!");
        assertTrue(cppe.persisteProdPedEstoque(caso[3])); System.out.println("Caso 3: OK!");
        assertFalse(cppe.persisteProdPedEstoque(caso[4])); System.out.println("Caso 4: OK!");
    }
}
