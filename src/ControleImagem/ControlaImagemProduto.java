package ControleImagem;

import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.hibernate.Session;


/**
 *
 * @author ander
 */
public class ControlaImagemProduto {
    
    public ImagemProduto cadastraImagem(String imagemId, byte[] imagem){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ImagemProduto imagemProduto = new ImagemProduto(imagemId, imagem);
        s.save(imagemProduto);
        s.getTransaction().commit();
        return imagemProduto;
    }
    public boolean checaChave(String prodId) {
        ArrayList<ImagemProduto> listaChaves = getListaChaves();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (ImagemProduto a : listaChaves) {
            if (a.getImagemId().equals(prodId)) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }
    
    public ArrayList<ImagemProduto> getListaChaves() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        ArrayList<ImagemProduto> listaChaves = (ArrayList<ImagemProduto>) s.createQuery("From ImagemProduto").list();
        Collections.sort(listaChaves, new Comparator<ImagemProduto>() {
            @Override
            public int compare(ImagemProduto o1, ImagemProduto o2) {
                return o1.getImagemId().compareTo(o2.getImagemId());
            }
        });
        s.getTransaction().commit();
        return listaChaves;
    }

    public ImagemProduto cadastraImagem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

