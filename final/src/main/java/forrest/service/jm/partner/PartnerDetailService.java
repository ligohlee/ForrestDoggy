package forrest.service.jm.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.PartnerDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.PartnerMapper;

@Component
@Service
public class PartnerDetailService {
	@Autowired
	PartnerMapper partnerMapper;
	
	public void partnerDetail(String ptNum, Model model) throws Exception{
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, ptNum);
		PartnerDTO dto = partnerMapper.getPartnerList(startEndPageDTO).get(0);
		
		model.addAttribute("dto", dto);
		
		
	}
	
	
	
	
}
