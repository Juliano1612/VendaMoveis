
package ControleDeVendas;

import Util.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;
import ControleDeVendas.Vendas;
import java.util.ArrayList;

/**
 *
 * @author ander
 */
public class ControlaParcela {
    
        Parcela registraParcela (String parcelaId, Vendas vendas, Integer parcela, Integer parcelaPaga, Float valorTotal, Float totalPago, Float juros, Date dataParcela){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Parcela parc = new Parcela(parcelaId, vendas, parcela, parcelaPaga, valorTotal, totalPago, juros, dataParcela);
        s.save(parc);
        s.getTransaction().commit();
        return parc;
    }
     
        public ArrayList<Parcela> getParcelaId(String parcelaId) {
        ArrayList<Parcela> listaparcela = new ArrayList();
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<Parcela> listaParcela = (ArrayList<Parcela>) c.createQuery("From Parcela").list();

        for (Parcela p : listaParcela) {
            if (p.getParcela().equals(parcelaId)) {
                listaparcela.add(p);
            }
        }
        c.getTransaction().commit();

        return listaParcela;
    }

    public Parcela getProdVenda(String parcelaId, String idVenda) {

        ArrayList<Parcela> listaProdVenda = getParcelaId(idVenda);
        for (Parcela p : listaProdVenda) {
            if (p.getParcelaId().equals(parcelaId)) {
                return p;
            }
        }
        return null;
    }
        
    
}
