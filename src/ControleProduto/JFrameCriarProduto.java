package ControleProduto;

import javax.swing.JOptionPane;
import GeradorDeId.GeraId;

/**
 *
 * @author Anderson Sergio Oyama
 */
public class JFrameCriarProduto extends javax.swing.JFrame {
    GeraId geraid = new GeraId();
    int idProduto;
    Produto produto;
    
    public JFrameCriarProduto(Produto det) {
        initComponents();
        produto = det;
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        idProduto = geraid.GeraChave(1);
        JTextIDProduto.setText(Integer.toString(idProduto)); 
        System.out.println("Entrou: " + idProduto);
    }

    private JFrameCriarProduto() {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        JLabelFotoProduto = new javax.swing.JLabel();
        JLabelNomeProduto = new javax.swing.JLabel();
        JTextNomeProduto = new javax.swing.JTextField();
        JLabelIDProduto = new javax.swing.JLabel();
        JTextIDProduto = new javax.swing.JTextField();
        JLabelDescrição = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaDescriçãoProduto = new javax.swing.JTextArea();
        JButtonSalvarProd = new javax.swing.JButton();
        JButtonCancelarProd = new javax.swing.JButton();
        JLabelPreçoCompra = new javax.swing.JLabel();
        JTextPreçoCompra = new javax.swing.JTextField();
        JLabelPreçoVenda = new javax.swing.JLabel();
        JTextPreçoVenda = new javax.swing.JTextField();
        JLabelMarca = new javax.swing.JLabel();
        JPanelDimensao = new javax.swing.JPanel();
        JLabeLargura = new javax.swing.JLabel();
        JTextLargura = new javax.swing.JTextField();
        JLabeAltura = new javax.swing.JLabel();
        JTextAltura = new javax.swing.JTextField();
        JTextProfundidade = new javax.swing.JTextField();
        JLabeProfundidade = new javax.swing.JLabel();
        JTextMarca = new javax.swing.JTextField();
        JLabelQuantidade = new javax.swing.JLabel();
        JTextQuantidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        jPanel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        JLabelFotoProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelFotoProduto.setText("Inserir Foto");
        JLabelFotoProduto.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagem X-1/X"));
        JLabelFotoProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelFotoProdutoMouseClicked(evt);
            }
        });

        JLabelNomeProduto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabelNomeProduto.setText("Nome do Produto:");

        JTextNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextNomeProdutoActionPerformed(evt);
            }
        });

        JLabelIDProduto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabelIDProduto.setText("ID do Produto:");

        JTextIDProduto.setEditable(false);

        JLabelDescrição.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabelDescrição.setText("Descrição do Produto:");

        jTextAreaDescriçãoProduto.setColumns(20);
        jTextAreaDescriçãoProduto.setRows(5);
        jScrollPane4.setViewportView(jTextAreaDescriçãoProduto);

        JButtonSalvarProd.setText("Salvar");
        JButtonSalvarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonSalvarProdActionPerformed(evt);
            }
        });

        JButtonCancelarProd.setText("Cancelar");
        JButtonCancelarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCancelarProdActionPerformed(evt);
            }
        });

        JLabelPreçoCompra.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabelPreçoCompra.setText("Preço de Compra:");

        JLabelPreçoVenda.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabelPreçoVenda.setText("Preço de Venda:");

        JLabelMarca.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabelMarca.setText("Marca:");

        JPanelDimensao.setBorder(javax.swing.BorderFactory.createTitledBorder("Dimensão do Produto:"));

        JLabeLargura.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabeLargura.setText("Largura:");

        JLabeAltura.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabeAltura.setText("Altura:");

        JLabeProfundidade.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabeProfundidade.setText("Profundidade:");

        javax.swing.GroupLayout JPanelDimensaoLayout = new javax.swing.GroupLayout(JPanelDimensao);
        JPanelDimensao.setLayout(JPanelDimensaoLayout);
        JPanelDimensaoLayout.setHorizontalGroup(
            JPanelDimensaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelDimensaoLayout.createSequentialGroup()
                .addComponent(JLabeLargura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextLargura, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLabeAltura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLabeProfundidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextProfundidade, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 186, Short.MAX_VALUE))
        );
        JPanelDimensaoLayout.setVerticalGroup(
            JPanelDimensaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelDimensaoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(JPanelDimensaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabeLargura)
                    .addComponent(JTextLargura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabeAltura)
                    .addComponent(JTextAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextProfundidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabeProfundidade)))
        );

        JTextMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextMarcaActionPerformed(evt);
            }
        });

        JLabelQuantidade.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JLabelQuantidade.setText("Quantidade:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(JLabelFotoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelNomeProduto)
                                    .addComponent(JLabelMarca))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTextNomeProduto)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(JTextMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(JLabelQuantidade)
                                        .addGap(18, 18, 18)
                                        .addComponent(JTextQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabelIDProduto)
                                    .addComponent(JLabelPreçoCompra))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTextIDProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(JTextPreçoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(JLabelPreçoVenda)
                                        .addGap(18, 18, 18)
                                        .addComponent(JTextPreçoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JPanelDimensao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(JLabelDescrição)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JButtonCancelarProd)
                        .addGap(18, 18, 18)
                        .addComponent(JButtonSalvarProd)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelNomeProduto)
                            .addComponent(JTextNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JLabelQuantidade)
                                .addComponent(JTextQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JLabelMarca)
                                .addComponent(JTextMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPanelDimensao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabelIDProduto)
                            .addComponent(JTextIDProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JLabelPreçoVenda)
                                .addComponent(JTextPreçoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JLabelPreçoCompra)
                                .addComponent(JTextPreçoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLabelFotoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)))
                .addComponent(JLabelDescrição)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonSalvarProd)
                    .addComponent(JButtonCancelarProd))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1004, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 8, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JLabelFotoProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelFotoProdutoMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_JLabelFotoProdutoMouseClicked

    private void JTextNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextNomeProdutoActionPerformed

    private void JButtonSalvarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonSalvarProdActionPerformed
        ControlaProduto controlaProduto = new ControlaProduto();

        if (JTextNomeProduto.getText().equals("")
            //|| JTextIDProduto.getText().equals("")
            || JTextPreçoCompra.getText().equals("")
            || JTextPreçoVenda.getText().equals("")
            || jTextAreaDescriçãoProduto.getText().equals("")
            || JTextAltura.getText().equals("")
            || JTextLargura.getText().equals("")
            || JTextProfundidade.getText().equals("")
            || JTextMarca.getText().equals("")
            || JTextMarca.getText().equals("")
            || JTextQuantidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Um dos campos não está preenchido!");
        } else {
            try {
                //Produto produto = new ControlaProduto().cadastraProduto(Integer.toString(idProduto), JTextNomeProduto.getText(), Integer.parseInt(JTextQuantidade.getText()), jTextAreaDescriçãoProduto.getText(), Float.parseFloat(JTextPreçoVenda.getText()), Float.parseFloat(JTextPreçoCompra.getText()), Float.parseFloat(JTextAltura.getText()) , Float.parseFloat(JTextLargura.getText()), Float.parseFloat(JTextProfundidade.getText()), JTextMarca.getText());

                JOptionPane.showMessageDialog(null, "O produto, cujo Id é : " + idProduto + " foi cadastrado com sucesso!");
                idProduto = geraid.GeraChave(1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "O produto não pode ser cadastrado devido a um erro!");
                idProduto = geraid.GeraChave(1);
            }
        }
    }//GEN-LAST:event_JButtonSalvarProdActionPerformed

    private void JButtonCancelarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCancelarProdActionPerformed
        if (JTextNomeProduto.getText() == null
            || JTextPreçoCompra.getText() == null
            || JTextPreçoVenda.getText() == null
            || jTextAreaDescriçãoProduto.getText() == null
            || JTextAltura.getText() == null
            || JTextLargura.getText() == null
            || JTextProfundidade.getText() == null
            || JTextMarca.getText() == null
            || JTextQuantidade.getText() == null) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja cancelar o cadastro do produto?");
            if (resposta == JOptionPane.YES_OPTION) {
            }
        }
    }//GEN-LAST:event_JButtonCancelarProdActionPerformed

    private void JTextMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextMarcaActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCriarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCancelarProd;
    private javax.swing.JButton JButtonSalvarProd;
    private javax.swing.JLabel JLabeAltura;
    private javax.swing.JLabel JLabeLargura;
    private javax.swing.JLabel JLabeProfundidade;
    private javax.swing.JLabel JLabelDescrição;
    private javax.swing.JLabel JLabelFotoProduto;
    private javax.swing.JLabel JLabelIDProduto;
    private javax.swing.JLabel JLabelMarca;
    private javax.swing.JLabel JLabelNomeProduto;
    private javax.swing.JLabel JLabelPreçoCompra;
    private javax.swing.JLabel JLabelPreçoVenda;
    private javax.swing.JLabel JLabelQuantidade;
    private javax.swing.JPanel JPanelDimensao;
    private javax.swing.JTextField JTextAltura;
    private javax.swing.JTextField JTextIDProduto;
    private javax.swing.JTextField JTextLargura;
    private javax.swing.JTextField JTextMarca;
    private javax.swing.JTextField JTextNomeProduto;
    private javax.swing.JTextField JTextPreçoCompra;
    private javax.swing.JTextField JTextPreçoVenda;
    private javax.swing.JTextField JTextProfundidade;
    private javax.swing.JTextField JTextQuantidade;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaDescriçãoProduto;
    // End of variables declaration//GEN-END:variables
}
