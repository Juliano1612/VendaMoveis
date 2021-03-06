package ControleEstoque;
// Generated 20/12/2016 16:53:10 by Hibernate Tools 4.3.1


import GerenciamentoDeFuncionarios.Funcionario;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PedidoEstoque generated by hbm2java
 */
public class PedidoEstoque  implements java.io.Serializable {


     private String idPedEst;
     private Funcionario funcionario;
     private Date dataPed;
     private Date dataAtend;
     private Set prodPedEstoques = new HashSet(0);

    public PedidoEstoque() {
    }

	
    public PedidoEstoque(String idPedEst) {
        this.idPedEst = idPedEst;
    }
    public PedidoEstoque(String idPedEst, Funcionario funcionario, Date dataPed, Date dataAtend, Set prodPedEstoques) {
       this.idPedEst = idPedEst;
       this.funcionario = funcionario;
       this.dataPed = dataPed;
       this.dataAtend = dataAtend;
       this.prodPedEstoques = prodPedEstoques;
    }
   
    public String getIdPedEst() {
        return this.idPedEst;
    }
    
    public void setIdPedEst(String idPedEst) {
        this.idPedEst = idPedEst;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Date getDataPed() {
        return this.dataPed;
    }
    
    public void setDataPed(Date dataPed) {
        this.dataPed = dataPed;
    }
    public Date getDataAtend() {
        return this.dataAtend;
    }
    
    public void setDataAtend(Date dataAtend) {
        this.dataAtend = dataAtend;
    }
    public Set getProdPedEstoques() {
        return this.prodPedEstoques;
    }
    
    public void setProdPedEstoques(Set prodPedEstoques) {
        this.prodPedEstoques = prodPedEstoques;
    }




}


