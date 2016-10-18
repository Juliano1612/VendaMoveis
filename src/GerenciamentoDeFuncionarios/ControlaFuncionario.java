/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciamentoDeFuncionarios;

import Controle.Funcionario;
import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 * @author rafael
 * 
 * Classe para controlar operacoes de dados e persistência sobre entidade
 * FUNCIONARIO
 */
public class ControlaFuncionario {

    public boolean persisteFuncionario(Funcionario funcionario) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        try {
            s.saveOrUpdate(funcionario);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            s.getTransaction().commit();
            return false;
        }
    }

    public Funcionario criarFuncionario(String idFunc, String nome, String cpf, String rg, Date dataNascimento, String estadoCivil, String nomeConjuge, String endereco, String numero, String complemento, String cidade, String estado, String cargo, Date dataContratacao, Integer nivelAcesso, String sexo, String bairro, String cep, String telefone, Integer status, Set vendases, Set faltases, Set acessos) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Funcionario funcionario = new Funcionario(idFunc, nome, cpf, rg, dataNascimento, estadoCivil, nomeConjuge, endereco, numero, complemento, cidade, estado, cargo, dataContratacao, nivelAcesso, sexo, bairro, cep, telefone, status, vendases, faltases, acessos);
        s.save(funcionario);
        s.getTransaction().commit();
        return funcionario;
    }

    public ArrayList<Funcionario> getListaFuncionarios() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<Funcionario> listaFuncionarios = (ArrayList<Funcionario>) s.createQuery("From Funcionario").list();
        s.getTransaction().commit();
        Collections.sort(listaFuncionarios, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario o1, Funcionario o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        return listaFuncionarios;
    }
    
    public ArrayList<Funcionario> getListaFuncionariosAtivos() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<Funcionario> listaFuncionarios = (ArrayList<Funcionario>) s.createQuery("From Funcionario Where status = 1").list();
        s.getTransaction().commit();
        Collections.sort(listaFuncionarios, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario o1, Funcionario o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        return listaFuncionarios;
    }
        
    public ArrayList<Funcionario> getListaFuncionariosInativos() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        ArrayList<Funcionario> listaFuncionarios = (ArrayList<Funcionario>) s.createQuery("From Funcionario Where status = 0").list();
        s.getTransaction().commit();
        Collections.sort(listaFuncionarios, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario o1, Funcionario o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        return listaFuncionarios;
    }

    public boolean funcionarioCadastrado(String cpf) {
        ArrayList<Funcionario> listaFuncionarios = getListaFuncionarios();
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        for (Funcionario f : listaFuncionarios) {
            if (f.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
                return true;
            }
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        return false;
    }
}
