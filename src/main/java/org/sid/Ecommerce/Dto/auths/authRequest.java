package org.sid.Ecommerce.Dto.auths;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class authRequest {
    private String mail;
    private  String password;
}
