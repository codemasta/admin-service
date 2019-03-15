package io.leraloro.mainservice.controller;

import io.leraloro.mainservice.model.Facility;
import io.leraloro.mainservice.model.Submission;
import io.leraloro.mainservice.service.FacilityService;
import io.leraloro.mainservice.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @RequestMapping(value = {"/submit/facility/add"}, method = RequestMethod.GET)
    public ModelAndView getFacility() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("submission", new Submission());
        modelAndView.setViewName("submission/submission");
        return modelAndView;
    }

    @RequestMapping(value =  {"/submit/facility/add"}, method = RequestMethod.POST)
    public ModelAndView savePendingSubmission(@ModelAttribute("submission") @Valid Submission submission, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("submission/submission");

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", "Error during facility submission.");
        } else {
            submissionService.saveSubmission(submission);
            modelAndView.addObject("success", "Facility submitted successfully.");
        }

        return modelAndView;
    }
}
