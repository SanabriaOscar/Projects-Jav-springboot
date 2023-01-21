package com.example.TestbbogotaREST.controller;

import com.example.TestbbogotaREST.model.DocumentType;
import com.example.TestbbogotaREST.service.DocumentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentTypeController {
@Autowired
    private DocumentTypeServiceImpl documentTypeService;

    @GetMapping("/documents")
    public ResponseEntity<DocumentType> listAllDocumentsC(){
        List<DocumentType> documents = documentTypeService.listAllDocuments();
        return new ResponseEntity(documents, HttpStatus.OK);

    }
    @PostMapping("/documents/add")
    public ResponseEntity<DocumentType> saveDocumentC(@RequestBody DocumentType documentType){
       try {
           documentTypeService.saveDocumentType(documentType);
           return new ResponseEntity<DocumentType>(documentType, null, HttpStatus.CREATED);
       }catch (Exception e){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    @GetMapping("/documents/{id}")
    public ResponseEntity<DocumentType> listDocumentByIdC(@PathVariable int id) {
        DocumentType documentType= documentTypeService.findByIdDocumentType(id);
        if (null == documentType) {
            return new ResponseEntity<DocumentType>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DocumentType>(documentType, HttpStatus.OK);
    }
    @PutMapping("/documents/edit/{id}")
    public ResponseEntity<DocumentType> updateDocumentByIdC(@PathVariable int id, @RequestBody DocumentType documentType) {
      try{
          DocumentType documentUpdate= documentTypeService.findByIdDocumentType(id);
          if (null == documentUpdate) {
              return new ResponseEntity<DocumentType>(HttpStatus.NOT_FOUND);
          }
          documentUpdate.setName(documentType.getName());
          documentTypeService.saveDocumentType(documentType);
        return new ResponseEntity<DocumentType>(documentUpdate, HttpStatus.OK);

      }catch (Exception e){
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
    @DeleteMapping("/documents/delete/{id}")
    public ResponseEntity<DocumentType> deleteDocumentTypeC(@PathVariable int id){
        DocumentType documentType= documentTypeService.findByIdDocumentType(id);
        if (null == documentType) {
            return new ResponseEntity<DocumentType>(HttpStatus.NOT_FOUND);
        }
        documentTypeService.deleteDocumentType(id);
        return new ResponseEntity<DocumentType>(HttpStatus.OK);
    }
 // @GetMapping("documents/")




}
