package first.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import first.view.Item;

public interface ItemService extends JpaRepository<Item, Integer> {

	  @Query("SELECT i FROM Item i WHERE i.checked=true")
	  List<Item> findChecked();
	  
	  List<Item> getItemById(String id);
}
