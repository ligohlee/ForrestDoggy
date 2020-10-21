package forrest.service.sy.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.sy.room.SelectOptionCommand;
import forrest.domain.sy.room.SelectOptionDTO;
import forrest.mapper.sy.room.SelectOptionMapper;


@Service
@Component
public class SelOptionService {
	
	@Autowired
	SelectOptionMapper mapper;
	
	public void insertSelOpt(SelectOptionCommand selCommand) {
		// TODO Auto-generated method stub
		
		SelectOptionDTO dto = new SelectOptionDTO();
		
		int a = selCommand.getSelName().length;
		for (int i = 0; i < a; i++) {
			if (selCommand.getSelQty()[i]!=0) {
				dto.setSelName(selCommand.getSelName()[i]);
				dto.setSelQty(selCommand.getSelQty()[i]);
				dto.setSelPrice(selCommand.getSelPrice()[i]);
				dto.setMemId(selCommand.getMemId());			
				System.out.println(dto);
				mapper.insertSelOpt(dto);
			}
			
			
		}
		
		
		
	}

	public void selectSelOpt(Model model, int roNum) {
		// TODO Auto-generated method stub
		List<SelectOptionDTO> selList = mapper.selectOptions(roNum);
		model.addAttribute("selOptsList", selList);
	}

}
