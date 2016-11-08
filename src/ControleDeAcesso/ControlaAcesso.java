package ControleDeAcesso;

import Util.HibernateUtil;
//import Apresentacao.JFrameTelaAlmoxarife;
//import Apresentacao.JFrameTelaContabilidade;
import Apresentacao.JFrameTelaGerente;
//import Apresentacao.JFrameTelaVendedor;
//import GerenciamentoDeFuncionarios.Funcionario;
import GerenciamentoDeFuncionarios.Funcionario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Juliano Cézar Chagas Tavares
 */
public class ControlaAcesso {

    public boolean permiteAcesso(String login, String senha) {

        if ((login.equals("admin")) && (senha.equals("123"))) {
            return true;
        } else if (confereLogin(login)) {
            if (confereSenha(login, senha)) {
                ArrayList<Acesso> listaAcessos = new ControlaAcesso().getListaAcessos();
                HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
                for (Acesso a : listaAcessos) {
                    if (a.getLogin().equals(login)) {
                        redirecionaAcesso(a.getFuncionario().getNivelAcesso(), a.getFuncionario());
                    }
                }
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta!");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login não existe!");
            return false;
        }
    }
    
    public Acesso buscaAcesso(Funcionario funcionario) {
        ArrayList<Acesso> acessos = getListaAcessos();
        Acesso acesso = null;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        for (Acesso a : acessos) {
            if (a.getFuncionario().getIdFunc().equals(funcionario.getIdFunc())) {
                acesso = a;
                break;
            }
        }
        s.getTransaction().commit();
        return acesso;
    }

    public Funcionario identificaUsuario(String login, String senha) {

        if ((login.equals("admin")) && (senha.equals("123"))) {
            return null;
        } else if (confereLogin(login)) {
            if (confereSenha(login, senha)) {
                ArrayList<Acesso> listaAcessos = new ControlaAcesso().getListaAcessos();
                HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
                for (Acesso a : listaAcessos) {
                    if (a.getLogin().equals(login)) {
                        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                        return a.getFuncionario();
                    }
                }
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login não existe!");
        }
        return null;
    }

    public void criarAcesso(String login, Funcionario funcionario, String senha) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Acesso acesso = new Acesso(login, funcionario, senha);
        s.save(acesso);
        s.getTransaction().commit();
    }

    public void consultaAcessos() {
        ArrayList<Acesso> listaAcessos = getListaAcessos();
        for (Acesso a : listaAcessos) {
            System.out.println("Nome do Funcionario : " + a.getFuncionario().getNome());
            System.out.println("Login               : " + a.getLogin());
            System.out.println("Senha               : " + a.getSenha());
            System.out.println("Nivel de Acesso     : " + a.getFuncionario().getNivelAcesso());
        }
    }

    public ArrayList<Acesso> getListaAcessos() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<Acesso> listaAcessos = (ArrayList<Acesso>) s.createQuery("From Acesso").list();
        Collections.sort(listaAcessos, new Comparator<Acesso>() {
            @Override
            public int compare(Acesso o1, Acesso o2) {
                return o1.getFuncionario().getNome().compareTo(o2.getFuncionario().getNome());
            }
        });
        s.getTransaction().commit();
        return listaAcessos;
    }

    public void redirecionaAcesso(int nivelAcesso, Funcionario funcionario) {
        switch (nivelAcesso) {
            case 0:
                new JFrameTelaGerente(funcionario);
                break;
            case 1:
//                new JFrameTelaVendedor();
                break;
            case 2:
//                new JFrameTelaContabilidade();
                break;
            case 3:
//                new JFrameTelaAlmoxarife();
        }
    }
    
    public boolean confereLogin(String login) {
        ArrayList<Acesso> listaAcessos = getListaAcessos();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (Acesso a : listaAcessos) {
            if (a.getLogin().equals(login)) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }

    public boolean confereSenha(String login, String senha) {
        ArrayList<Acesso> listaAcessos = getListaAcessos();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (Acesso a : listaAcessos) {
            if (a.getLogin().equals(login) && a.getSenha().equals(senha)) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }

    public boolean loginCadastrado(String login) {
        ArrayList<Acesso> listaAcessos = getListaAcessos();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (Acesso a : listaAcessos) {
            if (a.getLogin().equals(login)) {
                JOptionPane.showMessageDialog(null, "Login já cadastrado!");
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }
    
    public boolean persisteAcesso(Acesso acesso){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        try {
            s.saveOrUpdate(acesso);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().commit();
            return false;
        }
    }
}
