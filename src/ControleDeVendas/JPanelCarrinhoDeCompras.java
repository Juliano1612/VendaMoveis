/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeVendas;

import GerenciamentoDeFuncionarios.Funcionario;
import Util.HibernateUtil;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author Juliano
 */
public class JPanelCarrinhoDeCompras extends javax.swing.JPanel {

    /**
     * Creates new form JPanelCarrinhoDeCompras
     */
    Funcionario funcionario;
    DefaultTableModel tableModel;
    float valorTotal = 0;
    ArrayList<ProdVenda> prodsVenda;

    public JPanelCarrinhoDeCompras(Funcionario func, String idVendaAberta) {
        initComponents();

        funcionario = func;
        tableModel = (DefaultTableModel) jTableCarrinho.getModel();

        tableModel.setNumRows(0);

        prodsVenda = new ControlaProdVenda().getProdsVenda(idVendaAberta);
        
        Session c = HibernateUtil.getSessionFactory().getCurrentSession();
        c.beginTransaction();
        for (ProdVenda pv : prodsVenda) {
            tableModel.addRow(new Object[]{pv.getProduto().getProdId(), pv.getProduto().getNomeProd(), pv.getValorUnitario(), pv.getQuantidade(), ""+(pv.getQuantidade() * pv.getValorUnitario()), false});
        }
        c.getTransaction().commit();
        
        if (prodsVenda.isEmpty()) {
            jLabelValorTotal.setText("Valor Total = R$ " + valorTotal);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCarrinho = new javax.swing.JTable();
        jLabelValorTotal = new javax.swing.JLabel();
        jButtonRemoverSelecionados = new javax.swing.JButton();
        jLabelTituloCarrinho = new javax.swing.JLabel();
        jButtonConfirmarCompra = new javax.swing.JButton();

        jTableCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor Unitário", "Quantidade", "Valor Total", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCarrinho.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableCarrinho);
        if (jTableCarrinho.getColumnModel().getColumnCount() > 0) {
            jTableCarrinho.getColumnModel().getColumn(0).setResizable(false);
            jTableCarrinho.getColumnModel().getColumn(1).setResizable(false);
            jTableCarrinho.getColumnModel().getColumn(2).setResizable(false);
            jTableCarrinho.getColumnModel().getColumn(3).setResizable(false);
            jTableCarrinho.getColumnModel().getColumn(4).setResizable(false);
            jTableCarrinho.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabelValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonRemoverSelecionados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRemoverSelecionados.setText("Remover Selecionados");

        jLabelTituloCarrinho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTituloCarrinho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloCarrinho.setText("Carrinho de Compras");

        jButtonConfirmarCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonConfirmarCompra.setText("Confirmar Compra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 395, Short.MAX_VALUE)
                        .addComponent(jLabelTituloCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(402, 402, 402))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonRemoverSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonConfirmarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabelTituloCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConfirmarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButtonRemoverSelecionados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmarCompra;
    private javax.swing.JButton jButtonRemoverSelecionados;
    private javax.swing.JLabel jLabelTituloCarrinho;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCarrinho;
    // End of variables declaration//GEN-END:variables
}
