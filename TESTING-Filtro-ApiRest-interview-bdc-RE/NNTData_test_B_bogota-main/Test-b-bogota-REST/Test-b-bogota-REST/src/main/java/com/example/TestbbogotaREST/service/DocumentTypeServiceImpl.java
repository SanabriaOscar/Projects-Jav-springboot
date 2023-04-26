package com.example.TestbbogotaREST.service;

import com.example.TestbbogotaREST.exceptions.ResourceNotFoundException;
import com.example.TestbbogotaREST.model.DocumentType;
import com.example.TestbbogotaREST.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeServiceImpl implements IDocumentTypeService{
@Autowired
    private DocumentTypeRepository documentTypeRepository;


    @Override
    public List<DocumentType> listAllDocuments() {
        return documentTypeRepository.findAll();
    }

    @Override
    public DocumentType saveDocumentType(DocumentType documentType) {
        Optional<DocumentType> savedDocumentTypt = documentTypeRepository.findById(documentType.getId());
        if(savedDocumentTypt.isPresent()){
             new ResourceNotFoundException("Document type already exist with given email:" + documentType.getId());
        }
        return documentTypeRepository.save(documentType);
    }



    @Override
    public DocumentType findByIdDocumentType(int id) {
        return documentTypeRepository.findById(id).get();
    }

    @Override
    public void deleteDocumentType(int id) {
documentTypeRepository.deleteById(id);
    }
}
