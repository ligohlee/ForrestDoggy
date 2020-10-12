package forrest.service.ligoh.mingr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.ligoh.MingrDTO;
import forrest.mapper.ligoh.MingrMapper;

@Service
@Component
public class MingrListService {
	@Autowired
	MingrMapper mingrMapper;

	public void mingrList(String menuNum, Model model) throws Exception {
		
		
	    List<MingrDTO> lists = mingrMapper.getMingrList(menuNum);
	    
	    model.addAttribute("lists", lists);
	   
	}

}
