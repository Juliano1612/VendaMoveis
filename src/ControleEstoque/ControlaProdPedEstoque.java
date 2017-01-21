/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleEstoque;

import ControleProduto.Produto;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author rafael
 */
public class ControlaProdPedEstoque {

    public boolean persisteProdPedEstoque(ProdPedEstoque prodpedest) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        try {
            s.saveOrUpdate(prodpedest);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().commit();
            return false;
        }
    }

    public ProdPedEstoque criarProdPedEstoque(String idProdPedEstoque, PedidoEstoque pedidoEstoque, Produto produto, Integer quantidade, Integer quantidadePedAtend, Integer stat) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ProdPedEstoque prodpedest = new ProdPedEstoque(idProdPedEstoque, pedidoEstoque, produto, quantidade, quantidadePedAtend, stat);
        s.save(prodpedest);
        s.getTransaction().commit();
        return prodpedest;
    }
    
    public ArrayList<ProdPedEstoque> getListaProdPedEstoque() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<ProdPedEstoque> listaProdPed = (ArrayList<ProdPedEstoque>) s.createQuery("From ProdPedEstoque").list();
        s.getTransaction().commit();
        Collections.sort(listaProdPed, new Comparator<ProdPedEstoque>() {
            @Override
            public int compare(ProdPedEstoque o1, ProdPedEstoque o2) {
                return o1.getStat().compareTo(o2.getStat());
            }
        });
        return listaProdPed;
    }
    
    public ArrayList<ProdPedEstoque> getListaProdPedEstoque(PedidoEstoque pedido) {
        String transacao = "From ProdPedEstoque";
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<ProdPedEstoque> listaProdPed = (ArrayList<ProdPedEstoque>) s.createQuery(transacao).list();
        s.getTransaction().commit();
        Collections.sort(listaProdPed, new Comparator<ProdPedEstoque>() {
            @Override
            public int compare(ProdPedEstoque o1, ProdPedEstoque o2) {
                return o1.getStat().compareTo(o2.getStat());
            }
        });
        
        ArrayList ppearemover = new ArrayList<>();
        for(ProdPedEstoque ppe : listaProdPed)
        {
            if(!ppe.getPedidoEstoque().getIdPedEst().equals(pedido.getIdPedEst()))
                ppearemover.add(ppe);
        }
        listaProdPed.removeAll(ppearemover);
        
        return listaProdPed;
    }

    public boolean prodPedEstoqueCadastrado(String idProdPedEsotque) {
        ArrayList<ProdPedEstoque> listaPPE = getListaProdPedEstoque();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (ProdPedEstoque prodpedes : listaPPE) {
            if (prodpedes.getIdProdPedEsotque().equals(idProdPedEsotque)) {
                JOptionPane.showMessageDialog(null, "Esse item já está cadastrado!");
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }
}
