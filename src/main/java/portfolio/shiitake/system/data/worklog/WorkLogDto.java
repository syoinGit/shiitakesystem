package portfolio.shiitake.system.data.worklog;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.config.Task;
import portfolio.shiitake.system.data.task.TaskDto;

@Getter
@Setter

public class WorkLogDto {

  private String id;
  private String staffId;
  private LocalDate date;
  private LocalDateTime clockIn;
  private LocalDateTime clockOut;
  private List<TaskDto> tasks;
  private double harvestKg;

}
