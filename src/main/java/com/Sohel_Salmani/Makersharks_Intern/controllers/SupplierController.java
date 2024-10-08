package com.Sohel_Salmani.Makersharks_Intern.controllers;

import com.Sohel_Salmani.Makersharks_Intern.dto.SupplierDto;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.ManufacturingProcess;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.NatureOfBusiness;
import com.Sohel_Salmani.Makersharks_Intern.services.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;
    @PostMapping("/addsupplier")
    public SupplierDto createSupplier( @Valid @RequestBody SupplierDto supplierDto){

        return supplierService.createSupplier(supplierDto);
    }


    @PostMapping("/query")
    public Page<SupplierDto> getSuppliers(
            @RequestParam String location,
            @RequestParam NatureOfBusiness natureOfBusiness,
            @RequestParam Set<ManufacturingProcess> manufacturingProcesses,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return supplierService.findSuppliers(location, natureOfBusiness, manufacturingProcesses, page, size);
    }

// TODO: Implement JWT-based authentication to protect the API.
}
