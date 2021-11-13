/*
 Aqui invocaremos los metodos de consulta 
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;


public class TestManejpPersona {
    
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO(); //Creacion de objeto de personaDAO                
        //Creacion de objeto con constructor
        //Persona personaNueva = new Persona ("Claudette","Cruz",22);
        //Inserccion de objeto al metodo
        //personaDao.insertar(personaNueva);
        
    //Actualizar un registro
    Persona personaEditada = new Persona (7,"Montse","Cruz",22);
    personaDao.actualizar(personaEditada);
    
    //Eliminar Registro
    Persona personaEliminada = new Persona(4);
    personaDao.eliminar(personaEliminada);
    
    List<Persona> personas = personaDao.seleccionar();
    //Iteramos nuestra lista
    for(Persona persona: personas){//Importante agreguar el public static void main!!
            System.out.println("persona : "+persona);
    }
    }
    
    
    
    
}
