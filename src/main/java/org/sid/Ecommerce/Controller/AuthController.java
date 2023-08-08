package org.sid.Ecommerce.Controller;

import org.sid.Ecommerce.Dto.auths.authResponce;
import org.sid.Ecommerce.Dto.auths.authRequest;
import org.sid.Ecommerce.Services.auth.ApplicationDetailservice;
import org.sid.Ecommerce.Utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.APP_ROOT+"/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    ApplicationDetailservice applicationDetailservice;

    @PostMapping("/authenticate")
    public ResponseEntity<authResponce> authenticate(@RequestBody authRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getMail(),request.getPassword()
        ));
        final UserDetails userDetails=applicationDetailservice.loadUserByUsername(request.getMail());
        return  ResponseEntity.ok(authResponce.builder().accessToken("dummy_access_token").build());
    }
}
