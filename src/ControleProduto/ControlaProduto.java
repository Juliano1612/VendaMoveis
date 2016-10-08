package ControleProduto;

import ControleEstoque.GerenciaEstoque;
import Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
/**
 *
 * @author ander
 */
public class ControlaProduto {
    public boolean persisteProduto(Produto produto, String nomeProd, Integer Quantidade, String descricao, Float precoVenda, Float precoCusto){
        produto.setNomeProd(nomeProd);
        produto.setQuantidadeEstoque(Quantidade);
        produto.setDescricao(descricao);
        produto.setPrecoVenda(precoVenda);
        produto.setPrecoCusto(precoCusto);
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        try {
            s.saveOrUpdate(produto);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().commit();
            return false;
        }
    }
    
    public boolean quantidadeProduto(Produto produto,Integer Quantidade){
        produto.setQuantidadeEstoque(Quantidade);
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        try {
            s.saveOrUpdate(produto);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().commit();
            return false;
        }
    }
    
    public void checaEstoque(Produto produto){
        GerenciaEstoque gerenciaEstoque = new GerenciaEstoque();
        Integer quantidade;
        quantidade = produto.getQuantidadeEstoque();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        if(quantidade <= 4){

        }
    }
    
    public Produto cadastraProduto(String prodId, String nomeProd, Integer quantidadeEstoque, String descricao, Float precoVenda, Float precoCusto, Float altura, Float largura, Float profundidade, String marca){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Produto produto = new Produto(prodId,nomeProd,quantidadeEstoque,descricao,precoVenda,precoCusto, altura, largura, profundidade, marca);
        s.save(produto);
        s.getTransaction().commit();
        return produto;
    }
    
    public boolean checaChave(String prodId) {
        ArrayList<Produto> listaChaves = getListaChaves();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (Produto a : listaChaves) {
            if (a.getProdId().equals(prodId)) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }
    
    public ArrayList<Produto> getListaChaves() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<Produto> listaChaves = (ArrayList<Produto>) s.createQuery("From Produto").list();
        Collections.sort(listaChaves, new Comparator<Produto>() {
            @Override
            public int compare(Produto o1, Produto o2) {
                return o1.getProdId().compareTo(o2.getProdId());
            }
        });
        s.getTransaction().commit();
        return listaChaves;
    }
    
        
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


     public ArrayList<Produto> getListaProdutos() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<Produto> listaProdutos = (ArrayList<Produto>) s.createQuery("From Produto").list();
        s.getTransaction().commit();
        Collections.sort(listaProdutos, new Comparator<Produto>() {
            public int compare(Produto o1, Produto o2) {
                return o1.getNomeProd().compareTo(o2.getNomeProd());
            }
        });
        return listaProdutos;
    }
    private static class Produtos {

        public Produtos() {
        }
    }
    
}
