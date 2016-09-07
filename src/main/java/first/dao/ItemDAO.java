package first.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import first.view.Item;

public interface ItemDAO {
	
	@Query("select * from mytask2 where id =#{id}")
	List<Item> getItemById(@Param("id")String id);

}
