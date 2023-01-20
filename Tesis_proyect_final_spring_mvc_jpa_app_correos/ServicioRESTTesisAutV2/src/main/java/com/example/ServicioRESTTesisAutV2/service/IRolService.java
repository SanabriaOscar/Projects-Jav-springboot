package com.example.ServicioRESTTesisAutV2.service;

import com.example.ServicioRESTTesisAutV2.model.Role;

import java.util.List;

public interface IRolService {
    public List<Role> ListAllRoles();
    public Role saveRole(Role role);
    public  Role findRoleByid(int id);
    public  void deleteRole(int id);
}
