/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeVendas;

import ControleCliente.Cliente;
import ControleCliente.ControlaCliente;
import ControleProduto.ControlaProduto;
import ControleProduto.Produto;
import GerenciamentoDeFuncionarios.ControlaFuncionario;
import GerenciamentoDeFuncionarios.Funcionario;
import Relatorios.Boleto;
import Relatorios.JFrameBoleto;
import com.itextpdf.text.BadElementException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Hibernate;

/**
 *
 * @author admin
 */
public class JPanelVendasFechadas extends javax.swing.JPanel {

    /**
     * Creates new form JPanelVendasFechadas
     */
    DefaultTableModel modelo;
    ArrayList<VendaFechada> vendas;
    Funcionario func;
    Cliente cli;
    VendaFechada venda;
    ArrayList<ProdVenda> prodsVenda;
    DefaultTableModel tableModel;

    public JPanelVendasFechadas() {
        initComponents();
        jInternalFrameVendaFechada.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrameVendaFechada = new javax.swing.JInternalFrame();
        jLabelIDVenda = new javax.swing.JLabel();
        jLabelNomeFunc = new javax.swing.JLabel();
        jLabelNomeCli = new javax.swing.JLabel();
        jLabelIDFunc = new javax.swing.JLabel();
        jLabelIDCli = new javax.swing.JLabel();
        jLabelDataVenda = new javax.swing.JLabel();
        jLabelValorTotal = new javax.swing.JLabel();
        jLabelFormaPagamento = new javax.swing.JLabel();
        jLabelQuantidadeParcelas = new javax.swing.JLabel();
        jLabelVencimentoPagamento = new javax.swing.JLabel();
        jTextFieldIDVenda = new javax.swing.JTextField();
        jTextFieldNomeFunc = new javax.swing.JTextField();
        jTextFieldIDFunc = new javax.swing.JTextField();
        jTextFieldIDCli = new javax.swing.JTextField();
        jTextFieldValorTotal = new javax.swing.JTextField();
        jTextFieldVencPagamento = new javax.swing.JTextField();
        jTextFieldNomeCli = new javax.swing.JTextField();
        jTextFieldDataVenda = new javax.swing.JTextField();
        jTextFieldFormaPagamento = new javax.swing.JTextField();
        jTextFieldNumeroParcelas = new javax.swing.JTextField();
        jButtonGerarBoletoPagamento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdsVenda = new javax.swing.JTable();
        jButtonFecharInternal = new javax.swing.JButton();
        jButtonConfirmarPagamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendasFechadas = new javax.swing.JTable();
        jTextFieldCampoPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jComboBoxFiltroPesquisa = new javax.swing.JComboBox<>();
        jButtonConsultarVenda = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jInternalFrameVendaFechada.setVisible(true);

        jLabelIDVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelIDVenda.setText("ID da Venda");

        jLabelNomeFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNomeFunc.setText("Nome do Funcionário");

        jLabelNomeCli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNomeCli.setText("Nome do Cliente");

        jLabelIDFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelIDFunc.setText("ID do Funcionario");

        jLabelIDCli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelIDCli.setText("ID do Cliente");

        jLabelDataVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelDataVenda.setText("Data da Venda");

        jLabelValorTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelValorTotal.setText("Valor Total");

        jLabelFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelFormaPagamento.setText("Forma de Pagamento");

        jLabelQuantidadeParcelas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelQuantidadeParcelas.setText("Quantidade de Parcelas");

        jLabelVencimentoPagamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelVencimentoPagamento.setText("Vencimento do Pagamento");

        jTextFieldIDVenda.setEditable(false);
        jTextFieldIDVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldNomeFunc.setEditable(false);
        jTextFieldNomeFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldIDFunc.setEditable(false);
        jTextFieldIDFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldIDCli.setEditable(false);
        jTextFieldIDCli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldValorTotal.setEditable(false);
        jTextFieldValorTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldVencPagamento.setEditable(false);
        jTextFieldVencPagamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldNomeCli.setEditable(false);
        jTextFieldNomeCli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldDataVenda.setEditable(false);
        jTextFieldDataVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldFormaPagamento.setEditable(false);
        jTextFieldFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldNumeroParcelas.setEditable(false);
        jTextFieldNumeroParcelas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButtonGerarBoletoPagamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGerarBoletoPagamento.setText("Gerar Boleto para Pagamento");
		jButtonGerarBoletoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarBoletoPagamentoActionPerformed(evt);
            }
        });

        jTableProdsVenda.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "ID", "Nome", "Valor Unitário", "Quantidade", "Valor Total"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableProdsVenda.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableProdsVenda);

        jButtonFecharInternal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonFecharInternal.setText("Fechar");
        jButtonFecharInternal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharInternalActionPerformed(evt);
            }
        });

        jButtonConfirmarPagamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonConfirmarPagamento.setText("Confirmar Pagamento");
        jButtonConfirmarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrameVendaFechadaLayout = new javax.swing.GroupLayout(jInternalFrameVendaFechada.getContentPane());
        jInternalFrameVendaFechada.getContentPane().setLayout(jInternalFrameVendaFechadaLayout);
        jInternalFrameVendaFechadaLayout.setHorizontalGroup(
                jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrameVendaFechadaLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jInternalFrameVendaFechadaLayout.createSequentialGroup()
                                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelQuantidadeParcelas)
                                                        .addComponent(jLabelNomeFunc)
                                                        .addComponent(jLabelIDVenda)
                                                        .addComponent(jLabelNomeCli)
                                                        .addComponent(jLabelDataVenda)
                                                        .addComponent(jLabelFormaPagamento))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jInternalFrameVendaFechadaLayout.createSequentialGroup()
                                                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jTextFieldNumeroParcelas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                                                        .addComponent(jTextFieldFormaPagamento, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldDataVenda)
                                                                        .addComponent(jTextFieldNomeCli)
                                                                        .addComponent(jTextFieldNomeFunc))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelIDFunc, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabelIDCli, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabelValorTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabelVencimentoPagamento, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldValorTotal)
                                                                        .addComponent(jTextFieldIDFunc)
                                                                        .addComponent(jTextFieldIDCli)
                                                                        .addGroup(jInternalFrameVendaFechadaLayout.createSequentialGroup()
                                                                                .addComponent(jTextFieldVencPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addComponent(jTextFieldIDVenda))
                                                .addGap(42, 42, 42))
                                        .addGroup(jInternalFrameVendaFechadaLayout.createSequentialGroup()
                                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jInternalFrameVendaFechadaLayout.createSequentialGroup()
                                                                .addComponent(jButtonGerarBoletoPagamento)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(jButtonConfirmarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(364, 364, 364)
                                                                .addComponent(jButtonFecharInternal)))
                                                .addGap(0, 27, Short.MAX_VALUE))))
        );
        jInternalFrameVendaFechadaLayout.setVerticalGroup(
                jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrameVendaFechadaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelIDVenda)
                                        .addComponent(jTextFieldIDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNomeFunc)
                                        .addComponent(jLabelIDFunc)
                                        .addComponent(jTextFieldNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldIDFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNomeCli)
                                        .addComponent(jLabelIDCli)
                                        .addComponent(jTextFieldIDCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDataVenda)
                                        .addComponent(jLabelValorTotal)
                                        .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFormaPagamento)
                                        .addComponent(jLabelVencimentoPagamento)
                                        .addComponent(jTextFieldVencPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelQuantidadeParcelas)
                                        .addComponent(jTextFieldNumeroParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrameVendaFechadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonGerarBoletoPagamento)
                                        .addComponent(jButtonFecharInternal)
                                        .addComponent(jButtonConfirmarPagamento))
                                .addContainerGap())
        );

        add(jInternalFrameVendaFechada, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 920, 560));

        jTableVendasFechadas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "ID", "Data", "Cliente", "Funcionário", "ValorTotal"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTableVendasFechadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableVendasFechadas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 103, 927, 396));

        jTextFieldCampoPesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldCampoPesquisa.setText("Pesquisar venda");
        add(jTextFieldCampoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 42, 696, 30));

        jButtonPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        add(jButtonPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(878, 42, -1, -1));

        jComboBoxFiltroPesquisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxFiltroPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nome do Cliente", "Nome do Vendedor", "ID"}));
        add(jComboBoxFiltroPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 43, -1, -1));

        jButtonConsultarVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonConsultarVenda.setText("Consultar Venda");
        jButtonConsultarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarVendaActionPerformed(evt);
            }
        });
        add(jButtonConsultarVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 526, 135, 31));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        //BOTÃO DE PESQUISAR PRODUTOS    

        switch (jComboBoxFiltroPesquisa.getSelectedIndex()) {
            case 0:
                if (jTextFieldCampoPesquisa.getText().equals("Pesquisar venda")) {
                    JOptionPane.showMessageDialog(null, "Digite o nome do cliente para a busca.");
                } else {
                    modelo = (DefaultTableModel) jTableVendasFechadas.getModel();
                    modelo.setNumRows(0);
                    vendas = new ControlaVenda().getListaVendasFechadas();
                    for (VendaFechada v : vendas) {
                        Hibernate.initialize(v.getCliente().getCliId());
                        cli = new ControlaCliente().getCliente(v.getCliente().getCliId());
                        if (cli.getNome().startsWith(jTextFieldCampoPesquisa.getText())) {
                            Hibernate.initialize(v.getFuncionario().getIdFunc());
                            func = new ControlaFuncionario().getFuncionario(v.getFuncionario().getIdFunc());
                            modelo.addRow(new Object[]{v.getVendaId(), v.getDataCompra(), cli.getNome(), func.getNome(), v.getValorTotal()});
                        }
                    }
                }
                break;

            case 1:
                if (jTextFieldCampoPesquisa.getText().equals("Pesquisar venda")) {
                    JOptionPane.showMessageDialog(null, "Digite o nome do funcionario para a busca.");
                } else {
                    modelo = (DefaultTableModel) jTableVendasFechadas.getModel();
                    modelo.setNumRows(0);
                    vendas = new ControlaVenda().getListaVendasFechadas();
                    for (VendaFechada v : vendas) {
                        Hibernate.initialize(v.getFuncionario().getIdFunc());
                        func = new ControlaFuncionario().getFuncionario(v.getFuncionario().getIdFunc());
                        if (func.getNome().startsWith(jTextFieldCampoPesquisa.getText())) {
                            Hibernate.initialize(v.getCliente().getCliId());
                            cli = new ControlaCliente().getCliente(v.getCliente().getCliId());
                            modelo.addRow(new Object[]{v.getVendaId(), v.getDataCompra(), cli.getNome(), func.getNome(), v.getValorTotal()});
                        }
                    }
                }
                break;
            case 2:
                if (jTextFieldCampoPesquisa.getText().equals("Pesquisar venda")) {
                    JOptionPane.showMessageDialog(null, "Digite o ID da venda para começar a busca.");
                } else {
                    modelo = (DefaultTableModel) jTableVendasFechadas.getModel();
                    modelo.setNumRows(0);
                    vendas = new ControlaVenda().getListaVendasFechadas();
                    for (VendaFechada v : vendas) {
                        if (v.getVendaId().startsWith(jTextFieldCampoPesquisa.getText())) {
                            Hibernate.initialize(v.getFuncionario().getIdFunc());
                            func = new ControlaFuncionario().getFuncionario(v.getFuncionario().getIdFunc());
                            Hibernate.initialize(v.getCliente().getCliId());
                            cli = new ControlaCliente().getCliente(v.getCliente().getCliId());
                            modelo.addRow(new Object[]{v.getVendaId(), v.getDataCompra(), cli.getNome(), func.getNome(), v.getValorTotal()});
                        }
                    }
                }
                break;
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonConsultarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarVendaActionPerformed
        // TODO add your handling code here:
        jButtonConsultarVenda.setVisible(false);
        int indiceProd = jTableVendasFechadas.getSelectedRow();
        if (indiceProd == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para saber mais detalhes do produto.");
        } else {
            venda = new ControlaVenda().vendaToVendaFechada(new ControlaVenda().getVenda((String) jTableVendasFechadas.getValueAt(indiceProd, 0)));
            if (!venda.getFormaPagamento().equals("Boleto")) {
                jButtonGerarBoletoPagamento.setVisible(false);
            } else {
                jButtonGerarBoletoPagamento.setVisible(true);
            }
            jTextFieldIDVenda.setText(venda.getVendaId());
            jTextFieldIDFunc.setText(func.getIdFunc());
            jTextFieldNomeFunc.setText(func.getNome());
            jTextFieldIDCli.setText(cli.getCliId());
            jTextFieldNomeCli.setText(cli.getNome() + " " + cli.getSobrenome());
            jTextFieldDataVenda.setText(venda.getDataCompra().toString());
            jTextFieldFormaPagamento.setText(venda.getFormaPagamento());
            jTextFieldNumeroParcelas.setText(venda.getNumParcelas().toString());
            jTextFieldValorTotal.setText(venda.getValorTotal().toString());
            jTextFieldVencPagamento.setText("sla");
            jInternalFrameVendaFechada.setVisible(true);
            tableModel = (DefaultTableModel) jTableProdsVenda.getModel();
            tableModel.setNumRows(0);
            prodsVenda = new ControlaProdVenda().getProdsVenda(venda.getVendaId());
            ControlaProduto controlaProduto = new ControlaProduto();
            Produto produto;

            for (ProdVenda pv : prodsVenda) {
                Hibernate.initialize(pv.getProduto().getProdId());
                produto = controlaProduto.getProduto(pv.getProduto().getProdId());
                tableModel.addRow(new Object[]{produto.getProdId(), produto.getNomeProd(), pv.getValorUnitario(), pv.getQuantidade(), "" + (pv.getQuantidade() * pv.getValorUnitario()), false});
            }

        }
    }//GEN-LAST:event_jButtonConsultarVendaActionPerformed

    private void jButtonConfirmarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarPagamentoActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(
                null,
                "Essa operação não pode ser revertida. Deseja continuar?",
                "Confirmar Opção",
                JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {

            new ControlaVenda().novaVendaFinalizada(venda);

            JOptionPane.showMessageDialog(null, "A venda foi finalizada!");
            jButtonPesquisarActionPerformed(evt);
            jInternalFrameVendaFechada.setVisible(false);
        }
    }//GEN-LAST:event_jButtonConfirmarPagamentoActionPerformed

    private void jButtonFecharInternalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharInternalActionPerformed
        // TODO add your handling code here:
        jInternalFrameVendaFechada.setVisible(false);
        jButtonConsultarVenda.setVisible(true);
    }//GEN-LAST:event_jButtonFecharInternalActionPerformed

