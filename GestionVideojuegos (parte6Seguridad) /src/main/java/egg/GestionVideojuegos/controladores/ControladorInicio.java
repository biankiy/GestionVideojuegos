package egg.GestionVideojuegos.controladores;

import egg.GestionVideojuegos.entidades.Empleado;
import egg.GestionVideojuegos.service.EmpleadoService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //utiligar log para mensajes en la consola
public class ControladorInicio {
    
    @Autowired //inyectamos el empleadoService y los metodos del crud
    private EmpleadoService empleadoService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var empleados = empleadoService.listaEmpleados();
        
        log.info("Equipo 6"); //"sfl4j
        model.addAttribute("empleados", empleados);
        return("index");
    }
    
    @GetMapping("/agregar")
    public String agregar(Empleado empleado){//no necesitamos utilizar el el operador new, spring lo hace de manera automaica
        return "modificar"; //va a realizar ambas funciones
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Empleado empleado, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        empleadoService.guardar(empleado);
        return"redirect:/";
    }
    
    @GetMapping("/editar/{idEmpleado}")
    public String editar(Empleado empleado, Model model){
       empleado = empleadoService.encontrarEmpleado(empleado);
       model.addAttribute("empleado", empleado);
       return "modificar";
    }
    
    @GetMapping("/eliminar/{idEmpleado}")
    public String eliminar(Empleado empleado){
        empleadoService.eliminar(empleado);
        return "redirect:/"; 
    }
}
