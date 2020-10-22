package forrest.controller.ligoh;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import forrest.command.ligoh.MorderCommand;
import forrest.service.ligoh.course.CourseListService;
import forrest.service.ligoh.menu.MenuListService;
import forrest.service.ligoh.menu.MenuShowService;
import forrest.service.ligoh.morder.BookShowService;
import forrest.service.ligoh.morder.MakeABookService;

@Controller
@RequestMapping("esp")
public class ESPMenuCtrl {
	
	@Autowired
	MenuListService menuListService;
	@Autowired
	MenuShowService menuShowService;
	@Autowired
	MakeABookService makeABookService;
	@Autowired
	CourseListService courseListService;
	@Autowired
	BookShowService bookShowService;
	
	
	@RequestMapping(value = "menu")
	public String menuOpen(Model model) throws Exception{
		menuShowService.getMenuList(model);
		return "thymeleaf/frontPage/html/ligoh/espMenu";
	}
	@RequestMapping(value = "book")
	public String book(Model model) throws Exception{
		courseListService.getCourse(model);
		menuShowService.getMenuList(model);
		return "thymeleaf/frontPage/html/ligoh/espBook";
	}
	
	
	@RequestMapping(value ="regist")
	public String regist2(MorderCommand mordCommand,  Model model, HttpServletRequest request) throws Exception{
		makeABookService.firstRegist(mordCommand, request);
		makeABookService.secondRegist(mordCommand, request);
		bookShowService.sendInfo(model, request);
		return "thymeleaf/frontPage/html/ligoh/espPay";
	}
	@RequestMapping(value ="pay")
	public String pay(MorderCommand mordCommand, HttpServletRequest request, Model model) throws Exception{
		
		model.addAttribute("courses", mordCommand.getCourseNum());
		return "thymeleaf/frontPage/html/ligoh/espPayOk";
	}

}
