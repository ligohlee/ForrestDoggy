package forrest.controller.ligoh;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import forrest.command.ligoh.MorderCommand;
import forrest.service.ligoh.course.CourseListService;
import forrest.service.ligoh.menu.MakeABookService;
import forrest.service.ligoh.menu.MenuListService;
import forrest.service.ligoh.menu.MenuShowService;

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
	
	
	
	
	@RequestMapping(value = "menu")
	public String menuOpen(Model model) throws Exception{
		menuShowService.getMenuList(model);
		return "thymeleaf/frontPage/html/ligoh/espMenu";
	}
	@RequestMapping(value = "book")
	public String book(Model model) throws Exception{
		courseListService.getCourse(model);
		return "thymeleaf/frontPage/html/ligoh/espBook";
	}
	@RequestMapping(value ="regist")
	public String regist(MorderCommand mordCommand, HttpServletRequest request) throws Exception{
		makeABookService.makeBook(mordCommand, request);
		return "thymeleaf/frontPage/html/ligoh/espAdd";
	}
	@RequestMapping(value ="menuAdd")
	public String menuAdd() throws Exception{
		
		return "thymeleaf/frontPage/html/ligoh/espAdd";
	}

}
