package portfolio.shiitake.system.data.task;

import lombok.Getter;

@Getter
public enum TaskType {

  CARRY_BLOCKS("菌床運搬"),
  WATER_SOAKING("水浸け"),
  WATERING("水やり"),
  HARVEST("収穫"),
  DISPOSAL("廃棄処理");

  private final String label;

  TaskType(String label) {
    this.label = label;
  }
}
