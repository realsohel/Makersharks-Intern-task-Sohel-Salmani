package com.Sohel_Salmani.Makersharks_Intern.entities;

import com.Sohel_Salmani.Makersharks_Intern.entities.enums.ManufacturingProcess;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.NatureOfBusiness;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", unique = true, nullable = false)
    private String companyName;

    private String website;
    @Column(name = "location", nullable = false)
    private String location;
    @Enumerated(EnumType.STRING)
    @Column(name = "nature_of_business", nullable = false)
    private NatureOfBusiness natureOfBusiness;

    @ElementCollection(targetClass = ManufacturingProcess.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "supplier_processes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "process")
    private Set<ManufacturingProcess> manufacturingProcesses;

}
