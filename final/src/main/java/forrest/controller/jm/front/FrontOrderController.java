package forrest.controller.jm.front;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import forrest.command.jm.GOrderCommand;
import forrest.service.jm.order.GoodsOrderService;
import forrest.service.jm.order.GoodsOrderWriteService;

@Controller
@RequestMapping("dgm")
public class FrontOrderController {
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	GoodsOrderWriteService goodsOrderWriteService;
	
	@ModelAttribute
	GOrderCommand setGOrderCommand() {
		return new GOrderCommand();
	}
	
	@RequestMapping("goodsOrder")
	public String goodsOrder(GOrderCommand gOrderCommand, Model model, HttpSession session) throws Exception{
		String path = goodsOrderService.goodsOrder(gOrderCommand, model, session);
		return path;
	}
	@RequestMapping(value="goodsOrderWrite")
	public String goodsOrderWritePro(@Validated GOrderCommand gOrderCommand, BindingResult result, HttpSession session, Model model) throws Exception{
		String path = goodsOrderWriteService.writePro(gOrderCommand, session, model);
		return path;
	}
	

}
