package first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import first.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	  
	  @RequestMapping(value = "/test/", method = RequestMethod.GET)
	  public String get(@RequestParam(value="name")String name) {
		  System.out.println(name);
		  itemService.getItemById(name);
		  return "hahahhahahahhahaha!!!!!!"+name;
	  }

}
