package com.example.PayMe.controller;

import com.example.PayMe.model.User;
import com.example.PayMe.service.DarkAdminService;
import com.example.PayMe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class DarkAdminController {

    @Autowired
    private DarkAdminService darkAdminService;


    @GetMapping("/admin")
    public String getUsersAdmin(Model model, RedirectAttributes ra){
        model.addAttribute("users", darkAdminService.getAllUser());
        return "adminUsers";
		/*String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		if(role.contains("ROLE_ADMIN")){
			model.addAttribute("users", userService.getAllUser());
			return "adminUsers" ;
		}else{
			ra.addFlashAttribute("error", "vous n'etes pas admin");
			return "home";
		}*/


    }

}
