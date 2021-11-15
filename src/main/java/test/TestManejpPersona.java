/*
 Aqui invocaremos los metodos de consulta 
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;
import java.util.Scanner;


public class TestManejpPersona {
    
    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    }  
    
    public static void main(String[] args) {
        
        PersonaDAO personaDao = new PersonaDAO(); //Creacion de objeto de personaDAO                
        List<Persona> personas = personaDao.seleccionar();//Listado de Personas
        //Inserccion para poder ingresar datos
        Scanner leer = new Scanner(System.in);
        //Bandera
        String res;
        int opt=0;
        
        System.out.println("Opciones");
        System.out.println("1 - Insertar Registro");
        System.out.println("2 - Eliminar Registro");
        System.out.println("3 - Actualizar registro");
        System.out.println("4 - Mostrar todos los registros");        
        System.out.println("5 - S a l i r");



        System.out.println("¿ Que deseas hacer ? ");
        opt=Integer.parseInt(leer.nextLine());      
        
        
        switch(opt)
        {
            case 1:
              do{
                  
                        //INSERCCION DE REGISTROS
                
                System.out.println("Nombre  : ");
                    String nombre=leer.nextLine();
                System.out.println("Apellido  : ");
                    String apellido=leer.nextLine();
                System.out.println("Edad : ");
                    int edad=Integer.parseInt(leer.nextLine());

                //Creacion de objeto con constructor
                Persona personaNueva = new Persona (nombre,apellido,edad);
                //Inserccion de objeto al metodo
                personaDao.insertar(personaNueva);        

                System.out.println("Deseas realizar otra inserccion (y/n) : ");
                res=leer.nextLine();                

                }while(!res.equals("n"));
              
              List<Persona> personas1 = personaDao.seleccionar();//Creamos objeto
              for(Persona persona: personas1){//Importante agreguar el public static void main!!
                    System.out.println("persona : "+persona);
                }              
            break;
            
            case 2:
                
                        //ELIMNAR UN REGISTRO
                
                for(Persona persona: personas){//Importante agreguar el public static void main!!
                System.out.println("persona : "+persona);
                    }
                
                System.out.println(" ¿ Que registro deseas eliminar ? _ ");
                int reg=Integer.parseInt(leer.nextLine());
                
                try{
                
                //Eliminar Registro
                Persona personaEliminada = new Persona(reg);
                personaDao.eliminar(personaEliminada);                              
                //Limpia pantalla
                //clearScreen();
                
                    System.out.println("1 Registro eliminado");
                
            List<Persona> personasQuery = personaDao.seleccionar();//Listado de Personas
            //Vueleve a recorrer a personas ; Con funcion lambda
            personasQuery.forEach(persona -> {
                //Importante agreguar el public static void main!!
                System.out.println("persona : "+persona);
            });
                    
                
                }catch(Exception ex){
                    ex.printStackTrace(System.out);
                }              
                
            break;
            
            case 3:                
                
                List<Persona> personasToUpdate = personaDao.seleccionar();//Listado de Personas
                personasToUpdate.forEach(persona->{
                    System.out.println(" Persona : "+persona );   
                }                
                );
                            //Actualizar un registro
                System.out.println("Registro a editar : ");
                reg=Integer.parseInt(leer.nextLine());
                
                System.out.println("     Registro : "+reg);
                System.out.println(" Nombre : ");
                String nombre = leer.nextLine();
                System.out.println(" Apellido : ");
                String apellido = leer.nextLine();
                System.out.println(" Edad : ");
                int edad = Integer.parseInt(leer.nextLine());                
                
                try{
                
                //Metodo para actualizar
                Persona personaEditada = new Persona (reg,nombre,apellido,edad);
                personaDao.actualizar(personaEditada);
                
                System.out.println("Registro Actualizado ! ");
                
                List<Persona> personasActualizadas = personaDao.seleccionar();//Listado de Personas
                personasActualizadas.forEach(persona->{
                    System.out.println("Persona : "+persona);
                });
                
                }catch(Exception ex){
                    
                        ex.printStackTrace(System.out);
                
                }
                
            break;
            case 4:
                
                    //MOSTRAR TODOS LOS REGISTROS
                
                for(Persona persona: personas){//Importante agreguar el public static void main!!
                System.out.println("persona : "+persona);
                    }
                
            break;    
            default:
                System.out.println("Opcion no disponible");
            break;
        }
        
        
        
        //Creacion de objeto con constructor
        //Persona personaNueva = new Persona ("Claudette","Cruz",22);
        //Inserccion de objeto al metodo
        //personaDao.insertar(personaNueva);
        
    //Actualizar un registro
    //Persona personaEditada = new Persona (7,"Montse","Cruz",22);
    //personaDao.actualizar(personaEditada);
    
    //Eliminar Registro
    //Persona personaEliminada = new Persona(4);
    //personaDao.eliminar(personaEliminada);
    
    
    //Iteramos nuestra lista
    //for(Persona persona: personas){//Importante agreguar el public static void main!!
      //      System.out.println("persona : "+persona);
    //}
    }
    
    
    
    
}
