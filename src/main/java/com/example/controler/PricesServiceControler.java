package com.example.controler;

import com.example.dto.FinalPriceDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("prices")
public class PricesServiceControler {

    @GetMapping
    public FinalPriceDTO getAllRecords() {
        return new FinalPriceDTO("");
    }

}
