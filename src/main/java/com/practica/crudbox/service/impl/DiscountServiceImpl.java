package com.practica.crudbox.service.impl;

import com.practica.crudbox.dto.DiscountDTO;
import com.practica.crudbox.dto.UserDTO;
import com.practica.crudbox.exception.ResourceNotFoundException;
import com.practica.crudbox.model.Discount;
import com.practica.crudbox.model.User;
import com.practica.crudbox.repository.DiscountRepository;
import com.practica.crudbox.service.DiscountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DiscountServiceImpl implements DiscountService {

    private ModelMapper mapper;

    private DiscountRepository discountRepository;

    public DiscountServiceImpl(ModelMapper mapper, DiscountRepository discountRepository) {
        this.mapper = mapper;
        this.discountRepository = discountRepository;
    }

    @Override
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {

        Discount discount = mapToEntity(discountDTO);
        Discount newDiscount = discountRepository.save(discount);

        DiscountDTO discountResponse = mapToDTO(newDiscount);

        return discountResponse;
    }

    @Override
    public List<DiscountDTO> getAllDiscounts() {
        List<Discount> discountList = discountRepository.findAll();

        return discountList.stream().map(discount -> mapToDTO(discount)).collect(Collectors.toList());
    }

    @Override
    public DiscountDTO getDiscountById(Long id) {

        Discount discount = discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discount", "id", id));

        return mapToDTO(discount);
    }

    @Override
    public DiscountDTO updateDiscounts(DiscountDTO discountDTO, long id) {

        Discount discount = discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discount", "id", id));
        discount.setDiscountedPrice(discountDTO.getDiscountedPrice());
        discount.setStartDate(discountDTO.getStartDate());
        discount.setEndDate(discountDTO.getEndDate());

        Discount updateDiscount = discountRepository.save(discount);

        return mapToDTO(updateDiscount);

    }

    @Override
    public void deleteDiscountById(long id) {

        Discount discount = discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Discount", "id", id));
        discountRepository.delete(discount);

    }

    private DiscountDTO mapToDTO(Discount discount) {

        DiscountDTO discountDTO = mapper.map (discount, DiscountDTO.class);

        return discountDTO;
    }

    private Discount mapToEntity(DiscountDTO discountDTO) {

        Discount discount = mapper.map (discountDTO, Discount.class);

        return discount;
    }
}
