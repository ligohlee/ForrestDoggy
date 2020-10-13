package forrest.service.jm.partner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.controller.page.PageAction;
import forrest.domain.jm.PartnerDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.PartnerMapper;

@Component
@Service
public class PartnerListService {
	@Autowired
	PartnerMapper partnerMapper;
	public void partnerList(Model model, Integer page) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page - 1) * 10 + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, null);
		
		List<PartnerDTO> lists = partnerMapper.getPartnerList(dto);
		
		int count = partnerMapper.getPartnerCount();
		
		model.addAttribute("count", count);
		model.addAttribute("lists", lists);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "partnerList");
		
	}
	public void partnerList(Model model, Integer page) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
