package com.example.BBVApruebaNNData.service;

import com.example.BBVApruebaNNData.model.DocumentType;

import java.util.List;

public interface IDocumentTypeService {
    public List<DocumentType> listAllDocuments();
    public DocumentType saveDocumentType(DocumentType documentType);
    public DocumentType findByIdDocumentType(int id);
    public void deleteDocumentType(int id);
}
