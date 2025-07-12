package portfolio.shiitake.system.data.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {

  private String id;
  private String workerId;
  private String houseId;
  private TaskType taskType;
  private double harvestKg;
}