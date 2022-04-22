package com.example.ECommerceHN.Controller;

import com.example.ECommerceHN.Controller.payload.MessageResponse;
import com.example.ECommerceHN.Controller.payload.SigninRequest;
import com.example.ECommerceHN.Controller.payload.SignupRequest;
import com.example.ECommerceHN.repository.entity.User;
import com.example.ECommerceHN.security.jwt.JwtResponse;
import com.example.ECommerceHN.security.jwt.JwtUtils;
import com.example.ECommerceHN.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("authRestController")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest dto){
        System.out.println("Entry signup");
        boolean userAlreadyExist = userService.checkUsernameExist(dto.getUsername());

        if(userAlreadyExist){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("User already exist !"));
        }

        User createdUser = userService.signup(dto.getUsername(), dto.getPassword());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new MessageResponse("User registration success"));

    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@Valid @RequestBody SigninRequest dto){
        System.out.println("Entry signin");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String tokenJwtGenerated = jwtUtils.generateJwtToken(authentication);

        User user = (User)authentication.getPrincipal();

        return ResponseEntity
                .ok(new JwtResponse(
                        user.getId(),
                        user.getUsername(),
                        tokenJwtGenerated
                ));

    }
}