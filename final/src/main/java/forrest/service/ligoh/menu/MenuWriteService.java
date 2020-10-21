package forrest.service.ligoh.menu;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.ligoh.MenuCommand;
import forrest.domain.ligoh.MenuDTO;
import forrest.mapper.ligoh.MenuMapper;


@Service
@Component
public class MenuWriteService {
	
	@Autowired
	MenuMapper menuMapper;

	public String write(MenuCommand mc) throws Exception {
 
		
		MenuDTO dto = new MenuDTO();
		
		 dto.setAllergy(mc.getAllergy());
         dto.setMenuIntro(mc.getMenuIntro());
         dto.setMenuName(mc.getMenuName());
         dto.setMenuPrice(mc.getMenuPrice());
         dto.setRecipe(mc.getRecipe());
         dto.setMenuType(mc.getMenuType());
         dto.setMenuSeq(mc.getMenuSeq());
         
			String location = "";
		
			String filePath = "C:\\Users\\hogil\\git\\ForrestDoggy\\final\\src\\main\\resources\\static\\upload\\menu";
			
			System.out.println("contract upload path : " + filePath);

			MultipartFile mf = mc.getReport();
			
		
				String img =mf.getOriginalFilename();
			
				File file = new File(filePath + "/" +img);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					location = "thymeleaf/backOfficePage/html/esp_manager/menu/menu_regist";
					e.printStackTrace();
				}
				
			
		
			dto.setMenuImage(img);
			
			
			menuMapper.menuInsert(dto);
			location = "redirect:/espback/menu/menuList";
			
			return location;
	}

}
