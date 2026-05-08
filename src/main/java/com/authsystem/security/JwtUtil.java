package com.authsystem.security;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class JwtUtil{
String SECRET="secret";
public String generate(String email){
return Jwts.builder().setSubject(email).setIssuedAt(new Date())
.setExpiration(new Date(System.currentTimeMillis()+86400000))
.signWith(SignatureAlgorithm.HS256,SECRET).compact();}}