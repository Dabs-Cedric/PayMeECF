package com.example.PayMe.controller;

import com.example.PayMe.model.User;
import com.example.PayMe.service.DarkAdminService;
import com.example.PayMe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DarkAdminController {

    @Autowired
    DarkAdminService darkAdminService;


    @RequestMapping("/darkadmin")
    public String darkAdminPage (Model model, RedirectAttributes ra){
        model.addAttribute("darkAdmin", darkAdminService.getAllUser());
        return "darkAdminUsers";
		/*String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		if(role.contains("ROLE_ADMIN")){
			model.addAttribute("users", userService.getAllUser());
			return "adminUsers" ;
		}else{
			ra.addFlashAttribute("error", "vous n'etes pas admin");
			return "home";
		}*/
    }

    @PostMapping("/addCash")
    public String addContact(@RequestParam(value = "name") String name, Model model) {
        User user = darkAdminService.getConnectedUser();
        User userToAdd =darkAdminService.getUserByName(name);
        if(userToAdd!=null) {
            if(!user.getListContacts().contains(userToAdd) && user!=userToAdd) {
                user.getListContacts().add(userToAdd);
                darkAdminService.save(user);
            };
        }
        model.addAttribute("listContact", user.getListContacts());

        return "darkAdminUsers";
    }

}
