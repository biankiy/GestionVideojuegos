package egg.GestionVideojuegos.service;

import egg.GestionVideojuegos.entidades.Empleado;
import java.util.List;

public interface EmpleadoService {
    
    //CRUD (create , read, update, delete)
    
    //lista de objetos de tipo empleado
    public List<Empleado> listaEmpleados();
    
    //metodo para guardar empleado
    public void guardar(Empleado empleado);
    
    //metodo para eliminar empleado
    public void eliminar(Empleado empleado);
    
    //metodo buscar empleado
    public Empleado encontrarEmpleado(Empleado empleado);
}
