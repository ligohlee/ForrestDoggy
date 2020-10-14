package forrest.controller.jm.back;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.jm.COrderCommand;
import forrest.service.jm.Inventory.COrderDetailService;
import forrest.service.jm.Inventory.COrderListService;
import forrest.service.jm.Inventory.COrderWriteProService;
import forrest.service.jm.Inventory.COrderWriteService;
import forrest.service.jm.Inventory.InventoryListService;

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
	
	
	
	
	
}
