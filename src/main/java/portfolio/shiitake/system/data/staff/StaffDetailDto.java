package portfolio.shiitake.system.data.staff;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import portfolio.shiitake.system.data.task.TaskDto;
import portfolio.shiitake.system.data.worklog.WorkLogDto;

@Getter
@Setter

public class StaffDetailDto {

  StaffDto staffDto;
  List<TaskDto> taskDto;
  List<WorkLogDto> workLogDto;

}
