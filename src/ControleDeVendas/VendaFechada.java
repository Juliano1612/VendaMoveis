/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeVendas;

import ControleCliente.Cliente;
import GerenciamentoDeFuncionarios.Funcionario;
import java.util.Date;

/**
 *
 * @author admin
 */
public class VendaFechada extends Vendas{

    public VendaFechada(String vendaId, Cliente cliente, Funcionario funcionario, Date dataCompra, Float valorTotal, Integer numParcelas, String formaPagamento, Integer statusVenda) {
        super(vendaId, cliente, funcionario, dataCompra, valorTotal, numParcelas, formaPagamento, statusVenda);
    }   
    
}
