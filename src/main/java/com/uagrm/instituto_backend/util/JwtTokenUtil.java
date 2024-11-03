package com.uagrm.instituto_backend.util;

import com.uagrm.instituto_backend.entities.Usuario;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    private final String secretString = "tu_clave_secreta_muy_segura_que_debe_ser_larga_para_mayor_seguridad";
    private final Key secretKey = Keys.hmacShaKeyFor(secretString.getBytes());
    private final long jwtExpirationMs = 86400000; // 24 horas

    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.username)
                .claim("roles", usuario.roles.stream()
                        .map(rol -> rol.nombre)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            logger.error("Token inválido: {}", e.getMessage());
        }
        return false;
    }
}
