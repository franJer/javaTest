package com.example.application.controler;

import com.example.application.dto.FinalPriceDTO;
import com.example.application.model.entity.Price;
import com.example.application.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
@RestController
public class PricesServiceControler {

    @Autowired
    private PricesService pricesService;

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public FinalPriceDTO getByProductByBrandAndDate(
            @RequestParam(value = "productId") String productId,
            @RequestParam(value = "brandId") String brandId,
            @RequestParam(value = "date") String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Optional<Price> price = pricesService.getPricesByProductDateGroup(Integer.parseInt(productId) , Integer.parseInt(brandId) , dateTime);

        if (price.isPresent()) {
            return  FinalPriceDTO.toDTO(price.get());
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Price Not Found");
        }

    }

}
