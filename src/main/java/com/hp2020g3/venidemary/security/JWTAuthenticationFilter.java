//package com.hp2020g3.venidemary.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.hp2020g3.venidemary.dto.AuthDto;
//import com.hp2020g3.venidemary.dto.LoginDto;
//import com.hp2020g3.venidemary.model.Usuario;
//import com.hp2020g3.venidemary.service.TokenProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import static com.hp2020g3.venidemary.utils.Constants.TOKEN_BEARER_PREFIX;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//		this.authenticationManager = authenticationManager;
//		super.setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
//	}
//
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException {
//		try {
//			LoginDto userCredentials = new ObjectMapper().readValue(request.getInputStream(), LoginDto.class);
//
//			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					userCredentials.getUsername(), userCredentials.getPassword()));
//		} catch (IOException e) {
//			return null;
//		}
//	}
//
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//			Authentication authResult) throws IOException, ServletException {
//
//		String token = TokenProvider.generateToken(authResult);
//		response.addHeader("Content-Type", "application/json");
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
//		response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
//		response.getWriter().write(new AuthDto(((AuthenticatedUser) authResult.getPrincipal()), TOKEN_BEARER_PREFIX + " " + token).toJson());
//		response.getWriter().flush();
//		response.getWriter().close();
//	}
//}
