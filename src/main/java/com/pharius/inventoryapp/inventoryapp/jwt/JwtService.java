package com.pharius.inventoryapp.inventoryapp.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
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

    @SuppressWarnings("deprecation")//hehe
    private String getToken(Map<String,Object> extraClaims, UserDetails user) {//Get token with claims
        return Jwts
            .builder()
            .claims(extraClaims)
            .subject(user.getUsername())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + 1000*60*24)) //24minutes  
            .signWith(getKey(), SignatureAlgorithm.HS256 )
            .compact();//Create the jwt string -> token
    }

    private Key getKey() { //Decoding secret key in bytes
       byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
       return Keys.hmacShaKeyFor(keyBytes);
    }

    private final SecretKey SECRET_KEY2 = (SecretKey) getKey(); //The object SecretKey returns a Byte, we can use our secret_key decoded on bytes for this


    public String getUsernameFromToken(String token) { //Getting username using Claims method
       return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) { // If the username is the same as the one in the token and it's not expired returns true else false
      final String username = getUsernameFromToken(token);
      return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token)//Get all the token object info
    {
        return Jwts
        .parser()
        .verifyWith(SECRET_KEY2)
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) //Generic method to get some util specific info of the token
    {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }


    private Date getExpiration(String token){ //Getting the expiration of the token
        return getClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token){ //Verifying if the token is expired
        return getExpiration(token).before(new Date());
    }
}
