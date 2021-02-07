package com.hp2020g3.venidemary.service;

import com.hp2020g3.venidemary.dto.AuthDto;
import com.hp2020g3.venidemary.model.Role;
import com.hp2020g3.venidemary.model.Usuario;
import com.hp2020g3.venidemary.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


    private String getJWTToken(Integer id, String username, Role role, Date expiration) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(role.getName());

		String token = Jwts
				.builder()
				.setId(id.toString())
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

//	public static String generateToken(Authentication authentication) {
//		// Genera el token con roles, issuer, fecha, expiración (8h)
//		final String authorities = authentication.getAuthorities().stream()
//				.map(GrantedAuthority::getAuthority)
//				.collect(Collectors.joining(","));
//		return Jwts.builder()
//				.setSubject(authentication.getName())
//				.claim("authorities", authorities)
//				.signWith(SignatureAlgorithm.HS256, "mySecretKey")
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setIssuer("Bearer ")
//				.setExpiration(new Date(System.currentTimeMillis() + 600*1000))
//				.compact();
//	}

//	public AuthDto auth(String username, String password) {
//
//		Optional<Usuario> result = usuarioRepository.findByNombre(username);
//
//		if (result.isPresent()) {
//			Usuario user = result.get();
//			if (!this.passwordEncoder.matches(password, user.getPassword())) {
//				return null;
//			}
//			Date expiration = new Date(System.currentTimeMillis() + 600000);
//
//			AuthDto dto = new AuthDto(
//					user.getId(),
//					user.getNombre(),
//					getJWTToken(user.getId(), user.getNombre(), user.getRole(), expiration),
//					expiration
//			);
//
//			return dto;
//		} else {
//			return null;
//		}
//
//	}
}
