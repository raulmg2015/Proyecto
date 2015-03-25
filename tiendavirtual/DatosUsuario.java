/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tiendavirtual;

/**
 *
 * @author "Alfonso Armas (armasalfonsot@gmail.com)"
 */
public class DatosUsuario {
    private int idUsuario;
    private String Nombre;
    private String Apellido;
    private String telefono;
    private String email;
    private String password;

    
    private static final DatosUsuario oDatosUsuario = new DatosUsuario();

    private DatosUsuario() {
       System.out.println("Se ha creado el objeto datosusario");
    }
    
    public static DatosUsuario getDatosUsuario(){
        return oDatosUsuario;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

}
