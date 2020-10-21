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
public class MenuListService {
	@Autowired
	MenuMapper menuMapper;

	public void getMenu(Integer page, Model model) throws Exception {
		
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * 10 + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, null);	
		
		
	    List<MenuDTO> lists = menuMapper.getMenu(dto);
	
	    int count = menuMapper.getMenuCount();
	
	    model.addAttribute("count", count);
	    model.addAttribute("lists", lists);
	    PageAction pageAction = new PageAction();
	    pageAction.page(model, count, limit, limitPage, page, "menuList");
	
		
	}

}
