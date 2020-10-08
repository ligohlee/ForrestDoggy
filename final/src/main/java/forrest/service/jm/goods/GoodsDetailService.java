package forrest.service.jm.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.GoodsDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.GoodsMapper;

@Component
@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public void goodsDetail(String goodsNum, Model model) throws Exception{
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, goodsNum);
		GoodsDTO dto = goodsMapper.getGoodsList(startEndPageDTO).get(0);
		
		model.addAttribute("dto", dto);

	}

}
