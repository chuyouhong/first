package first.service;

import java.util.List;

import first.view.Item;

public interface ItemService  {
	  
	  List<Item> getItemById(String id);
}
