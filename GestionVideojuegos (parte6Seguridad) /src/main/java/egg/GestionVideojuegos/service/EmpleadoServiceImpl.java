package egg.GestionVideojuegos.service;
import egg.GestionVideojuegos.dao.EmpleadoDao;
import egg.GestionVideojuegos.entidades.Empleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service                         //crea automaticamente todos los metodos que estan en la interface empleadoService 
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired //ahora utiliza el empleado service
    private EmpleadoDao empleadoDao; //conecta nuestra capa de servicio(Empleado service) con nuestra capa de datos(empleadoServiceImpl)
    
    //@Transacctional , trabaja con la base de datos en el caso de error va hacer un roolback , en el caso de que salga todo bien un commit
    
    @Override
    @Transactional(readOnly = true)//solo lectura , no es necesario hacer commit o roollback
    public List<Empleado> listaEmpleados() {
    // return empleadoDao.findAll(); [antes del casteo]   
       return (List<Empleado>) empleadoDao.findAll(); //[despues del casteo]]findall recupera todos los objetos de tipo empleado, como regresa un tipo object tenemos que castearlo
    }

    @Override
    @Transactional
    public void guardar(Empleado empleado) {
        empleadoDao.save(empleado);//se guarda en nuestra base de datos
    }

    @Override
    @Transactional
    public void eliminar(Empleado empleado) {
        empleadoDao.delete(empleado);//llamamos al metodo delete y le pasamos el objeto empleado
    }

    @Override
    @Transactional(readOnly = true)//solo va a consultar informacion
    public Empleado encontrarEmpleado(Empleado empleado) {
        //recuperar un objeto del tipo persona con el id del Empleado
        return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
        //en el caso que no encuentre , va a regresar null .Esto hace que el programa no deje de funcionar.
    }
    
    
}
