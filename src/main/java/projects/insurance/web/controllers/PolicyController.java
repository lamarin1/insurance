package projects.insurance.web.controllers;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projects.insurance.domain.bindingsModels.AddPolicyBindingModel;
import projects.insurance.domain.bindingsModels.EditPolicyBidingModel;
import projects.insurance.error.PolicyAlreadyExistException;
import projects.insurance.service.PolicyService;
import projects.insurance.validation.PolicyAddValidator;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;
    private final PolicyAddValidator validator;

    public PolicyController(PolicyService policyService,
                            PolicyAddValidator validator) {
        this.policyService = policyService;
        this.validator = validator;

    }

    @GetMapping("/all")
    public ModelAndView allPolicies(ModelAndView model) {

        model.addObject("allpolicies",
                this.policyService.findAll());

        return model;
    }

    @GetMapping("/add-policy")
    public ModelAndView addPolicies(@ModelAttribute("addPolicyBindingModel")
                                            AddPolicyBindingModel addPolicyBindingModel,
                                    ModelAndView model) {

        model.setViewName("add-policy");

        return model;
    }


    @PostMapping("/add-policy")
    public ModelAndView addPolicy(@ModelAttribute("addPolicyBindingModel")
                                          AddPolicyBindingModel addPolicyBindingModel,
                                  BindingResult bindingResult,
                                  ModelAndView modelAndView) throws IOException {

        this.validator.validate(addPolicyBindingModel, bindingResult);

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("addPolicyBindingModel", addPolicyBindingModel);
            modelAndView.setViewName("add-policy");
            return modelAndView;
        }

        this.policyService.addPolicy(addPolicyBindingModel);
        modelAndView.setViewName("redirect:/home");

        return modelAndView;
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
    public String edit(@PathVariable String id,
                       @Valid @ModelAttribute("model")
                               EditPolicyBidingModel model) {



        this.policyService.editPolicy(id, model);

        return "redirect:/home";
    }

    @ExceptionHandler({PolicyAlreadyExistException.class})
    public ModelAndView handlePolicyExist(PolicyAlreadyExistException e){
        ModelAndView model = new ModelAndView("/error");
        model.addObject("message", e.getMessage());
        model.addObject("statusCode", e.getStatusCode());

        return model;
    }
}
