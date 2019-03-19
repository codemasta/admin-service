package io.leraloro.adminservice.controller;


import io.leraloro.adminservice.model.User;
import io.leraloro.adminservice.service.RoleService;
import io.leraloro.adminservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@RequestMapping("/public")
@Controller
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    protected AuthenticationManager authenticationManager;


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView loginUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("public/login");
        return modelAndView;
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.addObject("roles", roleService.getAllRoles());
        modelAndView.setViewName("public/registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roles", roleService.getAllRoles());
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {

            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the email address");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("roles", roleService.getAllRoles());
            modelAndView.setViewName("public/registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("success", "Registration Successful, Login to Continue");
            modelAndView.setViewName("public/registration");

        }
        return modelAndView;
    }

}
