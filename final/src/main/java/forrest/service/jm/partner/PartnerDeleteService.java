package forrest.service.jm.partner;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.domain.jm.PartnerDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.PartnerMapper;

@Component
@Service
public class PartnerDeleteService {
	@Autowired
	PartnerMapper partnerMapper;
	public String partnerDelete(String ptNum, HttpServletRequest request) throws Exception {
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, ptNum);
		PartnerDTO dto = partnerMapper.getPartnerList(startEndPageDTO).get(0);
		partnerMapper.partnerDelete(ptNum);
		
		String path = "/static/upload/partner";
		String filePath = request.getServletContext().getRealPath(path);
		String img = dto.getPtBusinessImage();
		File file = new File(filePath + "/" + img);
		if(file.exists()) file.delete();
		
		String location = "redirect:/partner/partnerList";
		return location;
	}
	

}
