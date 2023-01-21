package com.example.TestbbogotaREST;

import com.example.TestbbogotaREST.model.DocumentType;
import com.example.TestbbogotaREST.model.User;
import com.example.TestbbogotaREST.repository.DocumentTypeRepository;
import com.example.TestbbogotaREST.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DataMockRepositoryWithJUnit {
    @Autowired
     private  UserRepository userRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Test
    @Rollback(value = false)
    public void saveUserTestWithJUnit(){
        User user=new User(
                1,
                "oscar",
                "jesus",
                "sanabria",
                "tavera",
                31329746,
                23445322,
                "calle-40",
                "kennedy", new DocumentType(1,"U"));

        User userSaved=userRepository.save(user);
        assertNotNull(userSaved);
    }
        @Test
    @Rollback(value = false)
    public void saveDocumentTypeTestWithJUnit(){
        DocumentType documentType1=new DocumentType(1,"P");
        DocumentType documentTypeSaved=documentTypeRepository.save(documentType1);
        assertNotNull(documentTypeSaved);
    }
}
