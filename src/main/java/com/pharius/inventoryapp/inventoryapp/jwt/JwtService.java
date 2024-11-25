package com.pharius.inventoryapp.inventoryapp.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;




@Service
public class JwtService {
   
    private final static Dotenv dotenv = Dotenv.load();
    
    
    private static final String SECRET_KEY = (dotenv.get("SECRET_KEY"));
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }

    @SuppressWarnings("deprecation")
    private String getToken(Map<String,Object> extraClaims, UserDetails user) {
        return Jwts
            .builder()
            .claims(extraClaims)
            .subject(user.getUsername())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + 1000*60*24))
            .signWith(getKey(), SignatureAlgorithm.HS256 )
            .compact();
    }

    private Key getKey() {
       byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
       return Keys.hmacShaKeyFor(keyBytes);
    }


}
