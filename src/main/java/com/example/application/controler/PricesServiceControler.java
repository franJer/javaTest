package com.example.application.controler;

import com.example.application.dto.FinalPriceDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("prices")
public class PricesServiceControler {

    @GetMapping
    public FinalPriceDTO getAllRecords() {

        return new FinalPriceDTO("1");
    }



}
