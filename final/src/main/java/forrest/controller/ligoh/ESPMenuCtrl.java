package forrest.controller.ligoh;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import forrest.command.ligoh.MorderCommand;
import forrest.command.sy.PaymentCommand;
import forrest.command.sy.PointCommand;
import forrest.service.ligoh.course.CourseListService;
import forrest.service.ligoh.menu.MenuListService;
import forrest.service.ligoh.menu.MenuShowService;
import forrest.service.ligoh.morder.BookShowService;
import forrest.service.ligoh.morder.MakeABookService;
import forrest.service.ligoh.morder.MenuPayService;
import forrest.service.ligoh.point.LpointService;
import forrest.service.sy.PaymentService;
import forrest.service.sy.PointService;

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
	@Autowired
	LpointService lpointService;
	@Autowired
	PointService pointService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	MenuPayService menuPayService;
	
	
	
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
		lpointService.pointShow(model, request);
		return "thymeleaf/frontPage/html/ligoh/espPay";
	}
	@RequestMapping(value ="pay")
	public String pay(PointCommand pointCommand, PaymentCommand paymentCommand, HttpServletRequest request, Model model) throws Exception{
		pointService.insertPoint(pointCommand);
		paymentService.insertPayment(paymentCommand);
		menuPayService.insertMenuPay(request);
		return "thymeleaf/frontPage/html/ligoh/espPayOk";
	}

}
