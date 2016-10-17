/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciamentoDeFuncionarios;

import Controle.Funcionario;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 * 
 * Esse formulário é usado tanto para cadastrar novos funcionários quanto para
 * alterar o cadastro de um funcionário já existente.
 * 
 * PARA ALTERAR CADASTRO DE FUNCIONARIO: O método é chamado com o construtor que
 * aceita a entidade "Funcionario" como parâmetro, que deve assumir o valor do
 * funcionário que se deseja alterar o cadastro.
 * 
 * CRIAR NOVO CADASTRO: Construir a interface com o construtor que possui campo
 * de parâmetros nulo.
 */
public class FrameCadastroFuncionario extends javax.swing.JFrame {
    
    private Funcionario funcionario;
    
    /**
      * Construtor para criar novo cadastro
      */
        public FrameCadastroFuncionario() {
        initComponents();
        funcionario = new Funcionario();
        jButtonSalvar.setVisible(true);
        jButtonAlterarDados.setVisible(false);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.permiteAlterar(true, true);
    }
        
        public FrameCadastroFuncionario(Funcionario funcionario)
        {
            initComponents();
            this.funcionario = funcionario;
            exibeDados();
            jButtonSalvar.setVisible(true);
            jButtonAlterarDados.setVisible(false);
            this.setVisible(true);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.permiteAlterar(true, false);
        }
    
    /**
     * Função que atualiza atributo "funcionario" da classe, com base no que foi
     * introduzido nos campos jTextField
     */
    public void UpdateFuncionarioFromFields()
    {
        funcionario.setNome(jTextFieldNomeCompleto.getText());
        funcionario.setBairro(jTextFieldBairro.getText());
        funcionario.setCargo(jTextFieldCargo.getText());
        funcionario.setCep(jTextFieldCEP.getText());
        funcionario.setCidade(jTextFieldCidade.getText());
        funcionario.setComplemento(jTextFieldComplemento.getText());
        funcionario.setCpf(jTextFieldCPF.getText());
        funcionario.setIdFunc(jTextFieldCPF.getText());
        funcionario.setEndereco(jTextFieldEndereco.getText());
        funcionario.setEstado(jTextFieldEstado.getText());
        funcionario.setEstadoCivil(jTextFieldEstadoCivil.getText());
        funcionario.setNomeConjuge(jTextFieldNomeConjuge.getText());
        funcionario.setNumero(jTextFieldNumero.getText());
        funcionario.setRg(jTextFieldRG.getText());
        funcionario.setSexo(jTextFieldSexo.getText());
        funcionario.setTelefone(jTextFieldTelefone.getText());
        //TODO: DATA DE CONTRATACAO E DE NASCIMENTO PRECISAM PERSISTIR
    }
    /**
     * Método para exibir dados de funcionário existente nos campos jTextField
     */
    public void exibeDados(){
        jFormattedTextFieldDataContratacao.setText(funcionario.getDataContratacao().toString());
        jFormattedTextFieldDataNascimento.setText(funcionario.getDataNascimento().toString());
        jTextFieldBairro.setText(funcionario.getBairro());
        jTextFieldCEP.setText(funcionario.getCep());
        jTextFieldNumero.setText(funcionario.getNumero());
        jTextFieldCPF.setText(funcionario.getCpf());
        jTextFieldCargo.setText(funcionario.getCargo());
        jTextFieldCidade.setText(funcionario.getCidade());
        jTextFieldComplemento.setText(funcionario.getComplemento());
        jTextFieldEndereco.setText(funcionario.getEndereco());
        jTextFieldEstado.setText(funcionario.getEstado());
        jTextFieldEstadoCivil.setText(funcionario.getEstadoCivil());
        jTextFieldNomeCompleto.setText(funcionario.getNome());
        jTextFieldNomeConjuge.setText(funcionario.getNomeConjuge());
        jTextFieldRG.setText(funcionario.getRg());
        jTextFieldSexo.setText(funcionario.getSexo());
        jTextFieldTelefone.setText(funcionario.getTelefone());
    }
    
