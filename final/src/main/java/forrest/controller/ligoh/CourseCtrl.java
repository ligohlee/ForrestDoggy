package forrest.controller.ligoh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.ligoh.CourseCommand;
import forrest.service.ligoh.course.CourseDetailService;
import forrest.service.ligoh.course.CourseListService;
import forrest.service.ligoh.course.CourseWriteServie;
import forrest.service.ligoh.menu.MenuShowService;

@Controller
@RequestMapping("espback/course")
public class CourseCtrl {
	
	
	@Autowired
	CourseWriteServie courseWriteService;
	@Autowired
	CourseListService courseListService;
	@Autowired
	CourseDetailService courseDetailService;
	@Autowired
	MenuShowService menuShowService;
	
	@RequestMapping("list")
	public String courseOpen(Model model) throws Exception{
		courseListService.getCourse(model);
		return "thymeleaf/backOfficePage/html/esp_manager/course/course_list";
	
	}
	@RequestMapping("regist")
	public String courseRegist(Model model) throws Exception{
		menuShowService.getMenuList(model);
		return "thymeleaf/backOfficePage/html/esp_manager/course/course_regist";
		
	}
	@RequestMapping("insert")
	public String courseInsert(CourseCommand courseCommand) throws Exception{
		String location = courseWriteService.write(courseCommand);
		return location;
	}
	@RequestMapping("detail")
	public String courseView(@RequestParam(value = "courseNum")Integer courseNum, Model model) throws Exception{
		courseDetailService.getCourse(courseNum, model);
		return "thymeleaf/backOfficePage/html/esp_manager/course/course_detail";
	}

}
