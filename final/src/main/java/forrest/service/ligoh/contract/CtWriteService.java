package forrest.service.ligoh.contract;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.ligoh.ContractCommand;
import forrest.domain.ligoh.ContractDTO;
import forrest.mapper.ligoh.ContractMapper;

@Service
@Component
public class CtWriteService {
	@Autowired
	ContractMapper contractMapper;

	public String write(ContractCommand cc, HttpServletRequest request) throws Exception {
		 
		
		ContractDTO dto = new ContractDTO();
		
		  dto.setCtContent(cc.getCtContent());
		  dto.setPtNum(cc.getPtNum());
		  dto.setWorkNum(cc.getWorkNum());
		  dto.setCtPtPh(cc.getCtPtPh());
		  dto.setCtPtName(cc.getCtPtName());
		  dto.setCtTerm(cc.getCtTerm());
		
	
		   		   
		    String imgTotal ="";
			String location = "";
			
		
			String path ="/static/upload/contract";
			String filePath = request.getServletContext().getRealPath(path);
			
			System.out.println("contract upload path : " + filePath);
		   
			
			for (MultipartFile mf : cc.getReport()) {
				String img =mf.getOriginalFilename().replaceAll(" ", "").replaceAll("-", "");
				
				
				imgTotal += img +"`";
				
				File file = new File(filePath + "/" +img);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					location = "thymeleaf/backOfficePage/html/pt_manager/ct_regist";
					e.printStackTrace();
				}
				
			}
			dto.setCtImage(imgTotal);
			
			contractMapper.contractInsert(dto);
			location = "redirect:/ptback/foodContract";
			
		
			
			
			return location;
		}
		
		

}
