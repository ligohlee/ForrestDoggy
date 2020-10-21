package forrest.controller.ligoh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.ligoh.MenuCommand;
import forrest.command.ligoh.MingrCommand;
import forrest.service.ligoh.menu.MISearchService;
import forrest.service.ligoh.menu.MenuDetailService;
import forrest.service.ligoh.menu.MenuListService;
import forrest.service.ligoh.menu.MenuWriteService;
import forrest.service.ligoh.mingr.MingrListService;
import forrest.service.ligoh.mingr.MingrWriteService;

@Controller
@RequestMapping("espback/menu")
public class MenuCtrl {
	
	@Autowired
	MenuDetailService menuDetailService;
	@Autowired
	MenuWriteService menuWriteService;
	@Autowired
	MenuListService menuListService;
	@Autowired
	MISearchService mISearchService;
	@Autowired
	MingrWriteService mingrWriteService;
	@Autowired
	MingrListService mingrListService;

	@RequestMapping(value = "menuList")
	public String menuList(@RequestParam(value="page", defaultValue="1")Integer page, Model model) throws Exception {
		menuListService.getMenu(page, model);
		return "thymeleaf/backOfficePage/html/esp_manager/menu/menu_list";
	}
	@RequestMapping(value = "menuRegist", method = RequestMethod.GET)
	public String menuRegist() {
		return "thymeleaf/backOfficePage/html/esp_manager/menu/menu_regist";
	}
	@RequestMapping(value = "menuInsert", method = RequestMethod.POST)
	public String menuInsert(MenuCommand menuCommand) throws Exception {
		String location = menuWriteService.write(menuCommand);
		return location;
	}
	@RequestMapping(value = "menuDetail", method = RequestMethod.GET)
	public String menuDetail(@RequestParam(value="menuNum") String menuNum, Model model) throws Exception {
		menuDetailService.menuDetail(menuNum, model);
		return "thymeleaf/backOfficePage/html/esp_manager/menu/menu_detail";
	}
	@RequestMapping(value = "menuIngr", method = RequestMethod.GET)
	public String menuIngr(@RequestParam(value="menuNum") String menuNum, Model model) throws Exception {
		model.addAttribute("menuNum", menuNum);
		return "thymeleaf/backOfficePage/html/esp_manager/menu/ingrCheck";
	}
	@RequestMapping(value = "ingrSearch", method = RequestMethod.POST)
	public String menuSearch(@RequestParam(value="menuNum") String menuNum,
			@RequestParam(value="ingrName") String ingrName, Model model) throws Exception {
		mISearchService.ingrSearch(ingrName,model, menuNum);
		return "thymeleaf/backOfficePage/html/esp_manager/menu/ingrCheck2";
	}
	@RequestMapping(value = "menuIngr2", method = RequestMethod.GET)
	public String menuIngr2(@RequestParam(value="menuNum") String menuNum,
			@RequestParam(value="ingrNum") String ingrNum, Model model) throws Exception {
		mISearchService.ingrSearch2(ingrNum,model, menuNum);
		return "thymeleaf/backOfficePage/html/esp_manager/menu/ingrCheck3";
	}
	@RequestMapping(value = "mingrRegist", method = RequestMethod.POST)
	public String mingrRegist(MingrCommand mingrCommand, Model model) throws Exception {
		mingrWriteService.mingrWrite(mingrCommand,model);
		return "thymeleaf/backOfficePage/html/esp_manager/menu/ingrCheck";
	}
	@RequestMapping(value = "seeIngr")
	public String seeIngr(@RequestParam(value="menuNum") String menuNum, Model model) throws Exception {
		mingrListService.mingrList(menuNum, model);
		return "thymeleaf/backOfficePage/html/esp_manager/menu/see_ingr";
	}

}
