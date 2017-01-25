package ControleNotaFiscal;

import ControleCliente.Cliente;
import ControleDeVendas.Vendas;
import GerenciamentoDeFuncionarios.Funcionario;
import Relatorios.util.ReportUtils;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
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
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class ControleNotaFiscal {
        InputStream inputStream = getClass().getResourceAsStream( "/ControleNotaFiscal/notaFiscal.jasper" );

        Map<String, Object> parametros = new HashMap<String, Object>();
//
//    private static final String url = "jdbc:mysql://projetovendas.no-ip.org:3306/Vendas?zeroDateTimeBehavior=convertToNull";
//    private static final String driver = "com.mysql.jdbc.Driver";
//    private static final String login = "Sistema";
//    private static final String pwd = "sistema975";

    public ControleNotaFiscal(Cliente c, Funcionario f, Vendas v) throws JRException, SQLException, ClassNotFoundException{
        String CodigoVenda;

        
        Cliente cliente;
        cliente = c;
        Funcionario funcionario;
        funcionario = f;
        Vendas venda;
        venda = v;
        CodigoVenda = v.getVendaId();
        List<Cliente> dados = new ArrayList<Cliente>();
        c.getCliId();
        c.getRg();
        c.getEndereco();
        c.getComplemento();
        c.getCidade();
        c.getEstado();
        c.getTelFixo();
        f.getIdFunc();
        f.getNome();
        v.getVendaId();
        dados.add(c);
//        dados.add(f);
//        dados.add(v);

        System.out.println(dados);
        
        System.out.println(v.getVendaId()+"\n");
        JRDataSource ds = new JRBeanCollectionDataSource( dados );
        try {

            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport( "Clientes - Bean Collection Data Source", inputStream, parametros,
                    ds );

        } catch ( JRException exc ) {
            exc.printStackTrace();
        }

    }

//        InputStream inputStream = getClass().getResourceAsStream( "/ControleNotaFiscal/notaFiscal.jasper" );
//        Map parametros = new HashMap();
//        parametros.put( "cli_ID", c.getCliId());
//        System.out.print("\nentrou\n");
//        //JRViewer viewer = new JRViewer( lista );
//        
//        
//        
//        
//        JRDataSource ds = new JRBeanCollectionDataSource( lista );
//        System.out.println("Relatorio gerado");
//        JasperReport report = JasperCompileManager.compileReport("/ControleNotaFiscal/nostaFiscal.jrxml");
//        JasperPrint print = JasperFillManager.fillReport(report, null,new JRBeanCollectionDataSource(lista));
//        JasperExportManager.exportReportToPdfFile(print,"‪D:\\Users\\ander\\Desktop\\boleto.pdf");
//        JasperExportManager.exportReportToPdfFile(print,"NotaFiscal.pdf");
//        JasperExportManager.exportReportToPdfFile(print,"C:\\Windows\\Temp\\boleto.pdf");
//        System.out.println("Relatório gerado.");
//
//            JasperReport report = JasperCompileManager.compileReport("src/ControleNotaFiscal/notaFiscal.jrxml");
//            System.out.println("1\n");
//            JasperPrint print = JasperFillManager.fillReport(report, null,new JRBeanCollectionDataSource(lista));
//            System.out.println("Entrou 2\n");
//            JasperExportManager.exportReportToPdfFile(print,"src/ControlaNotaFiscal/RelatorioClientes.pdf");
//            System.out.println("Entrou 3\n");
//            System.out.println("Relatório gerado.");
//    }
}
