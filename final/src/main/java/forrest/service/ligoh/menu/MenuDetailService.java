package forrest.service.ligoh.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.MenuDTO;
import forrest.mapper.ligoh.MenuMapper;

@Service
@Component
public class MenuDetailService {
    @Autowired
    MenuMapper menuMapper; 

	public void menuDetail(String menuNum, Model model) {
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1l, 1l, null, menuNum);
        MenuDTO dto = menuMapper.getMenu(startEndPageDTO).get(0);
		
		model.addAttribute("detail", dto);
	}

}
