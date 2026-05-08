package com.authsystem.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.authsystem.service.AuthService;
import com.authsystem.entity.User;
import java.util.Map;
@RestController
@RequestMapping("/auth")
public class AuthController{
@Autowired AuthService service;
@PostMapping("/register")
public String register(@RequestBody User u){return service.register(u);}
@PostMapping("/login")
public String login(@RequestBody Map<String,String> req){
return service.login(req.get("email"),req.get("password"));}
@PostMapping("/verify")
public String verify(@RequestBody Map<String,String> req){
return service.verify(req.get("email"),req.get("otp"));}}