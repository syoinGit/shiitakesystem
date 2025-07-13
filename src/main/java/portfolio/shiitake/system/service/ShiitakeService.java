package portfolio.shiitake.system.service;

import java.util.List;
import org.springframework.stereotype.Service;
import portfolio.shiitake.system.data.staff.StaffDetailDto;
import portfolio.shiitake.system.repository.ShiitakeRepository;
import portfolio.shiitake.system.service.converter.ShiitakeConverter;

@Service
public class ShiitakeService {

  private final ShiitakeRepository repository;
  private final ShiitakeConverter converter;

  private ShiitakeService(ShiitakeRepository repository, ShiitakeConverter converter) {
    this.repository = repository;
    this.converter = converter;
  }

  // 全件検索
  public List<StaffDetailDto> findAllStaff() {
    return converter.convertStaff(repository.findAllStaff(), repository.findAllTask(),
        repository.findAllWorklog());
  }
}
