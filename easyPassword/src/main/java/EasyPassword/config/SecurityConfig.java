package EasyPassword.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuración de seguridad de la aplicación EasyPassword
 */
@Configuration
@EnableWebSecurity // Habilita la seguridad web de Spring

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Desactivar CSRF (común en APIs sin estado/stateless)
            .csrf(csrf -> csrf.disable())

            // 2. Configurar reglas de acceso
            .authorizeHttpRequests(auth -> auth
                // Aquí puedes permitir acceso público a rutas específicas:
                // .requestMatchers("/public/**").permitAll() 
                .anyRequest().authenticated() 
            )

            // 3. Activar autenticación básica con sintaxis moderna (Spring Security 6+)
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
