package portfolio.shiitake.system.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolio.shiitake.system.data.staff.Staff;
import portfolio.shiitake.system.service.ShiitakeService;

@RestController
public class ShiitakeController {

  private final ShiitakeService service;

  private ShiitakeController(ShiitakeService service) {
    this.service = service;
  }

  @GetMapping("/allStaff")
  private List<Staff> findAllStaff() {
    return service.findAllStaff();
  }
}
