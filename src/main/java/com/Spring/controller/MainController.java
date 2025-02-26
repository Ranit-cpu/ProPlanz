package com.Spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class MainController {
      
      @PostMapping("/calculate")
      public String Calculate(@RequestParam int num1, @RequestParam int num2, Model model) {
            
            try{
                  ProcessBuilder process = new ProcessBuilder("python3","script.py",String.valueOf(num1),
                          String.valueOf(num2));
                  process.redirectErrorStream(true);
                  
                  Process pros = process.start();
                  
                  BufferedReader read = new BufferedReader(new InputStreamReader(pros.getInputStream()));
                  String result = read.readLine();
                  model.addAttribute("result","Result from python : "+result);
            } catch (Exception e) {
                  model.addAttribute("result","Error" + e.getMessage());
            }
            
            return "index";
      }
}
