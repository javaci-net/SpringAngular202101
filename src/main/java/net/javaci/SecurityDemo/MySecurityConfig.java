package net.javaci.SecurityDemo;

import net.javaci.SecurityDemo.jwt.JwtVerifierFilter;
import net.javaci.SecurityDemo.jwt.MyUserPwdFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder;

    private UserDetailsService userDetailService;

    @Autowired
    public MySecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilter(new MyUserPwdFilter(authenticationManager()))
                .addFilterAfter(new JwtVerifierFilter(), MyUserPwdFilter.class)
                .authorizeRequests()
                .anyRequest().authenticated();
    }
    protected void configureFormBased(HttpSecurity http) throws Exception {
        http
                //.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index.html", "/about.html", "/js/*", "/css/*")
                    .permitAll()
                //.antMatchers("/api/**").hasAnyRole(MyRoles.ADMIN.name())
                /*.antMatchers(HttpMethod.GET, "/api/**").hasAuthority(MyPermission.READ.getPermission())
                .antMatchers(HttpMethod.POST, "/api/**").hasAuthority(MyPermission.CREATE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(MyPermission.DELETE.getPermission())
                .antMatchers(HttpMethod.PUT, "/api/**").hasAuthority(MyPermission.UPDATE.getPermission())
                 */
                .anyRequest()
                    .authenticated()
                .and()
                //.httpBasic();
                .formLogin()
                    .loginPage("/login").permitAll()
                    .usernameParameter("kullanici")
                    .defaultSuccessUrl("/welcome", true)
                /*.and()
                .logout()
                    .logoutUrl("/cikis")
                    .logoutSuccessUrl("/login")*/;
    }

    /*@Bean
    protected UserDetailsService userDetailsService() {
        String encPassword = passwordEncoder.encode("1");
        UserDetails user = User.builder()
                .username("user")
                .password(encPassword)   //–> Actually it should be encoded!!! See the logs
                //.roles(MyRoles.USER.name()) // Spring stores like ROLE_ADMIN
                .authorities(MyRoles.USER.getAuthorities())
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(encPassword)   //–> Actually it should be encoded!!! See the logs
                //.roles(MyRoles.ADMIN.name()) // Spring stores like ROLE_ADMIN
                .authorities(MyRoles.ADMIN.getAuthorities())
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }*/

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }


}
