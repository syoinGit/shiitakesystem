package portfolio.shiitake.system.data.house;

import lombok.Getter;

@Getter
public enum HarvestStatus {

  UNUSED("未使用"),
  CARRY_BLOCKS("菌床運搬"),
  WATER_SOAKING("水浸け"),
  WATERING("水やり"),
  HARVEST("収穫"),
  DISPOSAL("廃棄処理");

  private final String label;

  HarvestStatus(String label) {
    this.label = label;
  }
}