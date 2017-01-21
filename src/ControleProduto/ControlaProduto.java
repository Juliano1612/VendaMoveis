package ControleProduto;

import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.hibernate.Session;
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
        
    
    public void atualizaProduto(Produto produto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.saveOrUpdate(produto);
        s.getTransaction().commit();
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
        s.getTransaction().commit();
        Collections.sort(listaChaves, new Comparator<Produto>() {
            @Override
            public int compare(Produto o1, Produto o2) {
                return o1.getProdId().compareTo(o2.getProdId());
            }
        });
        return listaChaves;
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
     
    public Produto getProduto(String idProd){
        ArrayList<Produto> listaProd = getListaProdutos();
        for(Produto p : listaProd){
            if(p.getProdId().equals(idProd)){
                return p;
            }
        }
        
        return null;
    }
}
