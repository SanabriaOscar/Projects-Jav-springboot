package com.finnazen.springbootapirestbacked.service;

import com.finnazen.springbootapirestbacked.model.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> listAllRoles();
    public Role saveRole(Role role);
    public Role findByIdRole(Long id);
    public Role UpdateRoleById(Role role, Long id);
    public Role deleteRoleById(Long id);
}
