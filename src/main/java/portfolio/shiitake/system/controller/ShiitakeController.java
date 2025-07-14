package portfolio.shiitake.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.shiitake.system.data.staff.StaffDetailDto;
import portfolio.shiitake.system.data.task.TaskForm;
import portfolio.shiitake.system.service.ShiitakeService;

@RestController
public class ShiitakeController {

  private final ShiitakeService service;

  private ShiitakeController(ShiitakeService service) {
    this.service = service;
  }


  @Operation(summary = "スタッフ情報の全件検索", description = "スタッフ情報の全件検索を行います")
  @GetMapping("/allStaff")
  private List<StaffDetailDto> findAllStaff() {
    return service.findAllStaff();
  }

  @Operation(summary = "出勤処理", description = "スタッフの勤務情報を新たに作成します")
  @PutMapping("/clockIn")
  private ResponseEntity<String> clockInStaff(String loginCode) {
    service.clockInStaff(loginCode);
    String staffName = service.searchStaff(loginCode);
    return ResponseEntity.ok(staffName + "さん 出勤しました");
  }

  @Operation(summary = "退勤処理", description = "スタッフの勤務情報にデータを追加します")
  @PutMapping("/clockOut")
  private ResponseEntity<String> clockOutStaff(String loginCode) {
    service.clockOutStaff(loginCode);
    String staffName = service.searchStaff(loginCode);
    return ResponseEntity.ok(staffName + "さん 退勤しました");
  }

  @Operation(summary = "業務の追加", description = "スタッフの業務を追加します")
  @PutMapping("/registerTask")
  public ResponseEntity<String> registerTask(@RequestBody TaskForm taskForm) {
    service.registerTask(taskForm);
    return ResponseEntity.ok("業務の登録が完了しました");
  }


}