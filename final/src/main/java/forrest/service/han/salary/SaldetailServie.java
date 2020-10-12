package forrest.service.han.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.SalDTO;
import forrest.mapper.han.SalMapper;

@Component
@Service
public class SaldetailServie {
	@Autowired
	SalMapper mapper;
	public void salDetail(Integer workNum, Model model)throws Exception{
		SalDTO dto = mapper.salDetailview(workNum);
		model.addAttribute("dto", dto);
	}
}
