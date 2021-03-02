/*
 * package br.com.petrobras.tg.faletg.security;
 * 
 * import java.io.IOException; import java.util.ArrayList; import java.util.Map;
 * 
 * import javax.management.RuntimeErrorException; import
 * javax.servlet.FilterChain; import javax.servlet.ServletException; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.security.authentication.AuthenticationManager;
 * import
 * org.springframework.security.authentication.AuthenticationServiceException;
 * import org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.AuthenticationException; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter;
 * 
 * import com.fasterxml.jackson.core.type.TypeReference; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * public class AutenticationFilter extends UsernamePasswordAuthenticationFilter
 * {
 * 
 * private AuthenticationManager authenticationManager;
 * 
 * public AutenticationFilter(AuthenticationManager authenticationManager) {
 * super(); this.authenticationManager = authenticationManager; }
 * 
 * @Override public Authentication attemptAuthentication(HttpServletRequest
 * request, HttpServletResponse response) throws AuthenticationException {
 * String username = request.getParameter("username"); String password =
 * request.getParameter("password"); System.out.println(username);
 * System.out.println(password); //username = username.trim();
 * UsernamePasswordAuthenticationToken authRequest = new
 * UsernamePasswordAuthenticationToken(username, password); // Allow subclasses
 * to set the "details" property this.setDetails(request, authRequest); return
 * authenticationManager.authenticate(authRequest); }
 * 
 * @Override protected void successfulAuthentication(HttpServletRequest request,
 * HttpServletResponse response, FilterChain chain, Authentication authResult)
 * throws IOException, ServletException { // TODO Auto-generated method stub
 * super.successfulAuthentication(request, response, chain, authResult); }
 * 
 * }
 */