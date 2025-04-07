//package com.example.demo.Security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.GenericFilterBean;
//
//import java.io.IOException;
//@Component
//public class JwtFilter extends GenericFilterBean {
//
//    private JwtUtil jwtUtil = new JwtUtil();
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        String authorizationHeader = httpRequest.getHeader("Authorization");
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            String token = authorizationHeader.substring(7);
//            String username = jwtUtil.extractUsername(token);
//
//            if (jwtUtil.validateToken(token, username)) {
//                System.out.println("Token is valid for user: " + username);
//            } else {
//                throw new ServletException("Invalid JWT Token");
//            }
//        }
//
//        chain.doFilter(request, response);
//    }
//}
