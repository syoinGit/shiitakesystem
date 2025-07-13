package portfolio.shiitake.system.data.task;

import lombok.Getter;
import lombok.Setter;
import portfolio.shiitake.system.data.worklog.WorkLogDto;

@Getter
@Setter

public class TaskDto {

  private String id;
  private String workerId;
  private String houseId;
  private String workLogId;
  private TaskType taskType;

}