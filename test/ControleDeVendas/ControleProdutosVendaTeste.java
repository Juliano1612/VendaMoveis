package ControleDeVendas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ControleDeVendas.ControlaProdVenda;
import ControleDeVendas.ProdVenda;
import ControleDeVendas.Vendas;
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
 * @author Juliano
 */
public class ControleProdutosVendaTeste {
    ControlaProdVenda controlaProdVenda;
    ProdVenda caso[] = new ProdVenda[5];
    
    public ControleProdutosVendaTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        controlaProdVenda = new ControlaProdVenda();
        Date dt = new Date();
        Produto p = new Produto("1", "GUGUSBATHTUB", 0);
        Vendas v = new Vendas("vendaTeste");
        
        //ProdVenda pv = new ProdVenda("teste5");
        
        caso[0] = new ProdVenda("teste0" + dt.getTime()); //teste quantidade 0
        caso[0].setProduto(p);
        caso[0].setQuantidade(0);
        caso[0].setValorUnitario(Float.parseFloat("50.0"));
        
        caso[1] = new ProdVenda("teste1" + dt.getTime()); //teste produto null 
        caso[1].setProduto(null);
        caso[1].setQuantidade(100);
        caso[1].setValorUnitario(Float.parseFloat("50.5"));
                
        caso[2] = new ProdVenda("teste2" + dt.getTime());//teste quantidade negativa
        caso[2].setProduto(p);
        caso[2].setQuantidade(-1);
        caso[2].setValorUnitario(Float.parseFloat("100.0"));
                
        caso[3] = new ProdVenda("teste3" + dt.getTime());//teste valor unitário negativo
        caso[3].setProduto(p);
        caso[3].setQuantidade(5);
        caso[3].setValorUnitario(Float.parseFloat("-100.0"));
               
        caso[4] = new ProdVenda("teste4" + dt.getTime());//teste valor unitário 0
        caso[4].setProduto(p);
        caso[4].setQuantidade(10);
        caso[4].setValorUnitario(Float.parseFloat("0.0"));
        
        caso[5] = new ProdVenda("teste5" + dt.getTime());//teste ok
        caso[5].setProduto(p);
        caso[5].setQuantidade(10);
        caso[5].setValorUnitario(Float.parseFloat("30.0"));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of persisteProdPedEstoque method, of class ControlaProdPedEstoque.
     */
    @Test
    public void testPersisteProdPedEstoque() {
        System.out.println("Testando PersisteProdutosVenda()...");
        assertFalse(controlaProdVenda.persisteProdVenda(caso[0])); System.out.println("Caso 0: OK!");
        assertFalse(controlaProdVenda.persisteProdVenda(caso[1])); System.out.println("Caso 1: OK!");
        assertFalse(controlaProdVenda.persisteProdVenda(caso[2])); System.out.println("Caso 2: OK!");
        assertFalse(controlaProdVenda.persisteProdVenda(caso[3])); System.out.println("Caso 3: OK!");
        assertFalse(controlaProdVenda.persisteProdVenda(caso[4])); System.out.println("Caso 4: OK!");
        assertTrue(controlaProdVenda.persisteProdVenda(caso[4])); System.out.println("Caso 5: OK!");

    }
}
