package forrest.service.jjj.facility;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.jjj.FacilityCommand;
import forrest.domain.jjj.FacilityDTO;
import forrest.mapper.jjj.FacilityMapper;

@Service
@Component
public class FacilityInsertService {
	
	@Autowired
	FacilityMapper facilityMapper;
	
	public void insertFacility(FacilityCommand facCommand) {
		FacilityDTO dto = new FacilityDTO(); 
		dto.setFacName(facCommand.getFacName());
		dto.setFacInfo(facCommand.getFacInfo());
		try {
			MultipartFile mf = facCommand.getFacImg();
			String originalFileName = mf.getOriginalFilename();
			String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-","")
					+ originalFileExtension;
			dto.setFacImg(store);
			String path = "C:\\Users\\goott\\git\\ForrestDoggy\\final\\src\\main\\resources\\static\\upload\\facility";
			File file = new File(path + "/" + store);
			mf.transferTo(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		facilityMapper.insertFacility(dto);
		
		
		
	}

}
