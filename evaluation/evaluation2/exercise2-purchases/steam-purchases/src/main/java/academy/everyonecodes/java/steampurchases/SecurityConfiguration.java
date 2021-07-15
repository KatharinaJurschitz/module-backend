package academy.everyonecodes.java.steampurchases;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpMethod.GET;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ConfigurationProperties("steam")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private List<User> steamUsers;

    public SecurityConfiguration(List<User> steamUsers) {
        this.steamUsers = steamUsers;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(GET, "/games").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> users = steamUsers.stream()
                .map(steamUser -> createUserDetails(encoder, steamUser))
                .collect(toList());
        return new InMemoryUserDetailsManager(users);
    }

    private UserDetails createUserDetails(PasswordEncoder encoder, User steamUser) {
        return org.springframework.security.core.userdetails.User.withUsername(steamUser.getUsername())
                .password(encoder.encode(steamUser.getPassword()))
                .authorities(steamUser.getAuthorities())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
