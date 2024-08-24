package com.Sohel_Salmani.Makersharks_Intern.dto;

import com.Sohel_Salmani.Makersharks_Intern.entities.enums.ManufacturingProcess;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.NatureOfBusiness;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;

@Data
public class SupplierDto {
    private Long id;

    @NotBlank(message = "Company name cannot be blank")
    @Size(max = 255, message = "Company name cannot exceed 255 characters")
    private String companyName;

    @Pattern(
            regexp = "^(http[s]?://)?(www\\.)?[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+(/[a-zA-Z0-9-.,@?^=%&:;/~+#]*)?$",
            message = "Invalid website URL"
    )
    private String website;


    @NotBlank(message = "Location cannot be blank")
    @Size(max = 100, message = "Location cannot exceed 100 characters")
    private String location;

    @NotNull
    private NatureOfBusiness natureOfBusiness;

    @NotEmpty
    @Size(min = 1)
    @ElementCollection(targetClass = ManufacturingProcess.class)
    @Enumerated(EnumType.STRING)
    private Set<ManufacturingProcess> manufacturingProcesses;

}
