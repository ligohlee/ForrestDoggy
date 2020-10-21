package forrest.controller.jm.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import forrest.service.jm.order.GoodsOrderService;

@Controller
@RequestMapping("dgm")
public class FrontOrderController {
	@Autowired
	GoodsOrderService goodsOrderService;
	
	@RequestMapping("goodsOrder/{goodsNum}")
	public String goodsOrder(@PathVariable(value="goodsNum") String goodsNum, Model model) throws Exception{
		goodsOrderService.goodsOrder(goodsNum, model);
		return "thymeleaf/frontPage/html/jm/goods_order";
	}
	
	

}
