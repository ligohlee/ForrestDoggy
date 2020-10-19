package forrest.controller.jm.back;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jm.COrderCommand;
import forrest.command.jm.WareCommand;
import forrest.service.jm.Inventory.COrderDetailService;
import forrest.service.jm.Inventory.COrderListService;
import forrest.service.jm.Inventory.COrderWriteProService;
import forrest.service.jm.Inventory.COrderWriteService;
import forrest.service.jm.Inventory.InventoryListService;
import forrest.service.jm.Inventory.PtGoodsListService;
import forrest.service.jm.Inventory.WareListService;
import forrest.service.jm.Inventory.WareWriteProService;
import forrest.service.ligoh.contract.PtSearchService;

@Controller
@RequestMapping("inventory")
public class InventoryController {
	@Autowired
	InventoryListService inventoryListService;
	@Autowired
	COrderWriteService cOrderWriteService;
	@Autowired
	COrderWriteProService cOrderWriteProService;
	@Autowired
	COrderListService cOrderListService;
	@Autowired
	COrderDetailService cOrderDetailService;
	@Autowired
	WareListService wareListService;
	@Autowired
	PtSearchService ptSearchService;
	@Autowired
	PtGoodsListService ptGoodsListService;
	@Autowired
	WareWriteProService wareWriteProService;
	
	
	@RequestMapping("inventoryList")
	public String inventoryList(@RequestParam(value="page", defaultValue="1") Integer page, Model model) throws Exception {
		inventoryListService.inventoryList(model, page);
		return "thymeleaf/backOfficePage/html/dgm_manager/inventory_list";
	}
	@RequestMapping("corderForm/{goodsNum}")
	public String cordWrite(@PathVariable(value="goodsNum") String goodsNum, Model model) throws Exception{
		cOrderWriteService.cOrderWrite(goodsNum, model);
		return "thymeleaf/backOfficePage/html/dgm_manager/corder_form";
	}
	@RequestMapping("corderWritePro")
	public String corderWritePro(@Validated COrderCommand corderCommand, BindingResult result, HttpServletRequest request) throws Exception{
		String location = cOrderWriteProService.writePro(corderCommand, request);
		return location;
	}
	@RequestMapping("corderList")
	public String corderList(@RequestParam(value="page", defaultValue="1") Integer page, Model model) throws Exception {
		cOrderListService.corderList(model, page);
		return "thymeleaf/backOfficePage/html/dgm_manager/cord_list";
	}
	@RequestMapping("corderView/{cordNum}")
	public String corderDetail(@PathVariable(value="cordNum") String cordNum, Model model) throws Exception{
		cOrderDetailService.corderDetail(cordNum, model);
		return "thymeleaf/backOfficePage/html/dgm_manager/corder_view";
	}
	@RequestMapping("wareList")
	public String wareList(@RequestParam(value="page", defaultValue="1") Integer page, Model model) throws Exception {
		wareListService.wareList(model, page);
		return "thymeleaf/backOfficePage/html/dgm_manager/ware_list";
	}
	@RequestMapping("wareWrite")
	public String wareWrite() {
		return "thymeleaf/backOfficePage/html/dgm_manager/ware_form";
	}
	@RequestMapping(value = "ptCheck")
	public String ptChk() {
		return "thymeleaf/backOfficePage/html/pt_manager/partnerCheck";
	}
	@RequestMapping(value = "ptSearch", method = RequestMethod.POST)
	public String ptSearch(@RequestParam(value="ptName") String ptName, Model model) throws Exception {
		ptSearchService.ptSel(ptName, model);
		return "thymeleaf/backOfficePage/html/pt_manager/partnerCheck2";
	}
	@RequestMapping(value = "goodsSelect")
	public String ptGoodsListSelect(@RequestParam(value="ptNum") String ptNum, Model model) throws Exception {
		ptGoodsListService.ptGoodsList(ptNum, model);
		return "thymeleaf/backOfficePage/html/dgm_manager/see_goods";
	}
	@RequestMapping("wareWritePro")
	public String wareWritePro(@Validated WareCommand wareCommand, BindingResult result) throws Exception{
		String location = wareWriteProService.writePro(wareCommand);
		return location;
	}
	
	
	
}
