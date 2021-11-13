package domain;


public class Persona {
    
    private int ID;
    private String Nombre;
    private String Apellido;
    private int Edad;
    
    //Constructor
    public Persona(){
        
    }
    
    //Sobrecarga de constructor
    
    //Por si se consulta por id
    public Persona(int _ID){
        this.ID = _ID;
    }

    //Para inserccion de registro
    public Persona(String Nombre, String Apellido, int Edad) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
    }

    //Para editar un registro
    public Persona(int ID, String Nombre, String Apellido, int Edad) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
    }

    //Si queremos actualizas un atributo individual del registro
    //Metodos getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    
    //Metodo para concer el estado del objeto, registro
    @Override
    public String toString() {
        return "Persona{" + "ID=" + ID + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Edad=" + Edad + '}';
    }
    
    /*
    DAO - Data Access Object ; Patron de diseño
    Asi se le conocela clase que realiza las operaciones con 
    una entidad de la base de datos ; Create, Read, Update y Delete.
       */
    
       
}
