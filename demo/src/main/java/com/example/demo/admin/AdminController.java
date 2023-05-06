package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/registration")
@CrossOrigin(origins = "http://localhost:4200") //evt. wegen CorsConfig nicht benötigt
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(path = "/create")
    public ResponseEntity<String> createNewAdmin(@RequestBody Admin admin){
        if(this.adminService.createNewAdmin(admin)){
            return new ResponseEntity<String>("Admin wurde erstellt nicht!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Admin konnte nicht erstellt werden.",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Admin>>getAdminList(){
        return new ResponseEntity<>(this.adminService.getAdminList(),HttpStatus.OK);
    }
}
