package forrest.service.han.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.domain.han.CalcDTO;
import forrest.mapper.han.CalcMapper;

@Component
@Service
public class CalcDeleteService {
	@Autowired
	CalcMapper mapper;
	public void calcdelpro(Integer calcNum)throws Exception{
		CalcDTO dto = new CalcDTO();
		dto.setCalcNum(calcNum);
		mapper.calDel(dto);
	}
}
