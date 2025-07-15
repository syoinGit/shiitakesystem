package portfolio.shiitake.system.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import portfolio.shiitake.system.data.staff.StaffDetailDto;
import portfolio.shiitake.system.data.staff.StaffDto;
import portfolio.shiitake.system.data.task.TaskDto;
import portfolio.shiitake.system.data.worklog.WorkLog;
import portfolio.shiitake.system.data.worklog.WorkLogDto;
import portfolio.shiitake.system.repository.ShiitakeRepository;
import portfolio.shiitake.system.service.converter.ShiitakeConverter;

@ExtendWith(MockitoExtension.class)
class ShiitakeServiceTest {

  private static final Logger log = LogManager.getLogger(ShiitakeServiceTest.class);

  @Mock
  private ShiitakeRepository repository;

  @Mock
  private ShiitakeConverter converter;

  @Test
  void 従業員情報の全件検索_リポジトリとコンバーターが呼び出されていること() {
    ShiitakeService sut = new ShiitakeService(repository, converter);

    List<StaffDto> staffDto = new ArrayList<>();
    List<WorkLogDto> workLogDto = new ArrayList<>();
    List<TaskDto> taskDto = new ArrayList<>();
    List<StaffDetailDto> convert = new ArrayList<>();

    when(repository.findAllStaff()).thenReturn(staffDto);
    when(repository.findAllWorklog()).thenReturn(workLogDto);
    when(repository.findAllTask()).thenReturn(taskDto);
    when(converter.convertStaff(staffDto, workLogDto, taskDto)).thenReturn(convert);

    List<StaffDetailDto> actual = sut.findAllStaff();

    verify(repository, Mockito.times(1)).findAllStaff();
    verify(repository, Mockito.times(1)).findAllWorklog();
    verify(repository, Mockito.times(1)).findAllTask();

    verify(converter, Mockito.times(1)).convertStaff(staffDto, workLogDto, taskDto);

    assertNotNull(actual);
    assertEquals(actual, convert);

  }

  @Test
  void 従業員の出勤処理_リポジトリが呼び出されているか確認() {
    ShiitakeService sut = new ShiitakeService(repository, converter);
    String loginCode = "staff-001";
    String staffId = "staff-001";

    WorkLog workLog = getWorklog();
    workLog.setClockIn(LocalDateTime.now());
    workLog.setDate(LocalDate.now());

    when(repository.findStaffId(loginCode)).thenReturn(staffId);
    sut.clockInStaff(loginCode);

    verify(repository, Mockito.times(1)).clockIn(workLog);

  }




  private WorkLog getWorklog() {
    WorkLog workLog = new WorkLog();
    workLog.setId("log-001");
    workLog.setStaffId("staff-001");
    return workLog;
  }

}