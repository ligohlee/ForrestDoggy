package forrest.service.jm.partner;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.jm.PartnerCommand;
import forrest.domain.jm.PartnerDTO;
import forrest.mapper.jm.PartnerMapper;

@Component
@Service
public class PartnerWriteService {
	@Autowired
	PartnerMapper partnerMapper;
	
	public String writePro(PartnerCommand partnerCommand, HttpServletRequest request) throws Exception{

		PartnerDTO dto = new PartnerDTO();
		dto.setPtNum(partnerCommand.getPtNum());
		dto.setPtName(partnerCommand.getPtName());
		dto.setPtPh(partnerCommand.getPtPh());
		dto.setPtEmail(partnerCommand.getPtEmail());
		dto.setPtAddr(partnerCommand.getPtAddr());
		dto.setPtType(partnerCommand.getPtType());
		dto.setPtBusinessNum(partnerCommand.getPtBusinessNum());
		dto.setPtAccount(partnerCommand.getPtAccount());
		dto.setPtComent(partnerCommand.getPtComent());
		dto.setPtCeo(partnerCommand.getPtCeo());
		
		String location = "";
		String filePath = "C:/Java/ForrestDoggy-master/final/src/main/resources/static/upload/partner";
		
		MultipartFile mf = partnerCommand.getReport();
		String img = mf.getOriginalFilename();
		File file = new File(filePath + "/" + img);
		try {
		   mf.transferTo(file);
		} catch (Exception e) {
		   // TODO: handle exception
		   location = "thymeleaf/backOfficePage/html/pt_manager/pt_form";
		   e.printStackTrace();
		}
		dto.setPtBusinessImage(img);
		partnerMapper.partnerInsert(dto);

		location = "redirect:/partner/partnerList";
		return location;
	} 
	
	
	
	
	
	
	
	
	
}
