package com.Sohel_Salmani.Makersharks_Intern.services;

import com.Sohel_Salmani.Makersharks_Intern.dto.SupplierDto;
import com.Sohel_Salmani.Makersharks_Intern.entities.SupplierEntity;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.ManufacturingProcess;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.NatureOfBusiness;
import com.Sohel_Salmani.Makersharks_Intern.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    public SupplierDto createSupplier(SupplierDto supplierDto) {
        if (supplierRepository.existsByCompanyName(supplierDto.getCompanyName())) {
            throw new IllegalArgumentException("Company name must be unique.");
        }
        SupplierEntity supplier= modelMapper.map(supplierDto,SupplierEntity.class);

        return modelMapper.map(supplierRepository.save(supplier), SupplierDto.class);
    }

    public Page<SupplierDto> findSuppliers(String location, NatureOfBusiness natureOfBusiness, Set<ManufacturingProcess> manufacturingProcesses, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SupplierEntity> supplierEntity =  supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
                location, natureOfBusiness, manufacturingProcesses, pageable);

        return supplierEntity
                .map((supplier)->modelMapper.map(supplier, SupplierDto.class));
    }
}
