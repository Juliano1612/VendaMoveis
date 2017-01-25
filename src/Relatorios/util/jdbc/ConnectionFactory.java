package Relatorios.util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ander
 */
public class ConnectionFactory {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }
    public static Connection getConnection(
            String url,
            String usuario,
            String senha ) throws SQLException {
        return DriverManager.getConnection( url, usuario, senha );
    }
    public static Connection getSakilaConnection() throws SQLException {

        return getConnection(
                "mysql://projetovendas.no-ip.org:3306/Vendas?zeroDateTimeBehavior=convertToNull",
                "Sistema",
                "sistema975" );
    }
}
