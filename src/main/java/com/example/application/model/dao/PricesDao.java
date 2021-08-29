package com.example.application.model.dao;

import com.example.application.model.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public interface PricesDao extends CrudRepository<Price, Long> {

}
