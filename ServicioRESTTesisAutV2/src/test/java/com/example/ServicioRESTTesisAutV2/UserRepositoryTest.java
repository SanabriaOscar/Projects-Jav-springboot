package com.example.ServicioRESTTesisAutV2;


import com.example.ServicioRESTTesisAutV2.model.User;
import com.example.ServicioRESTTesisAutV2.repository.UserRepository;
import com.example.ServicioRESTTesisAutV2.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    //------------------TESTINT WITH Mockito-------------------------------------
//    @Test
//    @Rollback(false)
//    public void saveUserTest(){
//        User user =User.builder()
//                .id(10).name("tets").lastname("perez").identification("24653")
//                .email("tavera@gmail.com").
//                password("$2a$10$dxuAHlrB/p8C0cFBXOzKpe1BcNMrcRfXKSMhbMQsomY7bLoJphOVm")
//                .city("bogota").country("colombia")
//                .postalCode("3345").build();
//        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
//        User created = userService.saveUser(new User());
//        assertThat(created.getName()).isSameAs(user.getName());
//        verify(userRepository).save(user);
//    }
    @Test
    public void ListAllUsers() {
        List<User> users = new ArrayList();
        users.add(new User());
        given(userRepository.findAll()).willReturn(users);
        List<User> expected = userService.ListAllUsers();
        assertEquals(expected, users);
        verify(userRepository).findAll();
    }


    @Test
    public void listUserBYID() {
        User user = new User(1,"tets","perez", "24653","tavera@gmail.com",
                "$2a$10$dxuAHlrB/p8C0cFBXOzKpe1BcNMrcRfXKSMhbMQsomY7bLoJphOVm",
                "bogota", "colombia","3345");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        User expected = userService.findUserByid(user.getId());
        assertThat(expected).isSameAs(user);
        verify(userRepository).findById(user.getId());
    }
    @Test
    public void deleteUserTest(){
        User user = new User(1,"tets","perez", "24653","tavera@gmail.com",
                "$2a$10$dxuAHlrB/p8C0cFBXOzKpe1BcNMrcRfXKSMhbMQsomY7bLoJphOVm",
                "bogota", "colombia","3345");
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userService.deleteuser(user.getId());
        verify(userRepository).deleteById(user.getId());
    }

//




}
