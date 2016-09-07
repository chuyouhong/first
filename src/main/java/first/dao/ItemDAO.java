package first.dao;

import java.util.List;

import first.view.Item;

public interface ItemDAO {
	
	@select()
	List<Item> getItemById(String id);

}
