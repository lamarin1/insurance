package projects.insurance.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import projects.insurance.domain.entities.Client;
import projects.insurance.domain.viewModels.CarViewModel;
import projects.insurance.domain.viewModels.ClientViewModel;
import projects.insurance.service.CarService;
import projects.insurance.service.ClientService;
import projects.insurance.service.PolicyService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final PolicyService policyService;
    private final ClientService clientService;
    private final CarService carService;
    private final ModelMapper modelMapper;

    public HomeController(PolicyService policyService,
                          ClientService clientService,
                          CarService carService,
                          ModelMapper modelMapper) {
        this.policyService = policyService;
        this.clientService = clientService;
        this.carService = carService;
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
        }
        return model;
    }

    @GetMapping("fetch-page")
    public String fetchPage() {
        return "fetch-page";
    }

    @GetMapping(value = "/fetch/{var}")
    @ResponseBody
    public Object fetchData(@PathVariable String var) {

        if (var.equals("clients")) {
            return this.clientService.findAllClients()
                    .stream()
                    .map(c -> this.modelMapper.map(c, ClientViewModel.class))
                    .collect(Collectors.toList());
        }

        return this.carService.findAll()
                .stream()
                .map(car -> this.modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());
    }
}
