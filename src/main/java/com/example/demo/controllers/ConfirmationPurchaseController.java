package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfirmationPurchaseController {

    @RequestMapping("/confirmationpurchase")
    public String start() {

        return "confirmationpurchase";

    }
}