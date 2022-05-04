package com.practica.crudbox.service;

import com.practica.crudbox.dto.DiscountDTO;
import com.practica.crudbox.dto.ItemDTO;

import java.util.List;

public interface DiscountService {

    DiscountDTO createDiscount (DiscountDTO discountDTO);

    List<DiscountDTO> getAllDiscounts();

    DiscountDTO getDiscountById(Long id);

    DiscountDTO updateDiscounts (DiscountDTO discountDTO, long id);

    void deleteDiscountById(long id);
}
