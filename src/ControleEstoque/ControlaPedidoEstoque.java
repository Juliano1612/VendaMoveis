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
public class ControlaPedidoEstoque {

    public boolean persistePedidoEstoque(PedidoEstoque pedido) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        try {
            s.saveOrUpdate(pedido);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().commit();
            return false;
        }
    }

    public PedidoEstoque criarPedidoEstoque(String idPedEst, Produto produto, Integer quantidade, Integer estatus, Integer quantidadePed) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
//        PedidoEstoque pedido = new PedidoEstoque(idPedEst, produto, quantidade, estatus, quantidadePed);
        PedidoEstoque pedido = new PedidoEstoque(); //só pra nao dar erro
        s.save(pedido);
        s.getTransaction().commit();
        return pedido;
    }

    public ArrayList<PedidoEstoque> getListaPedidoEstoque() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<PedidoEstoque> listaPedido = (ArrayList<PedidoEstoque>) s.createQuery("From PedidoEstoque").list();
        s.getTransaction().commit();
//        Collections.sort(listaPedido, new Comparator<PedidoEstoque>() {
//            @Override
//            public int compare(PedidoEstoque o1, PedidoEstoque o2) {
//                return o1.getProduto().getNomeProd().compareTo(o2.getProduto().getNomeProd());
//            }
//        });
        return listaPedido;
    }

    public boolean pedidoEstoqueCadastrado(String idPedEst) {
        ArrayList<PedidoEstoque> listaPedido = getListaPedidoEstoque();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (PedidoEstoque p : listaPedido) {
            if (p.getIdPedEst().equals(idPedEst)) {
                JOptionPane.showMessageDialog(null, "Pedido de reposição já cadastrado!");
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }
}
