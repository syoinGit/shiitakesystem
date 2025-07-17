package portfolio.shiitake.system.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import portfolio.shiitake.system.data.staff.StaffDetailDto;
import portfolio.shiitake.system.data.staff.StaffDto;
import portfolio.shiitake.system.repository.ShiitakeRepository;
import portfolio.shiitake.system.service.ShiitakeService;

@WebMvcTest(ShiitakeController.class)
class ShiitakeControllerTest {

  @Autowired
  MockMvc mockMvc;

  @SuppressWarnings("removal")
  @MockBean
  private ShiitakeService service;

  @SuppressWarnings("removal")
  @MockBean
  private ShiitakeRepository repository;

  @Test
  void 従業員情報の全件検索ができて_空のリストが検索できること() throws Exception {
    mockMvc.perform(get("/allStaff")).andExpect(status().isOk())
        .andExpect(content().json("[]"));
    verify(service, times(1)).findAllStaff();
  }

  @Test
  void 従業員情報の単一検索_従業員から従業員情報が検索できること() throws Exception {
    StaffDto staffDto = new StaffDto();
    staffDto.setName("佐藤花子");
    staffDto.setLoginCode("staff-001");

    StaffDetailDto staffDetailDto = new StaffDetailDto();
    staffDetailDto.setStaffDto(staffDto);
  }


}