package forrest.mapper.han;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.han.CalcDTO;
import forrest.domain.han.ChartDTO;

@Component
@Repository
public interface CalcMapper {
	public void calcInsert(CalcDTO calcDTO)throws Exception;
	public List <CalcDTO> callistView();
	public CalcDTO calcDetail(Integer calcNum)throws Exception;
	public void calaModify(CalcDTO calcDTO)throws Exception;
	public void calDel(CalcDTO calcDTO)throws Exception;
	public List <ChartDTO> chartview1();
}
