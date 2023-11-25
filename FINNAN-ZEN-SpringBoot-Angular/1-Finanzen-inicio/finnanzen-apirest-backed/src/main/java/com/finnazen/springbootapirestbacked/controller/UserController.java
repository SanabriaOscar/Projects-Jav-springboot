package com.finnazen.springbootapirestbacked.controller;

import com.finnazen.springbootapirestbacked.exceptions.ErrorServerAdmin;
import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.User;
import com.finnazen.springbootapirestbacked.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<Object> listAllUsers() {
        try {
            List<User> users = userService.listAllUsers();
            if (users.isEmpty()) {
                String successMessage = "No se encontraron usuarios.";
                return ResponseEntity.status(HttpStatus.OK).body(successMessage);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(users);
            }
        } catch (ErrorServerAdmin e) {
            logger.error("Error al listar los usuarios.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            String successMessage = "Usuario creado con éxito.";
            return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
        } catch (ErrorServerAdmin e) {
            logger.error("Error al guardar el usuario.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdUser(@PathVariable Long id) {
        try {
            User user = userService.findByIdUser(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                String errorMessage = "No se encontró el usuario con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al buscar el usuario por ID.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al buscar el usuario por ID.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long id) {
        try {
            User userUpdated = userService.UpdateUserById(user, id);
            if (userUpdated != null) {
                String successMessage = "Usuario actualizado con éxito.";
                return ResponseEntity.status(HttpStatus.OK).body(successMessage);
            } else {
                String errorMessage = "No se encontró el usuario con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        } catch (ResourceNotFoundException e) {
            logger.error("Error al actualizar el usuario.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al actualizar el usuario.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        try {
            User deletedUser = userService.findByIdUser(id);
            if (deletedUser != null) {
                userService.deleteUserById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado con éxito.");
            } else {
                String errorMessage = "No se encontró el usuario con el id: " + id;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al eliminar el usuario.", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ErrorServerAdmin e) {
            logger.error("Error al eliminar el usuario.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
