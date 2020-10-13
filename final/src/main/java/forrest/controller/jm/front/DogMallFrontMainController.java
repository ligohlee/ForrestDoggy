package forrest.controller.jm.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsOrderService goodsOrderService;
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String dgmMain(@RequestParam(value="page", defaultValue="1") Integer page, Model model) throws Exception {
		goodsListService.goodsList(model, page);
		return "thymeleaf/frontPage/html/jm/dogMallMain";
	}
	@RequestMapping("goodsDetail/{goodsNum}")
	public String goodsDetail(@PathVariable(value="goodsNum") String goodsNum, Model model) throws Exception{
		goodsDetailService.goodsDetail(goodsNum, model);
		return "thymeleaf/frontPage/html/jm/fgoods_view";
	}
	@RequestMapping("goodsOrder/{goodsNum}")
	public String goodsOrder(@PathVariable(value="goodsNum") String goodsNum, Model model) throws Exception{
		goodsOrderService.goodsOrder(goodsNum, model);
		return "thymeleaf/frontPage/html/jm/fgoods_order";
	}
	
	
}
