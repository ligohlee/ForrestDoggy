package forrest.service.han.holiday;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.han.HolidayCommand;
import forrest.domain.han.HolidayDTO;
import forrest.mapper.han.HolidayMapper;

@Component
@Service
public class HolidayService {
	@Autowired
	HolidayMapper mapper;
	public void insert(HolidayCommand command)throws Exception{
		HolidayDTO dto = new HolidayDTO();
		dto.setWorkNum(command.getWorkNum());
		dto.setHoliSort(command.getHoliSort());
		SimpleDateFormat trans = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = trans.parse(command.getHoliDate());
		} catch (Exception e) {
			System.out.println("Date Format Not Supported");
			e.printStackTrace();
			// TODO: handle exception
		}
		Timestamp ts = new Timestamp(date.getTime());
		dto.setHoliDate(ts);
		mapper.holiInsert(dto);
	}
}
