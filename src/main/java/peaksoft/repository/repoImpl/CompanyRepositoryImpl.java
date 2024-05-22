package peaksoft.repository.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.repository.CompanyRepository;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */

@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveCompany(Company company) {
        entityManager.persist(company);

    }

    @Override
    public List<Company> getAllCompanies() {
        return entityManager.
                createQuery("select c from Company  c",Company.class)
                .getResultList();
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
