package cs489.lab.ads.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    void generateValidateToken() {
        //for test123
        String email = "test@example.com";
        Authentication auth = new UsernamePasswordAuthenticationToken(email, "123", new ArrayList<>());
        String token = jwtUtil.generateToken(auth);
        String emailFromToken = jwtUtil.extractUsername(token);
        assertEquals(email, emailFromToken);
        assertEquals(1, 0);
    }
}