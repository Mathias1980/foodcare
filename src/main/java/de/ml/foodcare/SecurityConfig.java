package de.ml.foodcare;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author mathi
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((authorize) ->
//                    authorize
//                            .requestMatchers("/register", "/css/**").permitAll()
//            ).formLogin(
//                    form -> form
//                            .loginPage("/anmeldung")
//                            .loginProcessingUrl("/anmeldung")
//                            .defaultSuccessUrl("/home")
//                            .permitAll()
//            ).logout(
//                    logout -> logout
//                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                            .permitAll()
//            ).httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .requestMatchers("/", "/register", "/anmeldung", "/css/**")
                .permitAll()
                .anyRequest()
                .authenticated()
            )
            .formLogin(
                form -> form
                    .loginPage("/anmeldung")
                    .defaultSuccessUrl("/home")
                    .permitAll()
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    
}
