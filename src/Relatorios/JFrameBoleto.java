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
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;

public class JFrameBoleto extends javax.swing.JFrame {

    Cliente cliente;
    Vendas vendas;
    Funcionario funcionario;
    ProdVenda prodVenda;
    Produto produto;
    ArrayList<ProdVenda> prodsVenda;

    public JFrameBoleto(Cliente c,  Vendas v) {
        initComponents();
        cliente = c;
        vendas = v;
        
        System.out.print(cliente.getCliId()+"\n");
        System.out.print(vendas.getVendaId()+"\n");

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Boleto");

        jTextFieldIDVenda.setText(c.getCliId() + v.getVendaId());
        jTextFieldValor.setText(String.valueOf(v.getValorTotal()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBoleto = new javax.swing.JButton();
        jLabelIDVenda = new javax.swing.JLabel();
        jTextFieldIDVenda = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jLabelIDVenda1 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonBoleto.setText("Gerar boleto");
        jButtonBoleto.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBoletoActionPerformed(evt);
            }
        });

        jLabelIDVenda.setText("Boleto a ser gerado:");

        jTextFieldIDVenda.setEditable(false);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelIDVenda1.setText("Valor a ser gerado:");

        jTextFieldValor.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                                .addComponent(jButtonBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelIDVenda)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextFieldIDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIDVenda1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIDVenda)
                    .addComponent(jTextFieldIDVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIDVenda1)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBoletoActionPerformed
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Document doc = new Document();
        String Boleto = vendas.getVendaId() + cliente.getCliId() + ".pdf";
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(Boleto));
            doc.open();
            Image logo = null;
            try {
                logo = Image.getInstance("D:\\Users\\ander\\Desktop\\git\\VendaMoveis\\src\\ControleBoleto\\LogoBanco.png");
            } catch (BadElementException ex) {
                Logger.getLogger(JFrameBoleto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JFrameBoleto.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.add(logo);

            
            doc.add(new Paragraph("-----------------------------------------------------------------------------------------------------------------"));
            doc.add(new Paragraph("Nome do cliente: " + cliente.getNome() + " " + cliente.getSobrenome()));
            doc.add(new Paragraph("Número do documento: " + cliente.getRg()));
            doc.add(new Paragraph("Data do documento: " + vendas.getDataCompra()));
            doc.add(new Paragraph("Data da emissão: " + formatador.format(data)));
            doc.add(new Paragraph("Valor total do documento: " + vendas.getValorTotal()));
            
           


        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        } finally {
            doc.close();
        }
        try {
            Desktop.getDesktop().open(new File(Boleto));
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }

    }//GEN-LAST:event_jButtonBoletoActionPerformed

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
    private javax.swing.JButton jButtonBoleto;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelIDVenda;
    private javax.swing.JLabel jLabelIDVenda1;
    private javax.swing.JTextField jTextFieldIDVenda;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