<<<<<<< HEAD
    private void jButtonGerarBoletoPagamentoActionPerformed(java.awt.event.ActionEvent evt){
        
        JFrameBoleto boleto = new JFrameBoleto(cli, venda);
=======
    private void jButtonGerarBoletoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

>>>>>>> 2b8d9fc2f9012966f61a19e028cd721d7c5d66bc
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmarPagamento;
    private javax.swing.JButton jButtonConsultarVenda;
    private javax.swing.JButton jButtonFecharInternal;
    private javax.swing.JButton jButtonGerarBoletoPagamento;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<String> jComboBoxFiltroPesquisa;
    private javax.swing.JInternalFrame jInternalFrameVendaFechada;
    private javax.swing.JLabel jLabelDataVenda;
    private javax.swing.JLabel jLabelFormaPagamento;
    private javax.swing.JLabel jLabelIDCli;
    private javax.swing.JLabel jLabelIDFunc;
    private javax.swing.JLabel jLabelIDVenda;
    private javax.swing.JLabel jLabelNomeCli;
    private javax.swing.JLabel jLabelNomeFunc;
    private javax.swing.JLabel jLabelQuantidadeParcelas;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JLabel jLabelVencimentoPagamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProdsVenda;
    private javax.swing.JTable jTableVendasFechadas;
    private javax.swing.JTextField jTextFieldCampoPesquisa;
    private javax.swing.JTextField jTextFieldDataVenda;
    private javax.swing.JTextField jTextFieldFormaPagamento;
    private javax.swing.JTextField jTextFieldIDCli;
    private javax.swing.JTextField jTextFieldIDFunc;
    private javax.swing.JTextField jTextFieldIDVenda;
    private javax.swing.JTextField jTextFieldNomeCli;
    private javax.swing.JTextField jTextFieldNomeFunc;
    private javax.swing.JTextField jTextFieldNumeroParcelas;
    private javax.swing.JTextField jTextFieldValorTotal;
    private javax.swing.JTextField jTextFieldVencPagamento;
    // End of variables declaration//GEN-END:variables
}
