package com.example.pruebaNTTDATA;
import com.example.pruebaNTTDATA.model.Task;
import com.example.pruebaNTTDATA.model.User;
import com.example.pruebaNTTDATA.repository.TaskRepository;
import com.example.pruebaNTTDATA.repository.UserRepository;
import com.example.pruebaNTTDATA.service.TaskServiceImpl;
import com.example.pruebaNTTDATA.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;
    @BeforeEach
    public  void setup(){
        MockitoAnnotations.openMocks( this);
    }

    @Test
    @Rollback(false)
    public void saveUserTest(){
        User user = new User(4,"other","sanches","calle45",1233333,new Task(4,"fixed a cumputer"));
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        User created = userService.saveUser(user);
        assertThat(created.getName()).isSameAs(user.getName());
        verify(userRepository).save(user);
    }
    @Test
    public void ListAllUsers() {
        List<User> users = new ArrayList();
        users.add(new User());
        given(userRepository.findAll()).willReturn(users);
        List<User> expected = userService.listAllUsers();
        assertEquals(expected, users);
        verify(userRepository).findAll();
    }

    @Test
    public void listTaskBYID() {
        User user = new User(4,"other","sanches","calle45",1233333,new Task(4,"fixed a cumputer"));
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        User expected = userService.findByIdUser(user.getId());
        assertThat(expected).isSameAs(user);
        verify(userRepository).findById(user.getId());
    }
    @Test
    public void deleteTaskTest(){
        User user = new User(4,"other","sanches","calle45",1233333,new Task(4,"fixed a cumputer"));
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userService.deleteUser(user.getId());
        verify(userRepository).deleteById(user.getId());
    }

}
