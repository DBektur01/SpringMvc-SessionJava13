package peaksoft.service;

import peaksoft.entity.Company;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface CompanyService {

    void saveCompany(Company company);

    List<Company> getAllCompanies();

    Company getCompanyById(Long companyId);

    void deletedCompanyById(Long companyId);

    void updateCompanyById(Long companyId,Company newCompany);
}
