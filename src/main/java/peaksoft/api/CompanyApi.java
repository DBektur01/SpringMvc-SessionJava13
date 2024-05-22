package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyApi {

    private final CompanyService companyService;

    @GetMapping("/all")
    public String getAllCompanies(Model model){
        model.addAttribute("allCompanies",companyService.getAllCompanies());
        return "mainPage";
    }

    @GetMapping("/newCompany")
    public String addCompany(Model model){
        model.addAttribute("newCompany",new Company());
        return "newCompany";
    }
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany")Company company){
        companyService.saveCompany(company);
        return "redirect:/companies/all";

    }



}
