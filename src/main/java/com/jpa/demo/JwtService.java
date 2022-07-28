package com.jpa.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    
    @Value("$(security.jwt.expiration)")
    private String expiration;

    @Value("$(security.jwt.signature-key)")
    private String signatureKey;

}
