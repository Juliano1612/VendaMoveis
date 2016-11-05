package GeradorDeId;

import ControleProduto.ControlaProduto;
import ControleEstoque.GerenciaEstoque;
import ControleImagem.ControlaImagemProduto;
import java.util.Random;
/**
 *
 * @author ander
 */


public class GeraId {
    int id, tamanhoId = 9000;

    ControlaProduto controlaProduto = new ControlaProduto();
    GerenciaEstoque gerenciaEstoque = new GerenciaEstoque();
    ControlaImagemProduto controleImagem = new ControlaImagemProduto();

    Random gerador = new Random();
     //CHAVE(1) = PRODUTO;
    //CHAVE(2) = PEDIDOESTOQUE;
    //CHAVE(3) = IMAGEMPRODUTO;

    public int GeraChave(int chave) {
        id = gerador.nextInt(tamanhoId);
        if (chave == 1) { // produto
            while (controlaProduto.checaChave(Integer.toString(id)) == true) {
                id = gerador.nextInt(9000);
            }
        }else if(chave == 2){ //PedidoEstoque
            while(gerenciaEstoque.checaChave(Integer.toString(id)) == true){
                id = gerador.nextInt(tamanhoId);
            }
            
        }else if(chave == 3){ //ImagemProduto
            while(controleImagem.checaChave(Integer.toString(id)) == true){
                id = gerador.nextInt(tamanhoId);
            }
            
        }
        return id;
    }

}
