package com.authsystem.service;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class OtpService{
private Map<String,String> store=new HashMap<>();
public String generate(String email){
String otp=String.valueOf(new Random().nextInt(900000)+100000);
store.put(email,otp);
System.out.println("OTP:"+otp);
return otp;}
public boolean verify(String email,String otp){
return otp.equals(store.get(email));}}