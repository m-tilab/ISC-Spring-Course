package org.example.controller;

import org.example.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping("/organizations")
    public String organizations(Model model) {

        model.addAttribute("organizations", organizationService.getOrganizations());

        return "organizations";
    }

    @RequestMapping("/organizations/cleanup")
    public String organizationCleanup() {

        organizationService.cleanup();

        return "organizations";
    }

    @RequestMapping("/organizations/create-sample-data")
    public String createSampleData(Model model) {

        organizationService.createSeedData();

        model.addAttribute("organizations", organizationService.getOrganizations());

        return "organizations";
    }


}
