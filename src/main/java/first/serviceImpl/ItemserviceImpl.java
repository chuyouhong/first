package first.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first.dao.ItemDAO;
import first.service.ItemService;
import first.view.Item;

@Service
public class ItemserviceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO;

	@Override
	public List<Item> getItemById(String id) {

		return itemDAO.getItemById(id);
	}

}
