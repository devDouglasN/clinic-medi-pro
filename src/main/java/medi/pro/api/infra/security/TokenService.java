package medi.pro.api.infra.security;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import medi.pro.api.domain.usuario.Usuario;

@Service
public class TokenService {
	
	public String gerarToken(Usuario usuario) {
		try {
		    var algoritimo = Algorithm.HMAC256("123456");
		    return JWT.create()
		        .withIssuer("API Medi.pro")
		        .withSubject(usuario.getLogin())
		        .withExpiresAt(dataExpiracao())
		        .sign(algoritimo);
		} catch (JWTCreationException exception){
			throw new RuntimeException("erro ao gerar token jwt", exception);
		}
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
		
}
