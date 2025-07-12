package portfolio.shiitake.system.data.house;

import lombok.Getter;

@Getter
public enum Priority {

  LOW("優先度:低"),
  MEDIUM("優先度:中"),
  HIGH("優先度:高");

  private final String label;

  Priority(String label) {
    this.label = label;
  }

}
