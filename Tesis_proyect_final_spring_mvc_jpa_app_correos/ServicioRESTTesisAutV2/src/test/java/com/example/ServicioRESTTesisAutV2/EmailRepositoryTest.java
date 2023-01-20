package com.example.ServicioRESTTesisAutV2;


import com.example.ServicioRESTTesisAutV2.model.Email;
import com.example.ServicioRESTTesisAutV2.repository.EmailRepository;
import com.example.ServicioRESTTesisAutV2.service.EmailServiceImpl;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class EmailRepositoryTest {

    @Mock
    private EmailRepository emailRepository;

    @InjectMocks
    private EmailServiceImpl emailService;
    @BeforeEach
    public  void setup(){
        MockitoAnnotations.openMocks( this);
    }
    //------------------TESTINT WITH Mockito-------------------------------------
//    @Test
//    @Rollback(false)
//    public void saveEmailTest(){
//        Email email =Email.builder()
//                .id(10).sender("pedro").primaryRecipient("juan")
//                .cC("yes")
//                .bCC("yes")
//                .body("message").attachments("foto.img").build();
//        when(emailRepository.save(ArgumentMatchers.any(Email.class))).thenReturn(email);
//        Email created = emailService.sendEmail(email);
//        assertThat(created.getSender()).isSameAs(email.getSender());
//        verify(emailRepository).save(email);
//    }


}
