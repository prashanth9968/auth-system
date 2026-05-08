package com.authsystem.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.authsystem.repository.UserRepository;
import com.authsystem.entity.User;
import com.authsystem.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class AuthService{
@Autowired UserRepository repo;
@Autowired OtpService otp;
@Autowired JwtUtil jwt;
BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
public String register(User u){
u.setPassword(encoder.encode(u.getPassword()));
repo.save(u);
otp.generate(u.getEmail());
return "Registered";}
public String login(String email,String password){
User u=repo.findByEmail(email).orElseThrow();
if(!encoder.matches(password,u.getPassword())) throw new RuntimeException();
otp.generate(email);
return "OTP sent";}
public String verify(String email,String code){
if(otp.verify(email,code)) return jwt.generate(email);
throw new RuntimeException();}}