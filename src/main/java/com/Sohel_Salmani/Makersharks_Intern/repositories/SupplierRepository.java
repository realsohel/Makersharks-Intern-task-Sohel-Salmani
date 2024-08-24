package com.Sohel_Salmani.Makersharks_Intern.repositories;

import com.Sohel_Salmani.Makersharks_Intern.entities.SupplierEntity;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.ManufacturingProcess;
import com.Sohel_Salmani.Makersharks_Intern.entities.enums.NatureOfBusiness;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    Page<SupplierEntity> findByLocationAndNatureOfBusinessAndManufacturingProcessesIn(
            String location,
            NatureOfBusiness natureOfBusiness,
            Set<ManufacturingProcess> manufacturingProcesses,
            Pageable pageable);

    boolean existsByCompanyName(String companyName);
}
