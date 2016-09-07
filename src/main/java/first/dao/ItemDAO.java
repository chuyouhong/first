package first.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import first.view.Item;

public interface ItemDAO {

	@Select("select * from item where id =#{id}")
	List<Item> getItemById(@Param("id") String id);

}
