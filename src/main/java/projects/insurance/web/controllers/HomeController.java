package projects.insurance.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import projects.insurance.service.PolicyService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final PolicyService policyService;
    private final ModelMapper modelMapper;


    public HomeController(PolicyService policyService,
                          ModelMapper modelMapper) {
        this.policyService = policyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/home")
    public ModelAndView allPolicies(HttpSession httpSession,
                                    ModelAndView model) {

        if (httpSession.getAttribute("user") == null) {
            model.setViewName("index");
        } else {
            model.addObject("allpolicies",
                    this.policyService.findAll());

            System.out.println();

        }
        return model;
    }
}
