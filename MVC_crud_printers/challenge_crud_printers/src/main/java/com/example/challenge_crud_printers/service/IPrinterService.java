package com.example.challenge_crud_printers.service;


import com.example.challenge_crud_printers.model.Printer;

import java.util.List;

public interface IPrinterService {
    List<Printer>listAllPrinters();
    void savePrinter(Printer printer);

    Printer findByIdPrinter(int id);
}
