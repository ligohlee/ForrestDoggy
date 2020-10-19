package forrest.service.jm.Inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.GoodsDTO;
import forrest.mapper.jm.GoodsMapper;

@Service
@Component
public class PtGoodsListService {
	@Autowired
	GoodsMapper goodsmapper;
	public void ptGoodsList(String ptNum, Model model) throws Exception{
		
		List<GoodsDTO> lists = goodsmapper.getPtGoodsList(ptNum);
		
		model.addAttribute("lists", lists);
		
		
	}
}
