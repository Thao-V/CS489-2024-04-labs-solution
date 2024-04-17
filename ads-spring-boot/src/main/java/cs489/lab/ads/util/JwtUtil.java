package cs489.lab.ads.util;

import java.security.spec.KeySpec;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private String secretString = "CS489-2024-04-06";

    private SecretKey createSecretKey(String secretString) {
        try {
            byte[] salt = new byte[16]; // You can use a fixed salt or generate one
            KeySpec spec = new PBEKeySpec(secretString.toCharArray(), salt, 65536, 256); // 65536 iterations, 256-bit key
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] keyBytes = factory.generateSecret(spec).getEncoded();
            return Keys.hmacShaKeyFor(keyBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error generating secret key", e);
        }
    }

    public String generateToken(Authentication auth) {
        Date issuedAt = new Date();
        Date expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10); // 10 hours

        SecretKey key = createSecretKey(secretString);
        return Jwts.builder()
                .claim("email", auth.getName())
                .claim("type", "dentist")
                .issuedAt(issuedAt)
                .expiration(expiration)
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        try {
            SecretKey key = createSecretKey(secretString);
            Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
            return claims.get("email", String.class);
        } catch (JwtException e) {
            return null;
        }

    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        try {
            SecretKey key = createSecretKey(secretString);
            Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
            return claims.getExpiration().before(new Date());
        } catch (JwtException e) {
            return false;
        }

    }
}

