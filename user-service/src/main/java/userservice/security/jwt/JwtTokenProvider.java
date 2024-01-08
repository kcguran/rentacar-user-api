package userservice.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;


    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
//            LOGGER.error("JwtUtils | validateJwtToken | Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
//            LOGGER.error("JwtUtils | validateJwtToken | JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
//            LOGGER.error("JwtUtils | validateJwtToken | JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
//            LOGGER.error("JwtUtils | validateJwtToken | JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
