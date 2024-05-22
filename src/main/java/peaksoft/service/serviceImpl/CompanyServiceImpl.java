package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;


    @Override
    public void saveCompany(Company company) {
        companyRepository.saveCompany(company);

    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return null;
    }

    @Override
    public void deletedCompanyById(Long companyId) {

    }

    @Override
    public void updateCompanyById(Long companyId, Company newCompany) {

    }
}
