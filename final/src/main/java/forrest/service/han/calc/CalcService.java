package forrest.service.han.calc;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.han.CalcCommand;
import forrest.domain.han.CalcDTO;
import forrest.mapper.han.CalcMapper;

@Component
@Service
public class CalcService {
	@Autowired
	CalcMapper calcMapper;
	public void insert(CalcCommand calcCommand)throws Exception{
		
		CalcDTO dto = new CalcDTO();
		dto.setCalcContent(calcCommand.getCalcContent());
		dto.setCalcNum(calcCommand.getCalcNum());
		dto.setCalcPrice(calcCommand.getCalcPrice());
		dto.setCalcTerm(calcCommand.getCalcTerm());
		dto.setPtNum(calcCommand.getPtNum());
		dto.setWorkNum(calcCommand.getWorkNum());
		SimpleDateFormat inputtFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = inputtFormat.parse(calcCommand.getCalcDate());
			
		} catch (Exception e) {
			System.out.println("Date Format Not Supported");
			e.printStackTrace();
			// TODO: handle exception
		}
		Timestamp ts = new Timestamp(date.getTime());
		dto.setCalcDate(ts);
		System.out.println(dto);
		calcMapper.calcInsert(dto);
		
	}
}
