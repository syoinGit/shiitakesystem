package portfolio.shiitake.system.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import portfolio.shiitake.system.data.house.HouseDto;
import portfolio.shiitake.system.data.staff.StaffDto;
import portfolio.shiitake.system.data.task.Task;
import portfolio.shiitake.system.data.task.TaskDto;
import portfolio.shiitake.system.data.worklog.WorkLog;
import portfolio.shiitake.system.data.worklog.WorkLogDto;

@Mapper
public interface ShiitakeRepository {

  // スタッフの全件検索
  List<StaffDto> findAllStaff();

  // ハウスの全件検索
  List<HouseDto> findAllHouse();

  // タスクの全件検索
  List<TaskDto> findAllTask();

  // 勤務情報の全件検索
  List<WorkLogDto> findAllWorklog();

  // ログインコードからスタッフIDを検索
  String findStaffId(String loginCode);

  // ログインコードからスタッフ名を検索
  String findStaffName(String loginCode);

  // 出勤が重複しているかを検索
  int existsWorkLog(String id);

  // 出勤処理
  void clockIn(WorkLog workLog);

  // 退勤処理
  void clockOut(WorkLog workLog);

  // 業務の登録
  void insertTask(Task task);

}