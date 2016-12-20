/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeVendas;

import ControleCliente.Cliente;
import GerenciamentoDeFuncionarios.Funcionario;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author admin
 */
public class VendaAberta extends Vendas{

    public VendaAberta(String vendaId, Cliente cliente, Funcionario funcionario, Date dataCompra, Float valorTotal, Integer numParcelas, String formaPagamento, Integer statusVenda) {
        super(vendaId, cliente, funcionario, dataCompra, valorTotal, numParcelas, formaPagamento, statusVenda);
    }

    VendaAberta(String vendaId, Funcionario funcionario, int statusVenda) {
        super(vendaId, funcionario, statusVenda);
    }
    
    
    
}
