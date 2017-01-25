package ControleBoleto;

import ControleCliente.Cliente;
import ControleDeVendas.Parcela;
import ControleDeVendas.Vendas;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GeradorBoleto {

    private static final String url = "jdbc:mysql://projetovendas.no-ip.org:3306/Vendas?zeroDateTimeBehavior=convertToNull";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String login = "Sistema";
    private static final String pwd = "sistema975";

    public void main(Cliente c, Vendas v) throws JRException, SQLException, ClassNotFoundException {
        Cliente cliente;
        cliente = c;
        Vendas vendas;
        vendas = v;

        List lista = new ArrayList();

        c.getNome();
        c.getEndereco();

        lista.add(c);
        lista.add(v);

        JasperReport report = JasperCompileManager.compileReport("boleto.jasper");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
        JasperExportManager.exportReportToPdfFile(print, "C:\\Windows\\Temp\\boleto.pdf");
    }
}
