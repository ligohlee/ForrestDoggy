package forrest.service.han.holiday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.HolidayDTO;
import forrest.mapper.han.HolidayMapper;

@Component
@Service
public class HolidayDetailService {
	@Autowired
	HolidayMapper mapper;
	public void detailview(Integer workNum,Model model)throws Exception{
		HolidayDTO dto = mapper.viewDetail(workNum);
		model.addAttribute("dto", dto);
	}
}
