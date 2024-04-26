package org.example;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.UUID;
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @PutMapping(value = "/import")
    public String importTeacher(@RequestPart("file") MultipartFile file,@RequestParam("body") String body) throws MessagingException {
        try {
            service.importEmployeeFromExcel(file, body);
            return "Sucess";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
