package ControleEstoque;

import ControleProduto.Produto;
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
public class GerenciaEstoque {
    
    public CEstoque cadastraEstoque(String idPedEst, Produto produto, Integer quantidade, Integer estatus, Integer quantidadePed){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        CEstoque cEstoque = new CEstoque(idPedEst, produto, quantidade, estatus, quantidadePed);
        s.save(cEstoque);
        s.getTransaction().commit();
        return cEstoque;  
    }
    
    public boolean checaChave(String idPedEst) {
        ArrayList<PedidoEstoque> listaChaves = getListaChaves();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (PedidoEstoque a : listaChaves) {
            if (a.getIdPedEst().equals(idPedEst)) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }
    
    public ArrayList<PedidoEstoque> getListaChaves() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<PedidoEstoque> listaChaves = (ArrayList<PedidoEstoque>) s.createQuery("From PedidoEstoque").list();
        Collections.sort(listaChaves, new Comparator<PedidoEstoque>() {
            @Override
            public int compare(PedidoEstoque o1, PedidoEstoque o2) {
                return o1.getIdPedEst().compareTo(o2.getIdPedEst());
            }
        });
        s.getTransaction().commit();
        return listaChaves;
    }
    private static class CEstoque {

        public CEstoque(String idPedEst, Produto produto, Integer quantidade, Integer estatus, Integer quantidadePed) {
        }
    }

    private static class ControlaEstoque {

        public ControlaEstoque() {
        }
    }
    
}
