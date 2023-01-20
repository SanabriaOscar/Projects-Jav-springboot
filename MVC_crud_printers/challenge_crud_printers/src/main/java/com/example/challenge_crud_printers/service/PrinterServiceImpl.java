package com.example.challenge_crud_printers.service;


import com.example.challenge_crud_printers.model.Printer;
import com.example.challenge_crud_printers.repository.PriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrinterServiceImpl implements IPrinterService {

    @Autowired
    public PriterRepository priterRepository;

    @Override
    public List<Printer> listAllPrinters() {

        return priterRepository.findAll();
    }


    @Override
    public void savePrinter(Printer printer) {

        priterRepository.save(printer);
    }

    @Override
    public Printer findByIdPrinter(int id) {
        return
                priterRepository.findById(id).get();
    }
}
