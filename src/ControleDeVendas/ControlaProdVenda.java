/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeVendas;

import ControleProduto.ControlaProduto;
import ControleProduto.Produto;
import Util.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Hibernate;
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

    public boolean persisteProdVenda(ProdVenda pv) {

        return !(pv.getQuantidade() <= 0 || pv.getValorUnitario() <= 0 || pv.getProduto() == null);

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

    public ProdVenda getProdVenda(String idProdVenda, String idVenda) {

        ArrayList<ProdVenda> listaProdVenda = getProdsVenda(idVenda);
        for (ProdVenda p : listaProdVenda) {
            if (p.getProdVendaId().equals(idProdVenda)) {
                return p;
            }
        }
        return null;
    }

    public void deletaProdsVenda(Vendas v) {

        ArrayList<ProdVenda> listaProdVenda = getProdsVenda(v.getVendaId());

        Produto produto;
        for (ProdVenda pv : listaProdVenda) {
            Hibernate.initialize(pv.getProduto().getProdId());
            produto = new ControlaProduto().getProduto(pv.getProduto().getProdId());
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + pv.getQuantidade());
            Session c = HibernateUtil.getSessionFactory().getCurrentSession();
            c.beginTransaction();
            c.saveOrUpdate(produto);
            c.delete(pv);
            c.getTransaction().commit();

        }

    }

    public void deletaProdVenda(String idProdVenda, String idVenda) {
        Produto produto;
        ProdVenda pv = getProdVenda(idProdVenda, idVenda);
        Hibernate.initialize(pv.getProduto().getProdId());
        produto = new ControlaProduto().getProduto(pv.getProduto().getProdId());
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + pv.getQuantidade());
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        c.saveOrUpdate(produto);
        c.delete(pv);
        c.getTransaction().commit();

    }

}
