package com.laptrinhweb.run.controller.home;

import com.laptrinhweb.run.entity.UserEntity;
import com.laptrinhweb.run.converter.UserConverter;
import com.laptrinhweb.run.repository.UserRepository;
import com.laptrinhweb.run.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;


    public ModelAndView showNewList(@RequestParam(value = "page",required = false) int page, @RequestParam(value = "limit",required = false) int limit, HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    @GetMapping(value = {"/","/trang-chu"})
    public ModelAndView homePage(){
        ModelAndView mav = new ModelAndView("views/home/home");
        UserEntity userEntity = userRepository.findOneByUsernameAndStatus("admin",1);
        System.out.println(userConverter.toDto(userEntity).toString());
        return mav;
    }

    @GetMapping(value ="/login")
    public ModelAndView loginPage(Principal principal){
        ModelAndView mav = new ModelAndView("views/login/loginPage");
        if(principal !=null){
            User userLogined = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(userLogined);
            System.out.println(userInfo);
            mav.setViewName("userInforPage");

        }
        return mav;
    }
    @Secured(value={"ADMIN"})
    @GetMapping(value = "/username")
    public ModelAndView username(){
        ModelAndView mav = new ModelAndView("userInforPage");
        return mav;
    }

}
