package forrest.service.jm.Inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.controller.page.PageAction;
import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.jm.WareDTO;
import forrest.mapper.jm.WareMapper;

@Service
@Component
public class WareListService {
	@Autowired
	WareMapper waremapper;
	public void wareList(Model model, Integer page) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * 10 + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, null);
		
		List<WareDTO> lists = waremapper.getWareList(dto);
		
		int count = waremapper.getWareCount();
		
		model.addAttribute("count", count);
		model.addAttribute("lists", lists);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "wareList");
		
	}
}
