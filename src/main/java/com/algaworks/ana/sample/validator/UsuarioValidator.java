package com.algaworks.ana.sample.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.algaworks.ana.sample.model.Usuario;
import com.algaworks.ana.sample.repository.Usuarios;

@Component
public class UsuarioValidator implements Validator {
	@Autowired
	private Usuarios userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Usuario.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors erros) {
		Usuario user = (Usuario) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(erros, "username", "NotEmpty");
		if(user.getUsername().length() < 6 || user.getUsername().length() >32){
			erros.rejectValue("username", "Size.userForm.username");
		}
		if(userService.findByUsername(user.getUsername())!= null){
			erros.rejectValue("username", "Duplicate.userForm.username");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(erros, "username", "NotEmpty");
		if(user.getPassword().length() < 8 || user.getPassword().length()>32){
			erros.rejectValue("password", "Size.userForm.password");
		}
		if(!user.getPasswordConfirm().equals(user.getPassword())){
			erros.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}

}
