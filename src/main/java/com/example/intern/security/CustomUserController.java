package com.example.intern.security;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomUserController {
    private  final PasswordEncoder encoder;

    private final CustomUserRepository customUserRepository;

    public CustomUserController(PasswordEncoder encoder, CustomUserRepository customUserRepository) {
        this.encoder = encoder;
        this.customUserRepository = customUserRepository;
    }

    @PostMapping("/createnewuser")
    public ResponseEntity<String> createNewUser(@RequestBody CustomUser user){
        //should be service clss
        Optional<CustomUser> optionalUser=customUserRepository.findById(user.getUsername());
        if(!optionalUser.isPresent())
        {
            customUserRepository.save(new CustomUser(user.getUsername(),encoder.encode(user.getPassword())));
            return ResponseEntity.ok("Succes");
        }
        return ResponseEntity.ok("Failure");
    }
}
