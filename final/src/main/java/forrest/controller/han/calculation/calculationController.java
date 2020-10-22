package forrest.controller.han.calculation;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.han.CalcCommand;
import forrest.service.han.calc.CalcDeleteService;
import forrest.service.han.calc.CalcDetailService;
import forrest.service.han.calc.CalcListService;
import forrest.service.han.calc.CalcModifyService;
import forrest.service.han.calc.CalcService;

@Controller
public class calculationController {
	@Autowired
	CalcService calcService;
	@Autowired
	CalcListService calcListService;
	@Autowired
	CalcDetailService calcDetailService;
	@Autowired
	CalcModifyService calcModifyService;
	@Autowired
	CalcDeleteService calcDeleteService;
@RequestMapping("calculation")
public String main(Model model)throws Exception {
	calcListService.calListview(model);
	return "thymeleaf/backOfficePage/html/calculation_manager/calculationList";
}
@RequestMapping("calculationWrite")
public String write() {
	return "thymeleaf/backOfficePage/html/calculation_manager/calculationWrite";
}
@RequestMapping("budgetwritePro")
public String writePro(CalcCommand command)throws Exception{
	calcService.insert(command);
	return "redirect:/calculation";
}
@RequestMapping("calcuDetail")
public String detail(@RequestParam(value = "calcNum")Integer calcNum, Model model)throws Exception {
	calcDetailService.detailview(calcNum,model);
	return "thymeleaf/backOfficePage/html/calculation_manager/calcuView";
}
@RequestMapping("calctmodify")
public String modeify(@RequestParam(value = "calcNum")Integer calcNum, Model model)throws Exception {
	calcDetailService.detailview(calcNum,model);
	return "thymeleaf/backOfficePage/html/calculation_manager/calctmodify";
}
@RequestMapping("calctmodifyPro")
public String modifyPro(CalcCommand command)throws Exception{
	calcModifyService.modifyPro(command);
	return "redirect:/calcuDetail?calcNum=" + command.getCalcNum();
}
@RequestMapping("calcDelPro")
public String delPro(@RequestParam(value = "calcNum")Integer calcNum)throws Exception {
	calcDeleteService.calcdelpro(calcNum);
	return "redirect:/calculation";
}
@RequestMapping("gogleChart1")
public String chart(@RequestParam(value = "workNum")Integer workNum,Model model)throws Exception {
	calcDetailService.chartlistview(workNum,model);
	return "thymeleaf/backOfficePage/html/calculation_manager/chartview";
}
}