package portfolio.shiitake.system.data.worklog;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.config.Task;

@Getter
@Setter
public class WorkLog {

  private String id;
  private String staffId;
  private LocalDate date;
  private LocalDateTime clockIn;
  private LocalDateTime clockOut;
  private List<Task> tasks;
  private double harvestKg;
}