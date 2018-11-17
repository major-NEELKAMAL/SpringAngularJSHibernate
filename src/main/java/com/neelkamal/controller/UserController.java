package com.neelkamal.controller;






import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



import com.neelkamal.model.User;
import com.neelkamal.service.UserService;



@RestController
public class UserController {

	private UserService userService;

	
	@Qualifier(value="userService")
	@Autowired
	public void setPersonService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("user");
	}
	
		
	@RequestMapping(value= "/savePerson", method = RequestMethod.POST)
	public Map<String,String> addPerson(@Valid @RequestBody User p,BindingResult bindingResult ){
		System.out.println(p);
		
		
		
		Map<String, String> messages = new HashMap<String, String>();		
		
		if (bindingResult.hasErrors()) {
			for(FieldError error : bindingResult.getFieldErrors()){
				messages.put( error.getField() , error.getDefaultMessage() );
							
			}
			
		}  else {
			
			if(p.getId() == 0){
			
				userService.addUser(p);
				messages.put("message", "user is added");
			 
			} else {
			
				userService.updateUser(p);
				messages.put("message", "user is updated");
			 
			}
			
		}
		return messages;
	}
	
	@RequestMapping(value= "/delete/{id}")
	public List<User> deletePerson(@PathVariable("id") int id){		
		
		userService.deleteUser(id);
		
		return listPersons();
	}
	
	@RequestMapping(value="/listPerson")
	public List<User> listPersons(){
				
		return userService.listUser();
	}
	
	@RequestMapping("/edit/{id}")
    public  User editPerson(@PathVariable("id") int id){
				
		return userService.getUserById(id);		
       
    }
}