    /**
     * Habilita a edição dos campos jTextField para edição de um cadastro já
     * existente
     */
    public void permiteAlterar(boolean permissao, boolean all){
        jTextFieldBairro.setEditable(permissao);
        jTextFieldCEP.setEditable(permissao);
        jTextFieldNumero.setEditable(permissao);
        jTextFieldCidade.setEditable(permissao);
        jTextFieldComplemento.setEditable(permissao);
        jTextFieldEndereco.setEditable(permissao);
        jTextFieldEstado.setEditable(permissao);
        //estado civil precisa exibir a combobox
        //se casado então precisa editar conjuge
        jTextFieldNomeConjuge.setEditable(permissao);
        jTextFieldTelefone.setEditable(permissao);
        if(all)
        {
            jTextFieldNomeCompleto.setEditable(permissao);
            jTextFieldCPF.setEditable(permissao);
            jTextFieldEstadoCivil.setEditable(permissao);
            jTextFieldRG.setEditable(permissao);
            jTextFieldSexo.setEditable(permissao);
            jTextFieldCargo.setEditable(permissao);
            jFormattedTextFieldDataContratacao.setEditable(permissao);
            jFormattedTextFieldDataNascimento.setEditable(permissao);
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

        jLabelRG = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jLabelEstadoCivil = new javax.swing.JLabel();
        jLabelNomeCompleto = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldCPF = new javax.swing.JTextField();
        jLabelDataContratacao = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jTextFieldNomeCompleto = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldRG = new javax.swing.JTextField();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelDataNascimento = new javax.swing.JLabel();
        jFormattedTextFieldDataContratacao = new javax.swing.JFormattedTextField();
        jLabelCargo = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jFormattedTextFieldDataNascimento = new javax.swing.JFormattedTextField();
        jLabelNomeConjuge = new javax.swing.JLabel();
        jLabelComplemento = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelCEP = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabelCabecalho = new javax.swing.JLabel();
        jTextFieldNomeConjuge = new javax.swing.JTextField();
        jTextFieldCEP = new javax.swing.JTextField();
        jTextFieldEstado = new javax.swing.JTextField();
        jTextFieldEstadoCivil = new javax.swing.JTextField();
        jTextFieldCargo = new javax.swing.JTextField();
        jTextFieldSexo = new javax.swing.JTextField();
        jButtonAlterarDados = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelRG.setText("RG");

        jTextFieldEndereco.setEditable(false);

        jLabelEstadoCivil.setText("Estado Civil");

        jLabelNomeCompleto.setText("Nome Completo ");

        jTextFieldTelefone.setEditable(false);

        jTextFieldNumero.setEditable(false);

        jTextFieldCPF.setEditable(false);

        jLabelDataContratacao.setText("Data de Contratação");

        jTextFieldBairro.setEditable(false);

        jTextFieldComplemento.setEditable(false);
        jTextFieldComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComplementoActionPerformed(evt);
            }
        });

        jTextFieldNomeCompleto.setEditable(false);
        jTextFieldNomeCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeCompletoActionPerformed(evt);
            }
        });

        jLabelTelefone.setText("Telefone");

        jTextFieldRG.setEditable(false);

        jLabelEndereco.setText("Endereço");

        jLabelCPF.setText("CPF");

        jLabelDataNascimento.setText("Data de Nascimento");

        jFormattedTextFieldDataContratacao.setEditable(false);
        jFormattedTextFieldDataContratacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextFieldDataContratacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataContratacaoActionPerformed(evt);
            }
        });

        jLabelCargo.setText("Cargo");

        jLabelSexo.setText("Sexo");

        jFormattedTextFieldDataNascimento.setEditable(false);
        jFormattedTextFieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextFieldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataNascimentoActionPerformed(evt);
            }
        });

        jLabelNomeConjuge.setText("Nome Cônjuge");

        jLabelComplemento.setText("Complemento");

        jLabelEstado.setText("Estado");

        jLabelNumero.setText("Número");

        jLabelBairro.setText("Bairro");

        jLabelCidade.setText("Cidade");

        jLabelCEP.setText("CEP");

        jTextFieldCidade.setEditable(false);

        jLabelCabecalho.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCabecalho.setText("Consulta de Funcionário");

        jTextFieldNomeConjuge.setEditable(false);

        jTextFieldCEP.setEditable(false);

        jTextFieldEstado.setEditable(false);

        jTextFieldEstadoCivil.setEditable(false);

        jTextFieldCargo.setEditable(false);

        jTextFieldSexo.setEditable(false);

        jButtonAlterarDados.setText("Alterar Dados");
        jButtonAlterarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarDadosActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar Alterações");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCargo)
                            .addComponent(jLabelTelefone)
                            .addComponent(jLabelEstadoCivil)
                            .addComponent(jLabelCidade)
                            .addComponent(jLabelNumero)
                            .addComponent(jLabelEndereco)
                            .addComponent(jLabelCPF)
                            .addComponent(jLabelRG)
                            .addComponent(jLabelNomeCompleto))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeCompleto)
                            .addComponent(jTextFieldRG, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldCPF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldEndereco)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelDataContratacao)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextFieldDataContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelSexo)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCabecalho)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelDataNascimento)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelNomeConjuge))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelEstado)))
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelComplemento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNomeConjuge)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelBairro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelCEP)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalvar)
                        .addGap(154, 154, 154)
                        .addComponent(jButtonAlterarDados)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeCompleto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelComplemento)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCidade)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado)
                    .addComponent(jTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEstadoCivil)
                        .addComponent(jTextFieldNomeConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNomeConjuge)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefone)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDataContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDataContratacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSexo)
                    .addComponent(jLabelCargo)
                    .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterarDados)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComplementoActionPerformed

    private void jTextFieldNomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeCompletoActionPerformed

    private void jFormattedTextFieldDataContratacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataContratacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataContratacaoActionPerformed

    private void jFormattedTextFieldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataNascimentoActionPerformed

    private void jButtonAlterarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarDadosActionPerformed
        // TODO add your handling code here:
        jButtonVoltar.setText("Cancelar");
        jButtonAlterarDados.setVisible(false);
        jButtonSalvar.setVisible(true);
        permiteAlterar(true, false);
    }//GEN-LAST:event_jButtonAlterarDadosActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        UpdateFuncionarioFromFields();
        //verificar nome conjuge
        boolean persistiu = new ControlaFuncionario().persisteFuncionario(funcionario);
        if(persistiu){
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
            permiteAlterar(false, true);
            jButtonAlterarDados.setVisible(true);
            jButtonSalvar.setVisible(false);
            jButtonVoltar.setText("Voltar");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao salvar alterações!");
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarDados;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataContratacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataNascimento;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCabecalho;
    private javax.swing.JLabel jLabelCargo;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelDataContratacao;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelEstadoCivil;
    private javax.swing.JLabel jLabelNomeCompleto;
    private javax.swing.JLabel jLabelNomeConjuge;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRG;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCEP;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldEstadoCivil;
    private javax.swing.JTextField jTextFieldNomeCompleto;
    private javax.swing.JTextField jTextFieldNomeConjuge;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldRG;
    private javax.swing.JTextField jTextFieldSexo;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
