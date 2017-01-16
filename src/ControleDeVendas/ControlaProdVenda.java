/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeVendas;

import ControleProduto.Produto;
import Util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ControlaProdVenda {

    public void novoProdVenda(String prodVendaId, Produto produto, Vendas vendas, Integer quantidade, Float valorUnitario) {

        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ProdVenda prodVenda = new ProdVenda(prodVendaId, produto, vendas, quantidade, valorUnitario);
        s.save(prodVenda);
        s.getTransaction().commit();
    }

    public ArrayList<ProdVenda> getProdsVenda(String idVenda) {
        ArrayList<ProdVenda> minhaVenda = new ArrayList();
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<ProdVenda> listaProdVenda = (ArrayList<ProdVenda>) c.createQuery("From ProdVenda").list();

        for (ProdVenda pv : listaProdVenda) {
            if (pv.getVendas().getVendaId().equals(idVenda)) {
                minhaVenda.add(pv);
            }
        }
        c.getTransaction().commit();

        return minhaVenda;
    }

}
