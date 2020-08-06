package projects.insurance.web.controllers;

import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projects.insurance.domain.bindingsModels.AddPolicyBindingModel;
import projects.insurance.domain.bindingsModels.EditPolicyBidingModel;
import projects.insurance.service.PolicyService;

import javax.validation.Valid;

@Controller
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;
    private final ModelMapper modelMapper;


    public PolicyController(PolicyService policyService,
                            ModelMapper modelMapper) {
        this.policyService = policyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ModelAndView allPolicies(ModelAndView model) {

        model.addObject("allpolicies",
                this.policyService.findAll());

        return model;
    }

    @GetMapping("/add-policy")
    public ModelAndView addPolicies(ModelAndView model) {

        model.setViewName("add-policy");

        return model;
    }

    @PostMapping("/add-policy")
    public String addPolicy(@Valid @ModelAttribute("addPolicyBindingModel")
                                    AddPolicyBindingModel addPolicyBindingModel,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:add-policy";
        }

        this.policyService.addPolicy(addPolicyBindingModel);

        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {

        this.policyService.deletePolicyByNumber(id);

        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable String id,
                                 ModelAndView model) {

        model.setViewName("edit-form");

        model.addObject("policy",
                this.policyService.findPolicyByNumber(id));

        return model;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable String id, @Valid @ModelAttribute("model")
            EditPolicyBidingModel model) {

        this.policyService.editPolicy(id, model);

        return "redirect:/home";
    }
}
