package com.example.demo.admin;

import com.example.demo.testing.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public boolean createNewAdmin(Admin admin){
        //Check der Daten Fehlt noch
        this.adminRepository.save(admin);
        return true;
    }

    public List<Admin> getAdminList(){
        return this.adminRepository.findAll();
    }

    private boolean checkAdminData(Admin admin){
        //wenn Daten In Ordnung sind, gib TRUE aus, sonst FALSE
        return true;
    }
}
