package com.neelkamal.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.neelkamal.model.User;
import com.neelkamal.service.UserService;



@Controller
public class UserController {

	private UserService userService;

	
	@Qualifier(value="userService")
	@Autowired
	public void setPersonService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "user";
	}
	
	@RequestMapping(value = "/addPerson", method = RequestMethod.GET)
	public ModelAndView addPersonPage(Model model) {
		return new ModelAndView("addPerson", "person", new User());
	}
	
	
	@RequestMapping(value= "/savePerson", method = RequestMethod.POST)
	public @ResponseBody JsonObject addPerson(@RequestBody User p){
		System.out.println(p);
		
		JsonObject json = new JsonObject();
		
		if(p.getId() == 0){
			
			userService.addUser(p);
			json.addProperty("message", "user is added");
			 
		} else {
			
			userService.updateUser(p);
			json.addProperty("message", "user is updated");
			 
		}
		return json;
	}
	
	@RequestMapping(value= "/delete/{id}")
	public String deletePerson(@PathVariable("id") int id){
		
		
		userService.deleteUser(id);
		
		return "redirect:/listPerson";
	}
	
	@RequestMapping(value="/listPerson")
	public @ResponseBody String listPersons(){
		
		Gson gsonBuilder = new GsonBuilder().create();
		 
		String jsonFromJavaList = gsonBuilder.toJson(userService.listUser());
		
		return jsonFromJavaList;
	}
	
	@RequestMapping("/edit/{id}")
    public  @ResponseBody String editPerson(@PathVariable("id") int id){
		
				
		Gson gsonBuilder = new GsonBuilder().create();
		 
		String jsonFromJavaList = gsonBuilder.toJson(userService.getUserById(id));
		
		return jsonFromJavaList;
		
       
    }
}
