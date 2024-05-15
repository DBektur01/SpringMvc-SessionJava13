package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Agency;
import peaksoft.exception.MyException;
import peaksoft.service.AgencyService;

import java.util.List;

@Controller
@RequestMapping("/agencies")
public class AgencyApi {


    private final AgencyService agencyService;

    @Autowired
    public AgencyApi(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping("/new")
    public String createAgency(Model model) {
        model.addAttribute("newAgency", new Agency());
        return "/agency/newAgency";
    }

    @PostMapping("/newAgency")
    public String saveAgency(@ModelAttribute("newAgency") Agency agency) {
        agencyService.saveAgency(agency);
        return "redirect:/agencies";
    }

    @GetMapping
    public String getAllAgencies(Model model) {
        model.addAttribute("agencies", agencyService.getAllAgency());
        return "agency/agencyMainPage";
    }

    @GetMapping("/{agencyId}/edit")
    public String getById(@PathVariable("agencyId") Long agencyId, Model model) throws MyException {
        model.addAttribute("agency", agencyService.getById(agencyId));
        return "/agency/updateAgency";
    }

    @PostMapping("/update/{agencyId}")
    public String updateAgency(@PathVariable("agencyId") Long agencyId, @ModelAttribute("agency") Agency agency) throws MyException {
        agencyService.updateAgencyById(agencyId, agency);
        return "redirect:/agencies";
    }

    @PostMapping ("/{agencyId}")
    public String delete(@PathVariable Long agencyId){
        agencyService.deleteById(agencyId);
        return "redirect:/agencies";
    }

    @GetMapping("/agencies/search")
    public String searchAgency(@RequestParam("word") String word, Model model) {
        List<Agency> agencies = agencyService.searchAgency(word);
        model.addAttribute("c", agencies);
        return "agency/agencyMainPage";
    }
}
// POST - SAVE
// PUT - UPDATE
// GET - GET