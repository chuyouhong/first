package first.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ItemDAO {

	@Select("select * from mytask2 where id =#{id}")
	List<Map> getItemById(@Param("id") String id);

}
