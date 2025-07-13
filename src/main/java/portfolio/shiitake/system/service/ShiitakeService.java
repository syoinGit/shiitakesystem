package portfolio.shiitake.system.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import portfolio.shiitake.system.data.staff.StaffDetailDto;
import portfolio.shiitake.system.data.worklog.WorkLog;
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

  // 出勤
  public void clockInStaff(String loginCode) {
    String staffId = repository.findStaffId(loginCode);
    String workLogId = staffId + LocalDate.now();
    // 出勤状態の検証
    if (repository.existsWorkLog(workLogId) > 0) {
      throw new IllegalStateException("すでに出勤しています");
    }
    //　出勤していない場合情報を追加して出勤
    WorkLog workLog = new WorkLog();
    workLog.setId(workLogId);
    workLog.setStaffId(staffId);
    workLog.setDate(LocalDate.now());
    workLog.setClockIn(LocalDateTime.now());

    repository.clockIn(workLog);
  }

  // ログインコードから名前を検索
  public String searchStaff(String loginCode) {
    return repository.findStaffName(loginCode);

  }


}
