//package com.itf.schulung.springboot.fullstack.model;
//
//import java.util.Set;
//
//import javax.validation.metadata.BeanDescriptor;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//import com.itf.schulung.springboot.fullstack.model.Login;
//import com.itf.schulung.springboot.fullstack.services.LogginService;
//import org.springframework.stereotype.Component;
//
//
//public class LoginValidator implements Validator {
//	private LogginService loggingService;
//
//	@Override
//	public boolean supports(Class<?> aClass) {
//		return Login.class.equals(aClass);
//	}
//
//	@Override
//	public void validate(Object o, Errors errors) {
//		Login user = (Login) o;
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
//		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
//			errors.rejectValue("username", "Size.userForm.username");
//		}
//		if (loggingService.findByUsername(user.getUsername()) != null) {
//			errors.rejectValue("username", "Duplicate.userForm.username");
//		}
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
//		if (user.getPasswort().length() < 4 || user.getPasswort().length() > 32) {
//			errors.rejectValue("password", "Size.userForm.password");
//		}
//
//		if (!user.getPasswort().equals(user.getPasswort())) {
//			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
//		}
//	}
//}
