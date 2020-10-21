package forrest.service.han.holiday;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.HolidayDTO;
import forrest.mapper.han.HolidayMapper;

@Component
@Service
public class HolidayListService {
	@Autowired
	HolidayMapper mapper;
	public void listview(Model model)throws Exception{
		List<HolidayDTO> lists  = mapper.Listview();
		model.addAttribute("lists", lists);
	}
}
