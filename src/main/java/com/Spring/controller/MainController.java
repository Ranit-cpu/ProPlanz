package com.Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class MainController {
      
      @GetMapping("/")
      public String home(){
            return"index";
      }
      
      @GetMapping("/calculate")
      public String Calculate(@RequestParam int num1, @RequestParam int num2, Model model) {
            
            try{
                  ProcessBuilder process = new ProcessBuilder("python3","/Users/ranitsaha/Developer/java/ProPlanz/script.py",String.valueOf(num1),
                          String.valueOf(num2));
                  process.redirectErrorStream(true);
                  
                  Process pros = process.start();
                  
                  BufferedReader read = new BufferedReader(new InputStreamReader(pros.getInputStream()));
                  String result = read.readLine();
                  pros.waitFor();

                  model.addAttribute("result","Result from python : "+result);
            } catch (Exception e) {
                  model.addAttribute("result","Error" + e.getMessage());
            }
            return "index";
      }
}