package com.aws.polly.model;

import org.springframework.web.multipart.MultipartFile;
//reference:
//https://github.com/eugenp/tutorials/blob/master/spring-mvc-java/src/main/java/com/baeldung/model/FormDataWithFile.java
public class FormDataWithFile {

    private String name;
    private String email;
    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}