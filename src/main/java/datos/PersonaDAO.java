/*
 Configuramos el DAO para ejercutar las operaciones sobre la entidad Persona
 */
package datos;

import domain.Persona;//Importar la entidad para trabajar con ella
import static datos.Conexion.*; //????? Ultimo paso
import java.sql.*;
import java.util.*;

public class PersonaDAO {
    
    private static final String sql_consultar="SELECT * FROM PERSONAS"; //Cuidar bien la sintatix de sql
    private static final String sql_insertar = "INSERT INTO PERSONAS VALUES(?,?,?)";//iNSERCCION DE VALORES
    private static final String sql_actualizar="UPDATE PERSONAS SET NOMBRE =?, APELLIDO = ?, EDAD=? WHERE ID=?";
    private static final String sql_eliminar ="DELETE FROM PERSONAS WHERE ID=?";

    
    public List<Persona> seleccionar(){ //Uso de la lista para regresar objetos genericos
        Connection conn = null;
        //EL preparedStatement es mucho mas eficiente
        PreparedStatement stmt = null;
        ResultSet result = null;
        Persona persona = null;
        //List<Persona> personas = null;//Incorrecto : asi mandara error
        List<Persona> personas = new ArrayList<>();//Correcto

        
        // < - Variables a utilizar        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql_consultar);
            result = stmt.executeQuery();
            
            //Iteramos los resultados
            while(result.next()){
                //Guardamos valores en variables
                int idPersona = result.getInt("ID");
                String nombre = result.getString("NOMBRE");
                String apellido = result.getString("APELLIDO");
                int edad = result.getInt("EDAD");
                //Crear objeto con el constructor que hicimos
                persona = new Persona (idPersona,nombre,apellido,edad);
                
                //Y agremos el objeto previamente creado a nuestra lista personas
                personas.add(persona);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
        finally{
            try {
                Conexion.close(result);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }        
        //POr ultimo retornamos la lista personas
        return personas;
    }
    
    //Metodo de tipo int, ya que regresara cuantos ha sido insertados
    public int insertar(Persona persona){//Le pasaremos un objeto y no atributo por atributo
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros =0;//Inicializar en 0
        //conn = Conexion.getConnection(); //manera normal
        
        try {            
            conn = getConnection();//con importado estatico 
            stmt = conn.prepareStatement(sql_insertar);
            //Sustituir parametros de la sentencia
            stmt.setString(1, persona.getNombre());//Indicamos el primer indice y asignamos el valor del objeto
            stmt.setString(2,persona.getApellido());
            stmt.setInt(3,persona.getEdad());
            stmt.executeUpdate();//porque estamos alterando la base de datos y no haciendo una consulta
            // ; Insert, Update or Delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
                //Finalmente cerrar la conexion y statement
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
        
    }
    
      public int actualizar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros =0;//Inicializar en 0
        //conn = Conexion.getConnection(); //manera normal   
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql_actualizar);
            //Sustituir parametros de la sentencia
            stmt.setString(1, persona.getNombre());//Indicamos el primer indice y asignamos el valor del objeto
            stmt.setString(2,persona.getApellido());
            stmt.setInt(3,persona.getEdad());
            stmt.setInt(4,persona.getID());
            stmt.executeUpdate();//porque estamos alterando la base de datos y no haciendo una consulta
            // ; Insert, Update or Delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
                //Finalmente cerrar la conexion y statement
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return registros;
    }
    
    public int eliminar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros =0;//Inicializar en 0
        //conn = Conexion.getConnection(); //manera normal   
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql_eliminar);
            //Sustituir parametros de la sentencia
            stmt.setInt(1, persona.getID());//Indicamos el primer indice y asignamos el valor del objeto            
            stmt.executeUpdate();//porque estamos alterando la base de datos y no haciendo una consulta
            // ; Insert, Update or Delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stmt);
                close(conn);
                //Finalmente cerrar la conexion y statement
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return registros;
    }        
  
}
