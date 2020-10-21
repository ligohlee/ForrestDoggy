package forrest.service.jm.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.GoodsDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.GoodsMapper;

@Service
@Component
public class GoodsOrderService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public String goodsOrder(String goodsNum, Model model) throws Exception{
	
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, goodsNum);
		GoodsDTO goodsDto = goodsMapper.getGoodsList(startEndPageDTO).get(0);
		
		model.addAttribute("dto", goodsDto);
	
	return "";
	}
	
}