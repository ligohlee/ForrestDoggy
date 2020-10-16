package forrest.controller.han.calculation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import forrest.command.han.CalcCommand;
import forrest.service.han.calc.CalcService;

@Controller
public class calculationController {
	@Autowired
	CalcService calcService;
@RequestMapping("calculation")
public String main() {
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

}
