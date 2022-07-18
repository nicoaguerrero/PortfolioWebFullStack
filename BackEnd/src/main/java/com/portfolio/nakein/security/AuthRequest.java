package com.portfolio.nakein.security;

import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
public class AuthRequest {
    @Email
    @Length(min=5, max=50)
    private String email;
    @Length(min=5, max=50)
    private String password;
    
}
