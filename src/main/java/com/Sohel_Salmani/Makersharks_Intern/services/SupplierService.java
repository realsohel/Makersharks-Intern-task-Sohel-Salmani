package com.Sohel_Salmani.Makersharks_Intern.services;

import com.Sohel_Salmani.Makersharks_Intern.dto.SupplierDto;
import com.Sohel_Salmani.Makersharks_Intern.entities.SupplierEntity;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.ManufacturingProcess;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.NatureOfBusiness;
import com.Sohel_Salmani.Makersharks_Intern.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
        SupplierEntity supplier= modelMapper.map(supplierDto,SupplierEntity.class);

        return modelMapper.map(supplierRepository.save(supplier), SupplierDto.class);
    }

    public List<SupplierDto> findSuppliers(String location, NatureOfBusiness natureOfBusiness, Set<ManufacturingProcess> manufacturingProcesses, int limit) {

        List<SupplierEntity> supplierEntities = supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
                location, natureOfBusiness, manufacturingProcesses);

        List<SupplierDto>suppliers = supplierEntities
                .stream()
                .map((supplierEntity)->modelMapper.map(supplierEntity,SupplierDto.class))
                .collect(Collectors.toList());
        return suppliers.size() > limit ? suppliers.subList(0, limit) : suppliers;
    }
}
