package org.example.controller;

import java.util.Arrays;

import org.example.domain.Organization;
import org.example.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @ModelAttribute
    @RequestMapping(value = "/editOrganization", method = RequestMethod.GET)
    public Organization getOrganization(@RequestParam(required = false, defaultValue = "0") Integer organizationId) {

        if (organizationId == 0)
            return new Organization();

        return organizationService.getOrganization(organizationId);
    }

    @RequestMapping(value = {"/add", "/update"}, method = RequestMethod.POST)
    public String updateOrganization(@ModelAttribute Organization organization, Model model) {

        int organizationId = organization.getId();

        if (organizationId > 0 && organizationService.getOrganization(organizationId) != null) {

            organizationService.updateOrganization(
                    organizationId,
                    organization.getCompanyName(),
                    organization.getYearOfIncorporation(),
                    organization.getPostalCode(),
                    organization.getEmployeeCount(),
                    organization.getSlogan()
            );

        } else {

            organizationService.addOrganization(
                    organization.getCompanyName(),
                    organization.getYearOfIncorporation(),
                    organization.getPostalCode(),
                    organization.getEmployeeCount(),
                    organization.getSlogan()
            );
        }

        model.addAttribute("organizations", organizationService.getOrganizations());

        return "organizations";
    }

    @GetMapping("/organizations")
    public String organizations(Model model) {

        organizationService.printOrganizations();

        model.addAttribute("organizations", organizationService.getOrganizations());

        return "organizations";
    }

    @GetMapping("/organizations/{id}")
    public String deleteOrganizations(Model model, @PathVariable int id) {

        organizationService.removeOrganization(id);

        model.addAttribute("organizations", organizationService.getOrganizations());

        return "organizations";
    }

    @ModelAttribute
    public void modelAttributeData1(Model model) {

        model.addAttribute("data1", "sample data1");

        model.addAttribute("years", Arrays.asList(1900, 1920, 1940, 1960, 1980, 2000, 2010));
    }

    @ModelAttribute(name = "data2")
    public String modelAttributeData2() {

        return "sample data2";
    }
}
