package com.finnazen.springbootapirestbacked.controller;

import com.finnazen.springbootapirestbacked.exceptions.ErrorServerAdmin;
import com.finnazen.springbootapirestbacked.exceptions.ResourceNotFoundException;
import com.finnazen.springbootapirestbacked.model.User;
import com.finnazen.springbootapirestbacked.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Intentar guardar el usuario
            userService.saveUser(user);
            response.put("mensaje", "Usuario creado con éxito.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (ErrorServerAdmin e) {
            // En caso de excepción, manejarla y devolver un mensaje de error
            String errorMessage = "Error al guardar el usuario: " + e.getMessage();
            response.put("mensaje", errorMessage);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdUser(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            User user = userService.findByIdUser(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                response.put("mensaje", "No se encontró el usuario con el id: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
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
        Map<String, Object> response = new HashMap<>();

        try {
            // Intentar actualizar el usuario
            User userUpdated = userService.UpdateUserById(user, id);
            if (userUpdated != null) {
                response.put("mensaje", "Usuario actualizado con éxito.");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("mensaje", "No se encontró el usuario con el id: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (ResourceNotFoundException e) {
            // En caso de excepción, manejarla y devolver un mensaje de error
            logger.error("Error al actualizar el usuario.", e);
            response.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (ErrorServerAdmin e) {
            // En caso de excepción, manejarla y devolver un mensaje de error
            logger.error("Error al actualizar el usuario.", e);
            response.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            User deletedUser = userService.findByIdUser(id);
            if (deletedUser != null) {
                userService.deleteUserById(id);
                response.put("mensaje", "Usuario eliminado con éxito.");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                String errorMessage = "No se encontró el usuario con el id: " + id;
                response.put("mensaje", errorMessage);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (ResourceNotFoundException e) {
            logger.error("Error al eliminar el usuario.", e);
            response.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (ErrorServerAdmin e) {
            logger.error("Error al eliminar el usuario.", e);
            response.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
