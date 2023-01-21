package com.example.TestbbogotaREST;

import com.example.TestbbogotaREST.model.DocumentType;
import com.example.TestbbogotaREST.model.User;
import com.example.TestbbogotaREST.repository.UserRepository;
import com.example.TestbbogotaREST.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.of;
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
    public void saveUserTest(){
        User user = new User(1,
                "oscar",
                "jesus",
                "sanabria",
                "tavera",
                31329746,
                23445322,
                "calle-40",
                new DocumentType(1,"N"));
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);
        User created = userService.saveUser(user);
        assertThat(created.getFirstName()).isSameAs(user.getFirstName());
        verify(userRepository).save(user);
    }
    @Test
    public void ListAllUsers() {
        List<User> users = new ArrayList();
        users.add(new User(1,
                "oscar",
                "jesus",
                "sanabria",
                "tavera",
                31329746,
                23445322,
                "calle-40",
                new DocumentType(1,"N")));
        given(userRepository.findAll()).willReturn(users);
        List<User> expected = userService.listAllUsers();
        assertEquals(expected, users);
        verify(userRepository).findAll();
    }

    @Test
    public void listUserBYID() {
        User user = new User(1,
                "oscar",
                "jesus",
                "sanabria",
                "tavera",
                31329746,
                23445322,
                "calle-40",
                new DocumentType(1,"N"));
        when(userRepository.findById(user.getId())).thenReturn(of(user));
        User expected = userService.findByIdUser(user.getId());
        assertThat(expected).isSameAs(user);
        verify(userRepository).findById(user.getId());
    }
    @Test
    public void deleteUserTest(){
        User user = new User(1,
                "oscar",
                "jesus",
                "sanabria",
                "tavera",
                31329746,
                23445322,
                "calle-40",
                new DocumentType(1,"N"));
        when(userRepository.findById(user.getId())).thenReturn(of(user));
        userService.deleteUser(user.getId());
        verify(userRepository).deleteById(user.getId());
    }

}
