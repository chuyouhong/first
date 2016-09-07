package first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import first.service.ItemService;
import first.view.Item;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@ResponseBody
	@RequestMapping(value = "/test/", method = RequestMethod.GET)
	public String get(@RequestParam(value = "name") String name) {
		System.out.println(name);
		List<Item> list = itemService.getItemById(name);
		return "hahahhahahahhahaha!!!!!!" + list;
	}

}
