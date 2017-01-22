/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleEstoque;

import ControleProduto.Produto;
import ControleEstoque.ControlaProdPedEstoque;
import GerenciamentoDeFuncionarios.Funcionario;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
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
        } catch (Exception e) {
            s.getTransaction().commit();
            return false;
        }
        
/*        for(Object ppes : pedido.getProdPedEstoques())
        {
            ProdPedEstoque ppe = (ProdPedEstoque) ppes;
            
            if( (new ControlaProdPedEstoque().persisteProdPedEstoque(ppe)) == false) return false;
        }*/
        return true;
    }

    public PedidoEstoque criarPedidoEstoque(String idPedEst, Funcionario funcionario, Date dataPed, Date dataAtend, Set prodPedEstoques) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        PedidoEstoque pedido = new PedidoEstoque(idPedEst, funcionario, dataPed, dataAtend, prodPedEstoques);
        s.save(pedido);
        s.getTransaction().commit();
        return pedido;
    }

    public ArrayList<PedidoEstoque> getListaPedidoEstoque() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<PedidoEstoque> listaPedido = (ArrayList<PedidoEstoque>) s.createQuery("From PedidoEstoque").list();
        s.getTransaction().commit();
        Collections.sort(listaPedido, new Comparator<PedidoEstoque>() {
            @Override
            public int compare(PedidoEstoque o1, PedidoEstoque o2) {
                return (- o1.getDataPed().compareTo(o2.getDataPed()));
            }
        });
        return listaPedido;
    }
    
    public PedidoEstoque getPedidoEstoque(String idPedEst)
    {
        PedidoEstoque ret;
        
        ArrayList<PedidoEstoque> listaPedido = getListaPedidoEstoque();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (PedidoEstoque p : listaPedido) {
            if (p.getIdPedEst().equals(idPedEst)) {
                ret = p;
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return p;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return null;
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
