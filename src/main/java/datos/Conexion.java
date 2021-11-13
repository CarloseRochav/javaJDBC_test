package datos;

import java.sql.*;

public class Conexion {
    
    //Declarar una constante privada con la cadena de conexion
    private static final String conexionSql = "jdbc:sqlserver://localhost:1434;"
                + "databaseName=JDBC_Ejercicio;"
                + "user=superCollider;password=Tlaltecuhtli1489";
    
    
    //Metodo para obetener la conexion con excepciones
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(conexionSql);
    }
    
    //Ahora quedar cerrar las conexiones - >>
    
    //Metodos sobrecargados
    public static void close(ResultSet result) throws SQLException{
        result.close();
        
    }
    
    public static void close(Statement smt) throws SQLException{
        smt.close();
    }
    
    public static void close(PreparedStatement smt) throws SQLException{
        smt.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
