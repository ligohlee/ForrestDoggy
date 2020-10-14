package forrest.service.jm.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.COrderDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.COrderMapper;

@Service
@Component
public class COrderDetailService {
	@Autowired
	COrderMapper cOderMapper;
	
	public void corderDetail(String ptNum, Model model) throws Exception{
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, ptNum);
		COrderDTO dto = cOderMapper.getCOrderList(startEndPageDTO).get(0);
		
		model.addAttribute("dto", dto);
		
		
	}
}
