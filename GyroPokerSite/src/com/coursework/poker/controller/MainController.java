package com.coursework.poker.controller;

import com.coursework.poker.entity.AccountEntity;
import com.coursework.poker.entity.CountryEntity;
import com.coursework.poker.service.AccountService;
import com.coursework.poker.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class MainController {

    private static String LOGIN_ERROR = "There is no such user or password is wrong";
    @Resource
    AccountService accountService;

    @Resource
    CountryService countryService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String getLoginPage(Model model) {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String doLogin(Model model, String email, String password) {
        AccountEntity user = accountService.login(email, password);
        if (user == null) {
            model.addAttribute("error", LOGIN_ERROR);
            return "login";
        } else {
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String getSignUpPage(Model model) {
        model.addAttribute("countries", countryService.getAll());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(Model model, AccountEntity accountEntity, String countryId) {
        CountryEntity country = countryService.getById(Integer.parseInt(countryId));
        accountEntity.setCountry(country);
        accountService.createAccount(accountEntity);
        return "redirect:/";
    }

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String getHomePage(Model model) {
        return "index";
    }

}
