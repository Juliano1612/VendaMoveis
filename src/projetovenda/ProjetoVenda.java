/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetovenda;

import ControleDeAcesso.JFrameTelaLogin;
import ControleDeVendas.ControlaVenda;
import Util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ander
 */
public class ProjetoVenda {

    /**
     * @param args the command line arguments
     */
        
    
    public static void main(String[] args) {
        // TODO code application logic here
        JFrameTelaLogin jFrameTelaLogin = new JFrameTelaLogin();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        
        

    }

}
