package first.service;

import java.util.List;

import first.model.Item;

public interface ItemService {

	public List<Item> getItemById(String id);
}
