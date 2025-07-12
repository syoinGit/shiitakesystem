package portfolio.shiitake.system.service;

import java.util.List;
import org.springframework.stereotype.Service;
import portfolio.shiitake.system.data.staff.Staff;
import portfolio.shiitake.system.repository.ShiitakeRepository;

@Service
public class ShiitakeService {

  private final ShiitakeRepository repository;

  private ShiitakeService(ShiitakeRepository repository) {
    this.repository = repository;
  }

  public List<Staff> findAllStaff() {
    return repository.findAllStaff();
  }
}
