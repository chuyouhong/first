package first.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import first.dao.ItemDAO;
import first.model.Item;
import first.service.ItemService;

@Component
public class ItemserviceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO;

	@Override
	public List<Item> getItemById(String id) {

		return itemDAO.getItemById(id);
	}

}
