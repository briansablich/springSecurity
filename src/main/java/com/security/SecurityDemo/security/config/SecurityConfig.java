
package com.security.SecurityDemo.security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Recomendado deshabilitar para pruebas iniciales
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/holanoseg").permitAll(); // URL pública
                    auth.anyRequest().authenticated();             // Todo lo demás requiere login
                })
                .formLogin(form -> form.permitAll()) // Habilita el formulario de login visual
                .httpBasic(basic -> Customizer.withDefaults())
                .build();
    }
}
