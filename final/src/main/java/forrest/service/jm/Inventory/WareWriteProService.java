package forrest.service.jm.Inventory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jm.WareCommand;
import forrest.domain.jm.WareDTO;
import forrest.mapper.jm.WareMapper;

@Component
@Service
public class WareWriteProService {
	@Autowired
	WareMapper wareMapper;
	
	public String writePro(WareCommand wareCommand) throws Exception {
		
		WareDTO dto = new WareDTO();
		dto.setWareNum(wareCommand.getWareNum());
		dto.setWareQty(wareCommand.getWareQty());
		dto.setWareRegist(wareCommand.getWareRegist());
		dto.setGoodsNum(wareCommand.getGoodsNum());
		
		System.out.println(dto.getWareQty());
		
		wareMapper.wareInsert(dto);
		
		return "redirect:/inventory/wareList";
	}
}
