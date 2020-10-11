package forrest.service.ligoh.evaluation;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.ligoh.EvaluationCommand;
import forrest.domain.ligoh.EvaluationDTO;
import forrest.mapper.ligoh.EvaluationMapper;

@Service
@Component
public class EvalWriteService {
	
	@Autowired
	EvaluationMapper evaluationMapper;
	
	
public String write(EvaluationCommand ec) throws Exception {
		 
		
		EvaluationDTO dto = new EvaluationDTO();
		
		  dto.setPtNum(ec.getPtNum());
		  dto.setEvalDesc(ec.getEvalDesc());
		  dto.setEvalIngr(ec.getEvalIngr());
		  dto.setEvalPrice(ec.getEvalPrice());
		  dto.setEvalResult(ec.getEvalResult());
		
		    String imgTotal ="";
			String location = "";
			
		
			String filePath = "C:\\Users\\hogil\\git\\ForrestDoggy\\final\\src\\main\\resources\\static\\upload\\evaluation";
			
			System.out.println("contract upload path : " + filePath);
		   
			
			for (MultipartFile mf : ec.getReport()) {
				String img =mf.getOriginalFilename().replaceAll(" ", "").replaceAll("-", "");
				
				
				imgTotal += img +"`";
				
				File file = new File(filePath + "/" +img);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					location = "thymeleaf/backOfficePage/html/esp_manager/evaluation/ev_regist";
					e.printStackTrace();
				}
				
			}
			
			dto.setIngrImg(imgTotal);
			
			
			evaluationMapper.evaluationInsert(dto);
			location = "redirect:/espback/evaluation/eval";
		
			
			return location;
		}

}
