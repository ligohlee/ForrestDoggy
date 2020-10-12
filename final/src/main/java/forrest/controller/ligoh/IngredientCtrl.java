package forrest.controller.ligoh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.ligoh.IngredientCommand;
import forrest.service.ligoh.ingredient.IngrDetailService;
import forrest.service.ligoh.ingredient.IngrListService;
import forrest.service.ligoh.ingredient.IngrSearchService;
import forrest.service.ligoh.ingredient.IngrWriteService;

@Controller
@RequestMapping("espback/ingredient")
public class IngredientCtrl {
	
	@ModelAttribute
	IngredientCommand setIngredientCommand() {
		return new IngredientCommand();
	};
	
	@Autowired
	IngrSearchService ingrSearchService;
	@Autowired
	IngrWriteService ingrWriteService;
	@Autowired
	IngrListService ingrListService;
	@Autowired
	IngrDetailService ingrDetailService;
	
	@RequestMapping(value = "ingrList")
	public String ingrList(@RequestParam(value="page", defaultValue="1")Integer page, Model model) throws Exception {
		ingrListService.ingrList(model, page);
		return "thymeleaf/backOfficePage/html/esp_manager/ingredient/ingr_list";
	}
	@RequestMapping(value = "ingrRegist", method = RequestMethod.GET)
	public String evRegist() {
		return "thymeleaf/backOfficePage/html/esp_manager/ingredient/ingr_regist";
	}
	
	@RequestMapping(value = "evalCheck")
	public String evalCheck() throws Exception {
		
		return "thymeleaf/backOfficePage/html/esp_manager/ingredient/evaluationCheck";
	}
	@RequestMapping(value = "evalSearch", method = RequestMethod.POST)
	public String evalSearch(@RequestParam(value="ingrName") String ingrName, Model model) throws Exception {
		ingrSearchService.ingrSel(ingrName, model);
		return "thymeleaf/backOfficePage/html/esp_manager/ingredient/evaluationCheck2";
	}
	@RequestMapping(value = "ingrInsert",method = RequestMethod.POST)
    public String ingrInsert(@Validated IngredientCommand ingredientCommand, 
   		 BindingResult result) throws Exception{
		 if (result.hasErrors()) {
			System.out.println("writePro");
			 return "thymeleaf/backOfficePage/html/esp_manager/ingredient/ingr_regist";
		}
		 String location = ingrWriteService.write(ingredientCommand);
			return location;
	}
	@RequestMapping(value = "ingrDetail", method = RequestMethod.GET)
	public String ingrDetail(@RequestParam(value="ingrNum") String ingrNum, Model model) throws Exception {
		ingrDetailService.ingrDetail(ingrNum, model);
		return "thymeleaf/backOfficePage/html/esp_manager/ingredient/ingr_detail";
	}

	

}
