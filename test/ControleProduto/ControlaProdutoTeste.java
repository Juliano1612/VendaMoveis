package ControleProduto;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author ander
 */
public class ControlaProdutoTeste {

    ControlaProduto pTeste;
    Produto caso[] = new Produto[7];

    public ControlaProdutoTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        pTeste = new ControlaProduto();
        Date dt = new Date();
        Produto p = new Produto("0", "Produto", 0);
//precoCusto e precoVenda maior que zero e precoVenda >= precoCusto
        caso[0] = new Produto("teste: 0" + dt.getTime());
        caso[0].setProdId("0");
        caso[0].setNomeProd("Produto");
        caso[0].setQuantidadeEstoque(1);
        caso[0].setDescricao("");
        caso[0].setPrecoCusto(1.0f);
        caso[0].setPrecoVenda(1.0f);
 //precoCusto limite
        caso[1] = new Produto("teste: 1" + dt.getTime());
        caso[1].setProdId("0");
        caso[1].setNomeProd("Produto");
        caso[1].setQuantidadeEstoque(0);
        caso[1].setDescricao("");
        caso[1].setPrecoCusto(0.0f);
        caso[1].setPrecoVenda(1.0f);
//precoCusto limite negativo
        caso[2] = new Produto("teste: 2" + dt.getTime());
        caso[2].setProdId("0");
        caso[2].setNomeProd("Produto");
        caso[2].setQuantidadeEstoque(0);
        caso[2].setDescricao("");
        caso[2].setPrecoCusto(-0.1f);
        caso[2].setPrecoVenda(1.0f);
//precoCusto limite positivo        
        caso[3] = new Produto("teste: 3" + dt.getTime());
        caso[3].setProdId("0");
        caso[3].setNomeProd("Produto");
        caso[3].setQuantidadeEstoque(0);
        caso[3].setDescricao("");
        caso[3].setPrecoCusto(0.1f);
        caso[3].setPrecoVenda(1.0f);
 //precoVenda limite       
        caso[4] = new Produto("teste: 4" + dt.getTime());
        caso[4].setProdId("0");
        caso[4].setNomeProd("Produto");
        caso[4].setQuantidadeEstoque(0);
        caso[4].setDescricao("");
        caso[4].setPrecoCusto(1.0f);
        caso[4].setPrecoVenda(0.0f);
//precoVenda limite negativo        
        caso[5] = new Produto("teste: 5" + dt.getTime());
        caso[5].setProdId("0");
        caso[5].setNomeProd("Produto");
        caso[5].setQuantidadeEstoque(0);
        caso[5].setDescricao("");
        caso[5].setPrecoCusto(1.0f);
        caso[5].setPrecoVenda(-0.1f);
//precoVenda limite positivo        
        caso[6] = new Produto("teste: 6" + dt.getTime());
        caso[6].setProdId("0");
        caso[6].setNomeProd("Produto");
        caso[6].setQuantidadeEstoque(0);
        caso[6].setDescricao("");
        caso[6].setPrecoCusto(1.0f);
        caso[6].setPrecoVenda(0.1f);
//precoCusto < precoVenda
        caso[7] = new Produto("teste: 7" + dt.getTime());
        caso[7].setProdId("0");
        caso[7].setNomeProd("Produto");
        caso[7].setQuantidadeEstoque(0);
        caso[7].setDescricao("");
        caso[7].setPrecoCusto(1.0f);
        caso[7].setPrecoVenda(0.9f);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPersisteProdPedEstoque() {
        System.out.println("Testando PersisteProdPedEstoque()...");
        assertTrue(pTeste.persisteProdTest(caso[0]));
        System.out.println("Caso 0: OK!");
        assertFalse(pTeste.persisteProdTest(caso[1]));
        System.out.println("Caso 1: OK!");
        assertFalse(pTeste.persisteProdTest(caso[2]));
        System.out.println("Caso 2: OK!");
        assertTrue(pTeste.persisteProdTest(caso[3]));
        System.out.println("Caso 3: OK!");
        assertFalse(pTeste.persisteProdTest(caso[4]));
        System.out.println("Caso 4: OK!");
        assertFalse(pTeste.persisteProdTest(caso[5]));
        System.out.println("Caso 5: OK!");
        assertTrue(pTeste.persisteProdTest(caso[6]));
        System.out.println("Caso 6: OK!");
        assertFalse(pTeste.persisteProdTest(caso[7]));
        System.out.println("Caso 7: OK!");
    }
}
