package cs489.lab.ads.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {
    private JwtUtil jwtUtil;
    @BeforeEach
    void setup(){
        jwtUtil = new JwtUtil();
    }

    @Test
    void generateToken() {
        //for test123
        String email = "test@example.com";
        Authentication auth = new UsernamePasswordAuthenticationToken(email, "123", new ArrayList<>());
        String token = jwtUtil.generateToken(auth);
        String emailFromToken = jwtUtil.extractUsername(token);
        assertEquals(email, emailFromToken);
    }
    @Test
    void validateToken(){
        String email = "test@example.com";
        Authentication auth = new UsernamePasswordAuthenticationToken(email, "123", new ArrayList<>());
        String token = jwtUtil.generateToken(auth);
        UserDetails user = new User(email, "123", new ArrayList<>());
        Boolean valid = jwtUtil.validateToken(token, user);
        assertEquals(true, valid);
    }

}