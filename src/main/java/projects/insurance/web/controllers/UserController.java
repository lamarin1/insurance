package projects.insurance.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import projects.insurance.domain.bindingsModels.EditPolicyBidingModel;
import projects.insurance.domain.bindingsModels.UserLoginModel;
import projects.insurance.domain.bindingsModels.UserRegisterModel;
import projects.insurance.domain.entities.User;
import projects.insurance.domain.serviceModels.UserServiceModel;
import projects.insurance.service.ClientService;
import projects.insurance.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ClientService clientService;

    public UserController(UserService userService,
                          ModelMapper modelMapper,
                          ClientService clientService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.clientService = clientService;
    }

    @GetMapping("/login-form")
    public String login() {
        return "/login-form";
    }

    @PostMapping("/login-form")
    public String loginConfirm(@Valid @ModelAttribute("userLoginModel")
                                       UserLoginModel userLoginModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            return "redirect:login-form";
        }

        User user =
                this.userService.findByUsername(userLoginModel.getUsername());

        if (user == null ||
                !user.getPassword().equals(userLoginModel.getPassword())) {

            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login-form";
        }

        httpSession.setAttribute("user", user);

        return "redirect:/home";
    }

    @GetMapping("/register-form")
    public String register() {
        return "register-form";
    }

    @PostMapping("/register-form")
    public String registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel")
                                          UserRegisterModel userRegisterBindingModel,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword()
                        .equals(userRegisterBindingModel.getConfirmPassword())) {

            return "redirect:register-form";
        }

        this.userService.register(this.modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login-form";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
