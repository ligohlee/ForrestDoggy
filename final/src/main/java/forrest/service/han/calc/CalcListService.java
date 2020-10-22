package forrest.service.han.calc;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.CalcDTO;
import forrest.domain.han.ChartDTO;
import forrest.mapper.han.CalcMapper;

@Component
@Service
public class CalcListService {
	@Autowired
	CalcMapper calcMapper;
	public void calListview(Model model)throws Exception{
		List <CalcDTO> lists = calcMapper.callistView();
		model.addAttribute("lists", lists);
	}
	
	public void chartview(Model model, HttpServletResponse response)throws Exception{
		List<ChartDTO> chart = calcMapper.chartview1();
		String chartList = "[['월', '매출']";
		for(int i = 0 ; i < chart.size() ;i++) {
			chartList += ",['"+chart.get(i).getCalcDate()+"',"+chart.get(i).getCalcPrice()+"]";
		}
		chartList +="]";
		System.out.println(chartList);
		model.addAttribute("chartList", chartList);
	}
	
	
}
