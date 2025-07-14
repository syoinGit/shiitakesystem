package portfolio.shiitake.system.service.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import portfolio.shiitake.system.data.staff.StaffDetailDto;
import portfolio.shiitake.system.data.staff.StaffDto;
import portfolio.shiitake.system.data.task.TaskDto;
import portfolio.shiitake.system.data.worklog.WorkLogDto;

@Component
public class ShiitakeConverter {

  public List<StaffDetailDto> convertStaff(List<StaffDto> staffDtos, List<TaskDto> taskDtos,
      List<WorkLogDto> workLogDtos) {
    List<StaffDetailDto> staffDetailDtos = new ArrayList<>();

    for (StaffDto staffDto : staffDtos) {
      StaffDetailDto staffDetailDto = new StaffDetailDto();
      staffDetailDto.setStaffDto(staffDto);

      List<TaskDto> matchTask = taskDtos.stream()
          .filter(s -> s.getStaffId().equals(staffDetailDto.getStaffDto().getId()))
          .toList();
      staffDetailDto.setTaskDto(matchTask);

      List<WorkLogDto> matchWorkLog = workLogDtos.stream()
          .filter(s -> s.getStaffId().equals(staffDetailDto.getStaffDto().getId()))
          .toList();

      for (WorkLogDto log : matchWorkLog) {
        List<TaskDto> relatedTasks = taskDtos.stream()
            .filter(s -> log.getId().equals(s.getWorkLogId()))
            .toList();
        log.setTasks(relatedTasks);
      }
      staffDetailDto.setWorkLogDto(matchWorkLog);
      staffDetailDtos.add(staffDetailDto);
    }

    return staffDetailDtos;
  }
}

