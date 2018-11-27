package com.example.demo.validator;
import com.example.demo.dataobject.ShiroEntity.ShiroUser;
import com.example.demo.form.RegisterForm;
import com.example.demo.service.jpaService.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class RegisterValidator implements Validator {
	@Autowired
	ShiroService shiroService;
	public boolean supports(Class<?> clazz){
		//注意User不能导错
		return RegisterForm.class.isAssignableFrom(clazz);
	}
	public void validate(Object target,Errors errors){
//		ValidationUtils.rejectIfEmpty(errors, "username", null,"用户名不能为空的");
//		ValidationUtils.rejectIfEmpty(errors, "password", null,"密码不能为空的");
		RegisterForm registerForm =(RegisterForm)target;
 		ShiroUser shiroUser=null;
		System.out.println(registerForm.getUsername());
		shiroUser = shiroService.findFirstByUsername(registerForm.getUsername());
		if(shiroUser!=null){
			errors.rejectValue("username", null, "用户名已存在");
		}

	}

}
