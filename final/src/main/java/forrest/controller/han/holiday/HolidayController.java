package forrest.controller.han.holiday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.han.HolidayCommand;
import forrest.service.han.holiday.HolidayDetailService;
import forrest.service.han.holiday.HolidayListService;
import forrest.service.han.holiday.HolidayService;

@Controller
public class HolidayController {
	@Autowired
	HolidayService holidayService;
	@Autowired
	HolidayListService holidayListService;
	@Autowired
	HolidayDetailService holidayDetailService;
	@RequestMapping("holiday")
	public String main(Model model)throws Exception {
		holidayListService.listview(model);
		return "thymeleaf/backOfficePage/html/holiday_manager/holiday_List";
	}
	@RequestMapping("holidayWrite")
	public String write() {
		return "thymeleaf//backOfficePage/html/holiday_manager/holiday_write";
	}
	@RequestMapping("holidaywritePro")
	public String writePro(HolidayCommand command)throws Exception {
		holidayService.insert(command);
		return "redirect:/holiday";
	}
	@RequestMapping("holidayDetail")
	public String detail(@RequestParam(value = "workNum")Integer workNum,Model model)throws Exception{
		holidayDetailService.detailview(workNum,model);
		return "thymeleaf/backOfficePage/html/holiday_manager/holidayDetail";
	}
	@RequestMapping("holidayModifyPro")
	public String modify(@RequestParam(value = "workNum")Integer workNum,Model model)throws Exception{
		holidayDetailService.detailview(workNum,model);
		return "thymeleaf/backOfficePage/html/holiday_manager/holiday_modify";
	}
}
