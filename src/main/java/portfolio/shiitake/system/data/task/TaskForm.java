package portfolio.shiitake.system.data.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskForm {

  private String loginCode;
  private String houseId;
  private String taskType;
  private double harvestKg;
}