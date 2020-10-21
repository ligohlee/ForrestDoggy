package forrest.service.ligoh.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.controller.page.PageAction;
import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.MenuDTO;
import forrest.mapper.ligoh.MenuMapper;

@Service
@Component
public class MenuShowService {
	
	@Autowired
	MenuMapper menuMapper;

	public void getMenuList( Model model) throws Exception {
		
		
	    List<MenuDTO> soup = menuMapper.getSoup();
	    List<MenuDTO> salad = menuMapper.getSalad();
	    List<MenuDTO> main = menuMapper.getMainMenu();
	    List<MenuDTO> dessert = menuMapper.getDessert();
	    List<MenuDTO> drink = menuMapper.getDrink();
	    List<MenuDTO> dogMenu = menuMapper.getDogMenu();
	
	
	    model.addAttribute("soup", soup);
	    model.addAttribute("salad", salad);
	    model.addAttribute("main", main);
	    model.addAttribute("dessert", dessert);
	    model.addAttribute("drink", drink);
	    model.addAttribute("dogMenu", dogMenu);
	
	}

}
