package io.leraloro.adminservice.controller;

import io.leraloro.adminservice.model.Facility;
import io.leraloro.adminservice.service.FacilityService;
import io.leraloro.adminservice.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/home")
@Controller
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private SubmissionService submissionService;

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("facilities", facilityService.recentFacilities());
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }

    @RequestMapping(value = {"/facility/add"}, method = RequestMethod.GET)
    public ModelAndView getFacility() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("facility", new Facility());
        modelAndView.setViewName("facility/facility");
        return modelAndView;
    }

    @RequestMapping(value = {"/facility/add"}, method = RequestMethod.POST)
    public ModelAndView saveNewFacility(@ModelAttribute("facility") @Valid Facility facility, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("facility/facility");


        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", "Error during facility addition.");
        } else {
            facilityService.saveFacility(facility);
            modelAndView.addObject("success", "Facility saved Successfully");
        }

        return modelAndView;
    }

    @RequestMapping(value = {"/facility/indexed"}, method = RequestMethod.GET)
    public ModelAndView getIndexedFacilities() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("facilities", facilityService.getIndexedFacilities());
        modelAndView.setViewName("facility/indexed");
        return modelAndView;
    }


    @RequestMapping(value = {"/facility/submitted"}, method = RequestMethod.GET)
    public ModelAndView getSubmittedFacilities() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("facilities", submissionService.getSubmittedFacilities());
        modelAndView.setViewName("facility/submitted");
        return modelAndView;
    }
}
