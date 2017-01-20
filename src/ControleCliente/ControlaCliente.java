package ControleCliente;
import Util.HibernateUtil;
import org.hibernate.Session;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ControlaCliente {
    public Cliente criarCliente(String cliId, String nome, String sobrenome, String cpf, String rg, Date dataNascimento, String endereco, String numero, String complemento, String bairro, String CEP, String cidade, String estado, String telFixo, String telMovel, String email, String nomeMae, String nomePai, String estadoCivil, String sexo) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Cliente cliente = new Cliente(cliId, nome, sobrenome, cpf, rg, dataNascimento, endereco, numero, complemento, cidade, estado, telFixo, telMovel, email, nomeMae, nomePai, sexo, bairro, estadoCivil);
        s.save(cliente);
        s.getTransaction().commit();        
        return cliente;
    }
    
    
    public Cliente getCliente(String id){
        
        Cliente cliente = null;
        ArrayList<Cliente> listaClientes = getListaClientes();
        
        for(Cliente c : listaClientes){
            if(c.getCliId().equals(id)){
                cliente = c;
                break;
            }
        }
        
        return cliente;
    }
    
    public ArrayList<Cliente> getListaClientes() {
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) c.createQuery("From Cliente").list();
        c.getTransaction().commit();
        Collections.sort(listaClientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.getNome().compareTo(c2.getNome());
            }
        });
        return listaClientes;
    }
    
    public boolean clienteCadastrado(String cpf) {
        ArrayList<Cliente> listaClientes = getListaClientes();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (Cliente c : listaClientes) {
            if (c.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(null, "Este CPF já está em uso.");
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }
    
    public String buscaCliente(Cliente cliente){
        ArrayList<Cliente> clientes = getListaClientes();
        
        for(Cliente c : clientes){
            if(c.getCliId() == cliente.getCliId()){
                return c.getNome();
            }
        }
        return null;
    }
    
    public boolean alteraCliente(Cliente c, String sobrenome, String endereco, String numero, String complemento, String cidade, String estado, String TelFixo, String telMovel, String email) {
        c.setSobrenome(sobrenome);
        c.setEndereco(endereco);
        c.setNumero(numero);
        c.setComplemento(complemento);
        c.setCidade(cidade);
        c.setEstado(estado);
        c.setTelFixo(TelFixo);
        c.setTelMovel(telMovel);
        c.setEmail(email);
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        try {
            ss.saveOrUpdate(c);
            ss.getTransaction().commit();
            return  true;
        }   catch (Exception e) {
            ss.getTransaction().commit();
            return false;
        }
                
    }
}
