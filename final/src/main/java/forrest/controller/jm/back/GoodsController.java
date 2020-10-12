package forrest.controller.jm.back;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jm.GoodsCommand;
import forrest.service.jm.goods.GoodsDeleteService;
import forrest.service.jm.goods.GoodsDetailService;
import forrest.service.jm.goods.GoodsListService;
import forrest.service.jm.goods.GoodsWriteService;
import forrest.service.ligoh.contract.PtSearchService;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@Autowired
	PtSearchService ptSearchService;
	
	@ModelAttribute
	GoodsCommand setGoodsCommand() {
		return new GoodsCommand();
	}
	@RequestMapping("goodsList")
	public String goodsList(@RequestParam(value="page", defaultValue="1") Integer page, Model model) throws Exception {
		goodsListService.goodsList(model, page);
		return "thymeleaf/backOfficePage/html/dgm_manager/goods_list";
	}
	@RequestMapping("goodsWrite")
	public String goodsWrite() {
		return "thymeleaf/backOfficePage/html/dgm_manager/goods_form";
	}
	@RequestMapping(value = "partnerCheck")
	public String ptChk() {
		return "thymeleaf/backOfficePage/html/pt_manager/partnerCheck";
	}
	@RequestMapping(value = "ptSearch", method = RequestMethod.POST)
	public String ptSearch(@RequestParam(value="ptName") String ptName, Model model) throws Exception {
		ptSearchService.ptSel(ptName, model);
		return "thymeleaf/backOfficePage/html/pt_manager/partnerCheck2";
	}
	
	
	
	@RequestMapping(value="goodsWritePro")
	public String goodsWritePro(@Validated GoodsCommand goodsCommand, BindingResult result, HttpServletRequest request) throws Exception{
//		if(result.hasErrors()) {
//			System.out.println("Write Errors");
//			return "thymeleaf/backOfficePage/html/dgm_manager/partner_form";
//		}
		String location = goodsWriteService.writePro(goodsCommand, request);
		return location;
	}
	@RequestMapping("goodsDetail/{goodsNum}")
	public String goodsDetail(@PathVariable(value="goodsNum") String goodsNum, Model model) throws Exception{
		goodsDetailService.goodsDetail(goodsNum, model);
		return "thymeleaf/backOfficePage/html/dgm_manager/goods_view";
	}
	@RequestMapping("goodsModify/{goodsNum}")
	public String goodsModify(@PathVariable(value="goodsNum") String goodsNum, Model model) throws Exception{
		goodsDetailService.goodsDetail(goodsNum, model);
		return "thymeleaf/backOfficePage/html/dgm_manager/goods_modify";
	}
	@RequestMapping("goodsDel/{goodsNum}")
	public String goodsDel(@PathVariable(value="goodsNum") String goodsNum, HttpServletRequest request) throws Exception{
		String path = goodsDeleteService.goodsDelete(goodsNum, request);
		return path;
	}
	
	
	
	
	
	
	
}