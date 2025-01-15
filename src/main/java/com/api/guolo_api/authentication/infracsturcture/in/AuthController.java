package com.api.guolo_api.authentication.infracsturcture.in;

import com.api.guolo_api.authentication.domain.model.LoginRequest;
import com.api.guolo_api.authentication.domain.model.SignupRequest;
import com.api.guolo_api.authentication.domain.model.UserDto;
import com.api.guolo_api.authentication.domain.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserAuthService userAuthService;

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("login/user")
    ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) throws NoSuchAlgorithmException {
        try{
            var res = this.userAuthService.login(loginRequest);
            if (res.isEmpty()) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res.get());

        } catch (Exception e){
            log.error("e: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("signup")
    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest){
        try{
            var res = this.userAuthService.create(signupRequest);
            if (res.equals(null)) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(res);

        } catch (Exception e){
            log.error("e: ", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
