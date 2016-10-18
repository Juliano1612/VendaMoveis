/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciamentoDeFuncionarios;

import Controle.Funcionario;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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

    enum EstadoCivil
    {
        SOLTEIRO("Solteiro(a)"), CASADO("Casado(a)");
        
        String grafia;
        EstadoCivil(String grafia)
        {
            this.grafia = grafia;
        }
        
        String getGrafia()
        {
            return grafia;
        }
    }

    enum Sexo
    {
        MASCULINO("Masculino"), FEMININO("Feminino");
        
        String grafia;
        Sexo(String grafia)
        {
            this.grafia = grafia;
        }
        
        String getGrafia()
        {
            return grafia;
        }
    }
    
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
        ComboBoxesSetup();
    }
        
    /*
        Construtor para editar cadastro existente
    */
    public FrameCadastroFuncionario(Funcionario funcionario)
    {
        initComponents();
        this.funcionario = funcionario;
        jButtonSalvar.setVisible(true);
        jButtonAlterarDados.setVisible(false);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.permiteAlterar(true, false);
        ComboBoxesSetup();
        exibeDados();
        }
        
    /*
        Configura as ComboBoxes de Estado Civil e Sexo
    */
    public void ComboBoxesSetup()
    {
        this.jComboBoxEstadoCivil.setModel(new DefaultComboBoxModel(EstadoCivil.values()));
        this.jComboBoxEstadoCivil.setEditable(false);
        this.jComboBoxEstadoCivil.setSelectedItem(EstadoCivil.SOLTEIRO);
        this.jTextFieldNomeConjuge.setEnabled(false);
        
        this.jComboBoxSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
        this.jComboBoxSexo.setEditable(false);
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
        
        if(jComboBoxEstadoCivil.getSelectedItem().toString() == "CASADO")
        {
            funcionario.setEstadoCivil("Casado(a)");
            funcionario.setNomeConjuge(jTextFieldNomeConjuge.getText());            
        }
        else
        {
            funcionario.setEstadoCivil("Solteiro(a)");
        }
        
        if(jComboBoxSexo.getSelectedItem().toString() == "MASCULINO")
        {
            funcionario.setSexo("Masculino");
        }
        else
        {
            funcionario.setSexo("Feminino");
        }

        funcionario.setNumero(jTextFieldNumero.getText());
        funcionario.setRg(jTextFieldRG.getText());
        funcionario.setTelefone(jTextFieldTelefone.getText());
        funcionario.setDataContratacao(this.jDateContrChooser.getDate());
        funcionario.setDataNascimento(this.jDateNascChooser.getDate());
    }
    /**
     * Método para exibir dados de funcionário existente nos campos jTextField
     */
    public void exibeDados(){
        jDateContrChooser.setDate(funcionario.getDataContratacao());
        jDateNascChooser.setDate(funcionario.getDataNascimento());
        jTextFieldBairro.setText(funcionario.getBairro());
        jTextFieldCEP.setText(funcionario.getCep());
        jTextFieldNumero.setText(funcionario.getNumero());
        jTextFieldCPF.setText(funcionario.getCpf());
        jTextFieldCargo.setText(funcionario.getCargo());
        jTextFieldCidade.setText(funcionario.getCidade());
        jTextFieldComplemento.setText(funcionario.getComplemento());
        jTextFieldEndereco.setText(funcionario.getEndereco());
        jTextFieldEstado.setText(funcionario.getEstado());
        
        if(funcionario.getEstadoCivil() == "Solteiro(a)")
        {
            this.jComboBoxEstadoCivil.setSelectedItem(EstadoCivil.SOLTEIRO);
            this.jTextFieldNomeConjuge.setEnabled(false);
        }
        else
        {
            this.jComboBoxEstadoCivil.setSelectedItem(EstadoCivil.CASADO);
            this.jTextFieldNomeConjuge.setEnabled(true);
            jTextFieldNomeConjuge.setText(funcionario.getNomeConjuge());
        }
        
        jTextFieldNomeCompleto.setText(funcionario.getNome());
 
        jTextFieldRG.setText(funcionario.getRg());
        
        if(funcionario.getSexo() == "Masculino")
            this.jComboBoxSexo.setSelectedItem(Sexo.MASCULINO);
        else
            this.jComboBoxSexo.setSelectedItem(Sexo.FEMININO);
        
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
        jTextFieldNomeConjuge.setEditable(permissao);
        jTextFieldTelefone.setEditable(permissao);
        if(all)
        {
            jTextFieldNomeCompleto.setEditable(permissao);
            jTextFieldCPF.setEditable(permissao);
            jComboBoxEstadoCivil.setEditable(permissao);
            jTextFieldRG.setEditable(permissao);
            jComboBoxSexo.setEditable(permissao);
            jTextFieldCargo.setEditable(permissao);
            jDateContrChooser.setEnabled(permissao);
            jDateNascChooser.setEnabled(permissao);
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
        jLabelCargo = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
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
        jTextFieldCargo = new javax.swing.JTextField();
        jButtonAlterarDados = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jDateContrChooser = new com.toedter.calendar.JDateChooser();
        jDateNascChooser = new com.toedter.calendar.JDateChooser();
        jComboBoxEstadoCivil = new javax.swing.JComboBox<>();
        jComboBoxSexo = new javax.swing.JComboBox<>();

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

        jLabelCargo.setText("Cargo");

        jLabelSexo.setText("Sexo");

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

        jTextFieldCargo.setEditable(false);

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

        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoCivilActionPerformed(evt);
            }
        });

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateContrChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelSexo)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCabecalho)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBoxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelDataNascimento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateNascChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelEstado, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelNomeConjuge, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelEstadoCivil)
                                    .addComponent(jTextFieldNomeConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNomeConjuge)
                                    .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelTelefone)
                                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDataContratacao)))
                            .addComponent(jDateContrChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSexo)
                            .addComponent(jLabelCargo)
                            .addComponent(jLabelDataNascimento)
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateNascChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
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

    private void jComboBoxEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoCivilActionPerformed
        boolean enableconjuge;

        if(jComboBoxEstadoCivil.getSelectedItem() == EstadoCivil.CASADO)
            enableconjuge = true;
        else
            enableconjuge = false;
        
        this.jTextFieldNomeConjuge.setEnabled(enableconjuge);
    }//GEN-LAST:event_jComboBoxEstadoCivilActionPerformed

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
    private javax.swing.JComboBox<String> jComboBoxEstadoCivil;
    private javax.swing.JComboBox<String> jComboBoxSexo;
    private com.toedter.calendar.JDateChooser jDateContrChooser;
    private com.toedter.calendar.JDateChooser jDateNascChooser;
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
    private javax.swing.JTextField jTextFieldNomeCompleto;
    private javax.swing.JTextField jTextFieldNomeConjuge;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldRG;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
