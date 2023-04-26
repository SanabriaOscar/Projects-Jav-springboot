package com.example.BBVApruebaNNData;

import com.example.BBVApruebaNNData.model.DocumentType;
import com.example.BBVApruebaNNData.repository.DocumentTypeRepository;
import com.example.BBVApruebaNNData.service.DocumentTypeServiceImpl;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DocumentRepositotyTest {

    @Mock
    private DocumentTypeRepository documentTypeRepository;

    @InjectMocks
    private DocumentTypeServiceImpl documentTypeService;
    @BeforeEach
    public  void setup(){
        MockitoAnnotations.openMocks( this);
    }

    @Test
    public void saveDocumentTypeTest(){
        DocumentType documentType =new DocumentType(1,"N");
        when(documentTypeRepository.save(ArgumentMatchers.any(DocumentType.class))).thenReturn(documentType);
        DocumentType created = documentTypeService.saveDocumentType(documentType);
        assertThat(created.getName()).isSameAs(documentType.getName());
        verify(documentTypeRepository).save(documentType);
    }

    @Test
    public void ListAllDocumentTypes() {
        List<DocumentType> tasks = new ArrayList();
        tasks.add(new DocumentType());
        given(documentTypeRepository.findAll()).willReturn(tasks);
        List<DocumentType> DocumentTypeexpected = documentTypeService.listAllDocuments();
        assertEquals(DocumentTypeexpected, tasks);
        verify(documentTypeRepository).findAll();
    }

    @Test
    public void listDocumentTypeBYID() {
        DocumentType documentType = new DocumentType(1, "N");

        when(documentTypeRepository.findById(documentType.getId())).thenReturn(Optional.of(documentType));
        DocumentType expected = documentTypeService.findByIdDocumentType(documentType.getId());
        assertThat(expected).isSameAs(documentType);
        verify(documentTypeRepository).findById(documentType.getId());
    }
    @Test
    public void deleteDocumentTypeTest(){
        DocumentType documentType =new DocumentType(1,"N");
        when(documentTypeRepository.findById(documentType.getId())).thenReturn(Optional.of(documentType));
        documentTypeService.deleteDocumentType(documentType.getId());
        verify(documentTypeRepository).deleteById(documentType.getId());
    }

}
