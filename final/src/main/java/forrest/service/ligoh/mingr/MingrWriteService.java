package forrest.service.ligoh.mingr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.ligoh.MingrCommand;
import forrest.domain.ligoh.MingrDTO;
import forrest.mapper.ligoh.MingrMapper;


@Service
@Component
public class MingrWriteService {
    @Autowired
    MingrMapper mingrMapper;
	public void mingrWrite(MingrCommand mc, Model model) throws Exception {
		MingrDTO dto =  new MingrDTO();
		dto.setIngrNum(mc.getIngrNum());
		dto.setMenuNum(mc.getMenuNum());
		dto.setMenuIngrQty(mc.getMenuIngrQty());
		
		mingrMapper.mingrInsert(dto);
	
		
	}

}
