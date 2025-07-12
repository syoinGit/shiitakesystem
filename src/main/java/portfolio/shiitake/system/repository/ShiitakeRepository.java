package portfolio.shiitake.system.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import portfolio.shiitake.system.data.staff.Staff;

@Mapper
public interface ShiitakeRepository {

  List<Staff> findAllStaff();
  void insertStaff(Staff staff);
}