package forrest.controller.jm.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.service.jm.goods.CategoryListService;
import forrest.service.jm.goods.GoodsDetailService;
import forrest.service.jm.goods.GoodsListService;
import forrest.service.jm.order.GoodsOrderService;

@Controller
@RequestMapping("dgm")
public class FrontGoodsController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	CategoryListService categoryListService;
		
	@RequestMapping(value = "goodsCategory")
	public String categoryList(@RequestParam(value="page", defaultValue="1") Integer page, Model model
							, @RequestParam(value="num") String num) throws Exception {
		categoryListService.categoryList(model, page, num);
		return "thymeleaf/frontPage/html/jm/category_list";
	}
	@RequestMapping("goodsDetail/{goodsNum}")
	public String goodsDetail(@PathVariable(value="goodsNum") String goodsNum, Model model) throws Exception{
		goodsDetailService.goodsDetail(goodsNum, model);
		return "thymeleaf/frontPage/html/jm/goods_view";
	}
	
	
}
