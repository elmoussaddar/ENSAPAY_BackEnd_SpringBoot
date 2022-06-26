package com.example.ensapay.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthorizationFilter extends OncePerRequestFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String jwtToken=request.getHeader(SecurityConstants.HEADER_STRING);
        if(jwtToken==null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }


        Claims claims= Jwts.parser()
                //signer avec le secret
                .setSigningKey(SecurityConstants.SECRET)

                //supprimer le prefix
                .parseClaimsJws(jwtToken.replace(SecurityConstants.TOKEN_PREFIX,""))
                // recuperer le token
                .getBody();
        //recuperer le username
        String username=claims.getSubject();


        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(username, null,new ArrayList<>());


        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);

    }


}



