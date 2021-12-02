package egg.GestionVideojuegos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data //con esto no agregamos getter ni setters ,toString ,constructores ,equals..
@Entity// con esto lo convertimos en una clase entidad(jpa)
@Table(name = "empleado") //nombre de la tabla en la base de datos
public class Empleado implements Serializable{
    
    private static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generar los ids
    private Long idEmpleado;
    
    @NotEmpty //no puede ser valor null
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email
    private String email;
    
    private String telefono;
}
