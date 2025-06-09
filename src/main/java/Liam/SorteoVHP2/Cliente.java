package Liam.SorteoVHP2;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "Clientedate")
public class Cliente {

    @Id
    private String id;

    @NotBlank
    private String nombre;

    @NotBlank
    @Email
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    
    private String telefono;

    @NotBlank
    private String dni;
    
    

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
}