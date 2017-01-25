/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import ControleDeVendas.ProdVenda;
import ControleCliente.Cliente;
import ControleDeVendas.ControlaProdVenda;
import ControleDeVendas.Vendas;
import ControleProduto.ControlaProduto;
import ControleProduto.Produto;
import GerenciamentoDeFuncionarios.Funcionario;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Hibernate;

public class JFrameNotaFiscal extends javax.swing.JFrame {

    Cliente cliente;
    Vendas vendas;
    Funcionario funcionario;
    ProdVenda prodVenda;
    Produto produto;
    ArrayList<ProdVenda> prodsVenda;

    public JFrameNotaFiscal(Cliente c, Funcionario f, Vendas v) {
        initComponents();
        cliente = c;
        funcionario = f;
        vendas = v;

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Nota Fiscal");

        jTextFieldIDVenda.setText(v.getVendaId());
        jTextFieldNomeCliente.setText(c.getNome() + " " + c.getSobrenome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabelIDVenda = new javax.swing.JLabel();
        jLabelNomeCliente = new javax.swing.JLabel();
        jTextFieldIDVenda = new javax.swing.JTextField();
        jTextFieldNomeCliente = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Gerar PDF");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelIDVenda.setText("Identificação da venda:");

        jLabelNomeCliente.setText("Nome do cliente:");

        jTextFieldIDVenda.setEditable(false);

        jTextFieldNomeCliente.setEditable(false);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomeCliente)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelIDVenda)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIDVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(jTextFieldNomeCliente))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIDVenda)
                    .addComponent(jTextFieldIDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeCliente)
                    .addComponent(jTextFieldNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Document doc = new Document();
        String NotaFiscal = vendas.getVendaId() + " " + new Date().getTime() + ".pdf";
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(NotaFiscal));
            doc.open();
            doc.add(new Paragraph("RedeBras                                  Rua Vinte e Dois Mil E Dois,519. Zona 47. Maringá - PR"));
            doc.add(new Paragraph("Nota Fiscal da venda: " + vendas.getVendaId()));
            doc.add(new Paragraph(formatador.format(data)));
            doc.add(new Paragraph("-------------------------------------------Informações do Cliente:--------------------------------------------------"));
            doc.add(new Paragraph("Identificação do cliente: " + cliente.getCliId() + "    Nome do cliente: " + cliente.getNome() + " " + cliente.getSobrenome() + "    CPF: " + cliente.getCpf()));
            doc.add(new Paragraph("Endereço: " + cliente.getEndereco() + ", " + cliente.getNumero() + "    Complemento: " + cliente.getComplemento() + "    Bairro: " + cliente.getBairro()));
            doc.add(new Paragraph("Cidade: " + cliente.getCidade() + "    Estado: " + cliente.getEstado() + "    Telefone Fixo: " + cliente.getTelFixo()));
            doc.add(new Paragraph("\t"));
            doc.add(new Paragraph("-------------------------------------------Informação do Vendedor:------------------------------------------------"));
            doc.add(new Paragraph("Identificação do Vendedor: " + funcionario.getIdFunc() + "    Nome do Vendedor: " + funcionario.getNome()));
            doc.add(new Paragraph("-------------------------------------------Informação da Compra:---------------------------------------------------"));
            doc.add(new Paragraph("Identificação da compra: " + vendas.getVendaId() + "    Data da compra: " + vendas.getDataCompra() + "\nFoma de pagamento: " + vendas.getFormaPagamento()));
            doc.add(new Paragraph("-------------------------------------------Produtos comprados:-----------------------------------------------------"));
            doc.add(new Paragraph("ID:           Nome:                                             Quantidade:          Valor: "));
            ControlaProduto controlaProduto = new ControlaProduto();
            prodsVenda = new ControlaProdVenda().getProdsVenda(vendas.getVendaId());
            for (ProdVenda pv : prodsVenda) {
                Hibernate.initialize(pv.getProduto().getProdId());
                System.out.println(pv.getProduto().getProdId());
                produto = controlaProduto.getProduto(pv.getProduto().getProdId());
                System.out.println(produto.getNomeProd());
                System.out.println();
                doc.add(new Paragraph(produto.getProdId() + "   " + produto.getNomeProd() +  "         " + pv.getQuantidade() + "     " + pv.getValorUnitario()));
            }
            doc.add(new Paragraph("\n\nValor total da compra: R$" + vendas.getValorTotal()));
        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        } finally {
            doc.close();
        }
        try {
            Desktop.getDesktop().open(new File(NotaFiscal));
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelIDVenda;
    private javax.swing.JLabel jLabelNomeCliente;
    private javax.swing.JTextField jTextFieldIDVenda;
    private javax.swing.JTextField jTextFieldNomeCliente;
    // End of variables declaration//GEN-END:variables
}
