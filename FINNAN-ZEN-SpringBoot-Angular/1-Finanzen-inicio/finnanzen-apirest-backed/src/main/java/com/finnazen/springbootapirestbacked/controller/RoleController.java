package com.finnazen.springbootapirestbacked.controller;


import com.finnazen.springbootapirestbacked.exceptions.ErrorServerAdmin;
import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.Role;
import com.finnazen.springbootapirestbacked.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<Object> listAllRoles() {
        try {
            List<Role> roles = roleService.listAllRoles();
            if (roles.isEmpty()) {
                String successMessage = "No se encontraron roles.";
                return ResponseEntity.status(HttpStatus.OK).body(successMessage);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(roles);
            }
        } catch (ErrorServerAdmin e) {
            logger.error("Error al listar los roles.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveRole(@RequestBody Role role) {
        try {
            roleService.saveRole(role);
            String successMessage = "Rol creado con éxito.";
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
        } catch (ErrorServerAdmin e) {
            logger.error("Error al guardar el rol.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdRole(@PathVariable Long id) {
        try {
            Role role = roleService.findByIdRole(id);
            if (role != null) {
                return ResponseEntity.ok(role);
            } else {
                String errorMessage = "No se encontró el rol con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al buscar el rol por ID.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al buscar el rol por ID.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRole(@RequestBody Role role, @PathVariable Long id) {
        try {
            Role roleUpdated = roleService.UpdateRoleById(role, id);
            if (roleUpdated != null) {
                String successMessage = "Rol actualizado con éxito.";
                return ResponseEntity.status(HttpStatus.OK).body(successMessage);
            } else {
                String errorMessage = "No se encontró el rol con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        } catch (ResourceNotFoundException e) {
            logger.error("Error al actualizar el rol.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al actualizar el rol.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        try {
            Role deletedRole = roleService.findByIdRole(id);
            if (deletedRole != null) {
                roleService.deleteRoleById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Rol eliminado con éxito.");
            } else {
                String errorMessage = "No se encontró el rol con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al eliminar el rol.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al eliminar el rol.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
