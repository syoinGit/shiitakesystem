package portfolio.shiitake.system.data.house;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HouseDto {

  private String id;
  private String name;
  private LocalDateTime lastHarvestDate;
  private HarvestStatus status;
  private Priority priority;


}
