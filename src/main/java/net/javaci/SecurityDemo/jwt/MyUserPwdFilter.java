package net.javaci.SecurityDemo.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class MyUserPwdFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SECRET_JWT_KEY = "verysecretkeyverysecretkeyverysecretkeyverysecretkeyverysecretkey";

    private final AuthenticationManager authenticationManager;

    @Autowired
    public MyUserPwdFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserPwdRequest userPwdRequest = new ObjectMapper().readValue(request.getInputStream(), UserPwdRequest.class);
            Authentication auth = new UsernamePasswordAuthenticationToken(userPwdRequest.getUsername(), userPwdRequest.getPassword());
            return authenticationManager.authenticate(auth);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain
            , Authentication authResult) throws IOException, ServletException {
        Date twoWeekLater = Date.from(LocalDateTime.now().plusDays(14).atZone(ZoneId.systemDefault()).toInstant());
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(twoWeekLater)
                .signWith(Keys.hmacShaKeyFor(SECRET_JWT_KEY.getBytes(StandardCharsets.UTF_8)))
                .compact();
        response.addHeader("Authorization", "Bearer " + token);

    }
}
