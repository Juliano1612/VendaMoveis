package GeradorDeId;

import ControleProduto.ControlaProduto;
import java.util.Random;
/**
 *
 * @author ander
 */


public class GeraId {

    ControlaProduto controlaProduto = new ControlaProduto();

    Random gerador = new Random();
     //CHAVE(1) = PRODUTO;

    public int GeraChave(int chave) {
        int id;
        id = gerador.nextInt(9000);
        if (chave == 1) { // produto
            while (controlaProduto.checaChave(Integer.toString(id)) == true) {
                id = gerador.nextInt(9000);
            }
        }
        return id;
    }

}
