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
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        VendaFechada vendaFechada = new VendaFechada(vendaAberta.getVendaId(), cliente, vendaAberta.getFuncionario(), dataCompra, valorTotal, numParcelas, formaPagamento, 1);
        s.save(vendaFechada);
        s.delete(vendaAberta);
        s.getTransaction().commit();
        return vendaFechada;
    }

    public VendaFinalizada novaVendaFinalizada(VendaFechada vendaFechada) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        VendaFinalizada vendaFinalizada = new VendaFinalizada(vendaFechada.getVendaId(), vendaFechada.getCliente(), vendaFechada.getFuncionario(), vendaFechada.getDataCompra(), vendaFechada.getValorTotal(), vendaFechada.getNumParcelas(), vendaFechada.getFormaPagamento(), 2);
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
            System.out.println(v.getFuncionario().getIdFunc() + "       " + funcionario.getIdFunc());
            if (v.getFuncionario().getIdFunc().equals(funcionario.getIdFunc())) {
                c.getTransaction().commit();
                return (VendaAberta) v;
            }
        }

        c.getTransaction().commit();

        return null;
    }
    
    public void excluiVendaAberta(Funcionario funcionario) {

        ArrayList<Vendas> listaVendasAbertas = getListaVendasAbertas();
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        for (Vendas v : listaVendasAbertas) {
            if (v.getFuncionario().getIdFunc().equals(funcionario.getIdFunc())) {
                c.getTransaction().commit();
                c.delete(v);
            }
        }

        c.getTransaction().commit();
    }

    public ArrayList<Vendas> getListaVendasAbertas() {
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<Vendas> listaVendas = (ArrayList<Vendas>) c.createQuery("From Vendas Where vendaId is 0").list();
        c.getTransaction().commit();
        Collections.sort(listaVendas, new Comparator<Vendas>() {
            @Override
            public int compare(Vendas v1, Vendas v2) {
                return v1.getDataCompra().compareTo(v2.getDataCompra());
            }
        });
        return listaVendas;
    }

    public ArrayList<Vendas> getListaVendasFechadas() {
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<Vendas> listaVendas = (ArrayList<Vendas>) c.createQuery("From Vendas Where vendaId is 1").list();
        c.getTransaction().commit();
        Collections.sort(listaVendas, new Comparator<Vendas>() {
            @Override
            public int compare(Vendas v1, Vendas v2) {
                return v1.getDataCompra().compareTo(v2.getDataCompra());
            }
        });
        return listaVendas;
    }

    public ArrayList<Vendas> getListaVendasFinalizadas() {
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<Vendas> listaVendas = (ArrayList<Vendas>) c.createQuery("From Vendas Where vendaId is 2").list();
        c.getTransaction().commit();
        Collections.sort(listaVendas, new Comparator<Vendas>() {
            @Override
            public int compare(Vendas v1, Vendas v2) {
                return v1.getDataCompra().compareTo(v2.getDataCompra());
            }
        });
        return listaVendas;
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
