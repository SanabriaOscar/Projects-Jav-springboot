package com.example.challenge_crud_printers.controller;


import com.example.challenge_crud_printers.model.Printer;
import com.example.challenge_crud_printers.service.PrinterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PrinterController {

    @Autowired
    public PrinterServiceImpl printerService;

    @GetMapping("/printers")
    public String listAllC(Model model){
        List<Printer> printers=printerService.listAllPrinters();
        model.addAttribute("printers", printers);
        return "index";
    }
    @GetMapping("/new")
    public String addPrinter(Model model){
        Printer printer =new Printer();
        model.addAttribute("printer", printer);
        return "newPrinter.html";
    }

    @PostMapping("/save")
    public String savePrinter(@ModelAttribute("printer") Printer printer){
        printerService.savePrinter(printer);
        return "redirect:/printers";

    }
    @GetMapping("/printing")
    public String printing(Model model){
        Printer printer =new Printer();
      String dataPrinter=  printer.getNombrePrinter();
        model.addAttribute("dataPrinter", dataPrinter);
        return "printing.html";
    }



}
