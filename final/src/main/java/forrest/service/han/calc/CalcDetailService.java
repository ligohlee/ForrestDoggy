package forrest.service.han.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.CalcDTO;
import forrest.mapper.han.CalcMapper;

@Component
@Service
public class CalcDetailService {
	@Autowired
	CalcMapper calcMapper;
	public void detailview(Integer calcNum, Model model)throws Exception{
		CalcDTO dto = calcMapper.calcDetail(calcNum);
		model.addAttribute("dto", dto);
	}
	public void chartlistview(Integer workNum, Model model)throws Exception{
		CalcDTO dto = calcMapper.calcDetail(workNum);
		model.addAttribute("dto", dto);
	}
}