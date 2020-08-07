package projects.insurance.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import projects.insurance.domain.bindingsModels.EditClientBindingModel;
import projects.insurance.repositories.ClientRepository;
import projects.insurance.service.ClientService;
import projects.insurance.service.PolicyService;

import javax.validation.Valid;

@Controller
public class ClientsController {

    private final ClientService clientService;
    private final PolicyService policyService;
    private final ClientRepository clientRepository;

    public ClientsController(ClientService clientService,
                             PolicyService policyService,
                             ClientRepository clientRepository) {
        this.clientService = clientService;
        this.policyService = policyService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/all-clients")
    public ModelAndView allClients(ModelAndView model) {

        model.addObject("allClients",
                this.clientService.findAllClients());

        return model;
    }

    @GetMapping("/all-clients-policies/{id}")
    public ModelAndView allClientsPolicies(ModelAndView model,
                                           @PathVariable Long id) {

        model.addObject("allClientsPolicies",
                this.policyService.findAllByClientId(id));

        model.setViewName("clients-policies");

        return model;
    }

    @GetMapping("/edit-client/{phoneNumber}")
    public ModelAndView editForm(@PathVariable String phoneNumber,
                                 ModelAndView model) {

        model.setViewName("edit-client");

        model.addObject("client",
                this.clientRepository.findByPhoneNumber(phoneNumber));

        System.out.println();

        return model;
    }

    @PostMapping("/edit-client/{phoneNumber}")
    public String edit(@PathVariable String phoneNumber,
                       @Valid @ModelAttribute("model")
                               EditClientBindingModel model) {

        this.clientService.editClient(phoneNumber, model);

        return "redirect:all-clients";
    }
}
