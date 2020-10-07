package forrest.service.ligoh.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import forrest.domain.jm.PartnerDTO;
import forrest.mapper.jm.PartnerMapper;

public class WorkSearchService {
	@Autowired
	 PartnerMapper partnerMapper;
		public void ptSel(String ptName, Model model) throws Exception {
			PartnerDTO dto = new PartnerDTO();
			dto.setPtName(ptName);
			List<PartnerDTO> lists = partnerMapper.getPartnerList(dto);
		       System.out.println(ptName);
			model.addAttribute("lists", lists);
			
			
		}

}
