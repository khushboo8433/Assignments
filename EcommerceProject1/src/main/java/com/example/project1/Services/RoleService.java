package com.example.project1.Services;

import com.example.project1.entities.Role;
import com.example.project1.enums.ERole;
import com.example.project1.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void saveRole(ERole role){
        Role role1= roleRepository.findByAuthority(role.toString());
        if(role1==null){
            Role role2=new Role();
            role2.setAuthority(role.toString());
            roleRepository.save(role2);
        }
    }
}
