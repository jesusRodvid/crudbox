package com.practica.crudbox.payload;
//https://github.com/RameshMF/springboot-blog-rest-api/tree/main/src/main/java/com/springboot/blog/payload

import lombok.Data;

@Data
public class LoginDTO {

    private String username;

    private String password;


}
