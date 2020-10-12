package forrest.service.jm.partner;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.maven.shared.invoker.SystemOutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.jm.PartnerCommand;
import forrest.domain.jm.PartnerDTO;
import forrest.mapper.jm.PartnerMapper;

@Component
@Service
@Transactional
public class PartnerModifyService {
	@Autowired
	PartnerMapper partnerMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String partnerModify(PartnerCommand partnerCommand, HttpServletRequest request) throws Exception{
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
		String name = System.getProperty("user.name");
		String path = "C:\\Users\\"+name+"\\git\\ForrestDoggy\\final\\src\\main\\resources\\static\\upload\\partner";
		String filePath = request.getServletContext().getRealPath(path);
		
		MultipartFile mf = partnerCommand.getReport();
		String img = mf.getOriginalFilename();
		File file = new File(filePath + "/" + img);
		try {
		   mf.transferTo(file);
		} catch (Exception e) {
		   // TODO: handle exception
		   location = "thymeleaf/backOfficePage/html/pt_manager/partner_form";
		   e.printStackTrace();
		}
		dto.setPtBusinessImage(img);
		partnerMapper.partnerUpdate(dto);
		
		return "partnerDetail/"+dto.getPtNum();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
