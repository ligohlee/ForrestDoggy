package forrest.service.han.salary;

import java.io.File;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.han.SalCommand;
import forrest.domain.han.SalDTO;
import forrest.mapper.han.SalMapper;

@Component
@Service
public class SalServie {
	@Autowired
	SalMapper salMapper;
	public String salInsert(SalCommand command,HttpServletRequest  request)throws Exception{
		SalDTO dto = new SalDTO();
		dto.setSalCont(command.getSalCont());
		dto.setSalIncre(command.getSalIncre());
		dto.setSalNow(command.getSalNow());
		dto.setSalNum(command.getSalNum());
		dto.setWorkNum(command.getWorkNum());
		Timestamp salYear = new Timestamp(command.getSalYear().getTime());
		dto.setSalYear(salYear);
		System.out.println(salYear);
		String salImage = "`";
		String location = "";
		String path = "/static/upload/worker";
		String filePath = "C:/Users/Han/git/ForrestDoggy/final/src/main/resources/static/upload/worker";
				
		MultipartFile mf = command.getSalImage();
		String img = mf.getOriginalFilename();
		File file = new File(filePath + "/" + img);
		try {
			mf.transferTo(file);
		} catch (Exception e) {
			location = "thymeleaf/backOfficePage/html/review_manager/salary_write";
			e.printStackTrace();
		
		}	    
		dto.setSalImage(img);
	    salMapper.salInsert(dto);
	    location = "redirect:/worker/salaryList";
	    return location;
	
	}
}
