package com.security.SecurityDemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("denyAll()")
public class HelloWorldController {

        @PreAuthorize("hasAuthority('READ')")
        @GetMapping("/holaseg")
        public String secHelloWorld() {
            return "Hola Mundo TodoCode con seguridad";
        }

        @PreAuthorize("permitAll()")
        @GetMapping("/holanoseg")
        public String noSecHelloWorld() {
            return "Hola mundo TodoCode sin seguridad";
        }

}
