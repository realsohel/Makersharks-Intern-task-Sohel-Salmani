package com.Sohel_Salmani.Makersharks_Intern.dto;

import com.Sohel_Salmani.Makersharks_Intern.entities.enums.ManufacturingProcess;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.NatureOfBusiness;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Set;

@Data
public class SupplierDto {
    private Long id;

    private String companyName;
    private String website;
    private String location;
    private NatureOfBusiness natureOfBusiness;

    private Set<ManufacturingProcess> manufacturingProcesses;

}
