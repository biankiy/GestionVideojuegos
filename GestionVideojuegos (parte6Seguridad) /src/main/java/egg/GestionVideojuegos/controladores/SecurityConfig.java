package egg.GestionVideojuegos.controladores;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity                  //configurar los usarios 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
   @Override //agregar nuevos usuarios
   protected void configure(AuthenticationManagerBuilder auth) throws Exception{
       auth.inMemoryAuthentication()
               .withUser("admin")
                   .password("{noop}123") //no esta incriptado
                   .roles("ADMIN","USER")
               .and()
               .withUser("user")
                    .password("{noop}123")
                    .roles("USER");
               
   }
}
