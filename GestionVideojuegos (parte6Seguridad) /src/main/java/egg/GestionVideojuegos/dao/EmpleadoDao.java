package egg.GestionVideojuegos.dao;

import egg.GestionVideojuegos.entidades.Empleado;
import org.springframework.data.repository.CrudRepository;

//al usar interface podemos utilizar crud repository 
// le pasamos el tipo y el tipo de llave primaria 

public interface EmpleadoDao extends CrudRepository<Empleado, Long>{
    
}
