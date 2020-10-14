package forrest.service.jm.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.GoodsDTO;
import forrest.domain.jm.PartnerDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.GoodsMapper;
import forrest.mapper.jm.PartnerMapper;

@Component
@Service
public class COrderWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	PartnerMapper partnerMapper;
	
	public void cOrderWrite(String goodsNum, Model model) throws Exception{
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, goodsNum);
		GoodsDTO goodsdto = goodsMapper.getGoodsList(startEndPageDTO).get(0);
		PartnerDTO ptdto = partnerMapper.getPartnerList(startEndPageDTO).get(0);
		model.addAttribute("goodsdto", goodsdto);
		model.addAttribute("ptdto", ptdto);
		
		
	}
	
}
