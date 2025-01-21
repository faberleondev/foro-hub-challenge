package com.ejemplo.forohub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ejemplo.forohub.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${jwt.secret.key}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("foro hub")
                    .withSubject(usuario.getNombre())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);

        } catch (JWTCreationException exception){
            throw new RuntimeException(exception);
        }
    }

    public String getSubject(String token){
        if(token == null){
            throw new RuntimeException();
        }
        DecodedJWT decodedJWT = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            decodedJWT = JWT.require(algorithm)
                    .withIssuer("foro hub")
                    .build()
                    .verify(token);
            decodedJWT.getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException(exception);
        }
        if (decodedJWT.getSubject() == null){
            throw new RuntimeException("Verifer invalido");
        }
        return decodedJWT.getSubject();
    }


    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-05:00"));
    }
}
