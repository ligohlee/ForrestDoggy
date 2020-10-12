package forrest.service.han.salary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.SalDTO;
import forrest.mapper.han.SalMapper;

@Component
@Service
public class SalListServie {
	@Autowired
	SalMapper salMapper;
	public void Listview(Model model)throws Exception{
		List <SalDTO> lists = salMapper.Listview();
		model.addAttribute("lists", lists);
	}
}
