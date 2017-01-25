/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import ControleCliente.Cliente;
import ControleDeVendas.ControlaProdVenda;
import ControleDeVendas.Parcela;
import ControleDeVendas.ProdVenda;
import ControleDeVendas.Vendas;
import ControleProduto.ControlaProduto;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;

/**
 *
 * @author ander
 */
public class Boleto {
    
    public Boleto(Cliente c, Vendas v) throws BadElementException{
        Cliente cliente;
        cliente = c;
        Vendas vendas;
        vendas = v;
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Document doc = new Document();
        String Boleto = cliente.getCliId() + vendas.getVendaId() + ".pdf";
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(Boleto));
            doc.open();
            Image figura = Image.getInstance("D:\\Users\\ander\\Desktop\\git\\VendaMoveis\\src\\ControleBoleto\\LogoBanco.png");
            doc.add(figura);
            doc.add(new Paragraph("RedeBras                                  Rua Vinte e Dois Mil E Dois,519. Zona 47. Maringá - PR"));
        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            Logger.getLogger(Boleto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            doc.close();
        }
        try {
            Desktop.getDesktop().open(new File(Boleto));
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
