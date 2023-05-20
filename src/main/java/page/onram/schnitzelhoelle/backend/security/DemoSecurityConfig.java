package page.onram.schnitzelhoelle.backend.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class DemoSecurityConfig {

    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {

    //     UserDetails john = User.builder().username("john").password("{noop}tiger").roles("USER").build();
    //     UserDetails mary = User.builder().username("mary").password("{noop}tiger").roles("USER", "MANAGER").build();
    //     UserDetails susanne = User.builder().username("susanne").password("{noop}tiger")
    //             .roles("USER", "MANAGER", "ADMIN").build();

    //     return new InMemoryUserDetailsManager(john, mary, susanne);

    // }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> configurer

                // schnitzel
                .requestMatchers(HttpMethod.GET, "api/schnitzels").permitAll()
                .requestMatchers(HttpMethod.GET, "api/schnitzels/**").permitAll()
                .requestMatchers(HttpMethod.POST, "api/schnitzels/**").hasRole("USER")
                .requestMatchers(HttpMethod.PUT, "api/schnitzels/**").hasRole("USER")
                .requestMatchers(HttpMethod.DELETE, "api/schnitzels/**").hasRole("USER")

                // // restaurant
                .requestMatchers(HttpMethod.GET, "api/restaurants").permitAll()
                .requestMatchers(HttpMethod.GET, "api/restaurants/**").permitAll()
                .requestMatchers(HttpMethod.POST, "api/restaurants/**").hasRole("USER")
                .requestMatchers(HttpMethod.PUT, "api/restaurants/**").hasRole("USER")
                .requestMatchers(HttpMethod.DELETE, "api/restaurants/**").hasRole("USER")

                // debug
                .requestMatchers(HttpMethod.GET, "debugUser").hasAnyRole("USER")


        // end
        );

        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
