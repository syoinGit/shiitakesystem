package portfolio.shiitake.system.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import portfolio.shiitake.system.data.house.HouseDto;
import portfolio.shiitake.system.data.staff.StaffDto;
import portfolio.shiitake.system.data.task.TaskDto;
import portfolio.shiitake.system.data.worklog.WorkLogDto;

@Mapper
public interface ShiitakeRepository {

  List<StaffDto> findAllStaff();

  List<HouseDto> findAllHouse();

  List<TaskDto> findAllTask();

  List<WorkLogDto> findAllWorklog();

}

