package forrest.controller.jm.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.service.jm.goods.GoodsDetailService;
import forrest.service.jm.goods.GoodsListService;
import forrest.service.jm.order.GoodsOrderService;

@Controller
@RequestMapping("dogmall")
public class DogMallFrontMainController {
	@Autowired
	GoodsListService goodsListService;
		
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String dgmMain(@RequestParam(value="page", defaultValue="1") Integer page, Model model) throws Exception {
		goodsListService.goodsList(model, page);
		return "thymeleaf/frontPage/html/jm/dogMallMain";
	}
	
	
	
	
}
