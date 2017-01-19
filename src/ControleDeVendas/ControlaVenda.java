/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeVendas;

import ControleCliente.Cliente;
import GerenciamentoDeFuncionarios.Funcionario;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ControlaVenda {

    public VendaAberta novaVendaAberta(String vendaId, Funcionario funcionario) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Vendas vendaAberta = new Vendas(vendaId, funcionario, 0);
        s.save(vendaAberta);
        s.getTransaction().commit();
        return new VendaAberta(vendaId, funcionario, 0);
    }

    public VendaFechada novaVendaFechada(VendaAberta vendaAberta, Cliente cliente, Date dataCompra, Float valorTotal, int numParcelas, String formaPagamento) {
        ArrayList<ProdVenda> prodsVenda = new ControlaProdVenda().getProdsVenda(vendaAberta.getVendaId());
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Vendas vendaFechada = new Vendas(vendaAberta.getVendaId()+"1", cliente, vendaAberta.getFuncionario(), dataCompra, valorTotal, numParcelas, formaPagamento, 1);    
        for(ProdVenda pv : prodsVenda){
            pv.setVendas((Vendas) vendaFechada);
            s.saveOrUpdate(pv);
        }
        s.save(vendaFechada);
        s.delete(vendaAbertaToVenda(vendaAberta));
        s.getTransaction().commit();
        return new VendaFechada(vendaAberta.getVendaId()+"1", cliente, vendaAberta.getFuncionario(), dataCompra, valorTotal, numParcelas, formaPagamento, 1);
    }

    public VendaFinalizada novaVendaFinalizada(VendaFechada vendaFechada) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        VendaFinalizada vendaFinalizada = new VendaFinalizada(vendaFechada.getVendaId()+"2", vendaFechada.getCliente(), vendaFechada.getFuncionario(), vendaFechada.getDataCompra(), vendaFechada.getValorTotal(), vendaFechada.getNumParcelas(), vendaFechada.getFormaPagamento(), 2);
        s.save(vendaFinalizada);
        s.delete(vendaFechada);
        s.getTransaction().commit();
        return vendaFinalizada;
    }

    public int estadoVenda(String idVenda) { // 0 - aberta   1 - fechada  2 - finalizada  -1 - não existe  -2 - erro

        ArrayList<Vendas> listaVendas = getListaVendas();
        for (Vendas v : listaVendas) {
            if (v.getVendaId().equals(idVenda)) {
                switch (v.getStatusVenda()) {
                    case 0:
                        return 0;
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    default:
                        return -2;
                }
            }
        }

        return -1;
    }

    public VendaAberta getVendaAbertaFuncionario(Funcionario funcionario) {

        ArrayList<Vendas> listaVendasAbertas = getListaVendasAbertas();
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        for (Vendas v : listaVendasAbertas) {
            if (v.getFuncionario().getIdFunc().equals(funcionario.getIdFunc())) {
                c.getTransaction().commit();
                return vendaToVendaAberta(v);
            }
        }

        c.getTransaction().commit();

        return null;
    }
    public Vendas vendaAbertaToVenda(VendaAberta vendaAberta){
        
        return new Vendas(vendaAberta.getVendaId(), vendaAberta.getFuncionario(), 0);
    }

    public VendaAberta vendaToVendaAberta(Vendas venda) {

        VendaAberta vendaAberta = new VendaAberta(venda.getVendaId(), venda.getFuncionario(), 0);
        return vendaAberta;
    }

    public VendaFechada vendaToVendaFechada(Vendas vendaAberta) {

        VendaFechada vendaFechada = new VendaFechada(vendaAberta.getVendaId(), vendaAberta.getCliente(), vendaAberta.getFuncionario(), vendaAberta.getDataCompra(), vendaAberta.getValorTotal(), vendaAberta.getNumParcelas(), vendaAberta.getFormaPagamento() , 1);
        return vendaFechada;
    }
    
    public VendaFinalizada vendaToVendaFinalizada(Vendas vendaFechada) {
        VendaFinalizada vendaFinalizada = new VendaFinalizada(vendaFechada.getVendaId(), vendaFechada.getCliente(), vendaFechada.getFuncionario(), vendaFechada.getDataCompra(), vendaFechada.getValorTotal(), vendaFechada.getNumParcelas(), vendaFechada.getFormaPagamento() , 1);
        return vendaFinalizada;
    }


    public void excluiVendaAberta(Funcionario funcionario) {

        ArrayList<Vendas> listaVendasAbertas = getListaVendasAbertas();

        ControlaProdVenda controlaProdVenda = new ControlaProdVenda();
        for (Vendas v : listaVendasAbertas) {
            if (v.getFuncionario().getIdFunc().equals(funcionario.getIdFunc())) {
                //chama delete prodVenda
                controlaProdVenda.deletaProdsVenda(v);
                Session c = HibernateUtil.getSessionFactory().getCurrentSession();
                c.beginTransaction();
                c.delete(v);
                c.getTransaction().commit();

                break;
            }
        }

    }

    public ArrayList<Vendas> getListaVendasAbertas() {
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<Vendas> listaVendas = (ArrayList<Vendas>) c.createQuery("From Vendas Where statusVenda is 0").list();
        c.getTransaction().commit();

        return listaVendas;
    }

    public ArrayList<VendaFechada> getListaVendasFechadas() {
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<Vendas> listaVendas = (ArrayList<Vendas>) c.createQuery("From Vendas Where statusVenda is 1").list();
        c.getTransaction().commit();
        ArrayList<VendaFechada> listaVendasFechadas = new ArrayList();
        for(Vendas v : listaVendas){
            listaVendasFechadas.add(vendaToVendaFechada(v));
        }
        Collections.sort(listaVendasFechadas, new Comparator<VendaFechada>() {
            @Override
            public int compare(VendaFechada v1, VendaFechada v2) {
                return v1.getDataCompra().compareTo(v2.getDataCompra());
            }
        });
        return listaVendasFechadas;
    }

    public ArrayList<VendaFinalizada> getListaVendasFinalizadas() {
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<Vendas> listaVendas = (ArrayList<Vendas>) c.createQuery("From Vendas Where statusVenda is 2").list();
        c.getTransaction().commit();
        ArrayList<VendaFinalizada> listaVendasFinalizadas = new ArrayList();
        for(Vendas v : listaVendas){
            listaVendasFinalizadas.add(vendaToVendaFinalizada(v));
        }
        Collections.sort(listaVendasFinalizadas, new Comparator<VendaFinalizada>() {
            @Override
            public int compare(VendaFinalizada v1, VendaFinalizada v2) {
                return v1.getDataCompra().compareTo(v2.getDataCompra());
            }
        });
        return listaVendasFinalizadas;
    }

    public ArrayList<Vendas> getListaVendas() {
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<Vendas> listaVendas = (ArrayList<Vendas>) c.createQuery("From Vendas").list();
        c.getTransaction().commit();
        Collections.sort(listaVendas, new Comparator<Vendas>() {
            @Override
            public int compare(Vendas v1, Vendas v2) {
                return v1.getDataCompra().compareTo(v2.getDataCompra());
            }
        });
        return listaVendas;
    }
}
