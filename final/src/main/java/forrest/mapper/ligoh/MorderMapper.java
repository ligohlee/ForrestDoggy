package forrest.mapper.ligoh;

import forrest.domain.ligoh.MenuListDTO;
import forrest.domain.ligoh.MorderDTO;

public interface MorderMapper {

	public void firstRegist(MorderDTO dto) throws Exception;

	public void secondRegist(MenuListDTO mdto)throws Exception;
	public MorderDTO getOrderNum(String id)throws Exception;

}
