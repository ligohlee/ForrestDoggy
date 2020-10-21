package forrest.mapper.han;

import java.util.List;

import forrest.domain.han.HolidayDTO;

public interface HolidayMapper {
	public void holiInsert(HolidayDTO dto)throws Exception;
	public List<HolidayDTO> Listview();
	public HolidayDTO viewDetail(Integer workNum)throws Exception;
}
