package forrest.service.jm.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.controller.page.PageAction;
import forrest.domain.jm.GoodsDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.GoodsMapper;

@Component
@Service
public class CategoryListService {
	@Autowired
	GoodsMapper goodsmapper;
	
	public void categoryList(Model model, Integer page, String num) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * 10 + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, num);
		
		List<GoodsDTO> lists = goodsmapper.getGoodsCategoryList(dto);
		
		int count = goodsmapper.getGoodsCount();
		
		model.addAttribute("count", count);
		model.addAttribute("lists", lists);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "goodsList");
		
	}
}
