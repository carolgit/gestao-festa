package com.algaworks.ana.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.algaworks.ana.sample.model.Convidado;
import com.algaworks.ana.sample.model.Usuario;
import com.algaworks.ana.sample.repository.Usuarios;
import com.algaworks.ana.sample.validator.UsuarioValidator;

@Controller
public class UserController {
	@Autowired
	private Usuarios userService;
	@Autowired
	private UsuarioValidator userValidator;
	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("userForm", new Usuario());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult, Model model){
		userValidator.validate(userForm, bindingResult);
		if(bindingResult.hasErrors()){
			return "registration";
		}
		userService.save(userForm);
		return "redirect:/welcome";
	}
	
	
	@GetMapping("/login")
	public String login(Model model, String error, String logout){
		if(error!=null){
			model.addAttribute("error", "Your username and password is invalid.");
		}
		if(logout!=null){
			model.addAttribute("message", "You have been logged out successfully.");
		}
		return "login";
	}
	
	@GetMapping(value={"/","/welcome"})
	public String welcome(Model model){
		return "welcome";
	}
}
