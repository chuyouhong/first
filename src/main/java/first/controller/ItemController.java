package first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import first.model.Item;
import first.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@ResponseBody
	@RequestMapping(value = "/test/", method = RequestMethod.GET)
	public String get(@RequestParam(value = "id") String id) {
		System.out.println(id);
		List<Item> list = itemService.getItemById(id);
		
		return "hahahhahahahhahaha!!!!!!" + list.get(0).getName();
	}

}
