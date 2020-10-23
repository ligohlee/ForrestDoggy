package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.MorderDTO;

public interface MorderMapper {

	public void firstRegist(MorderDTO dto) throws Exception;

	public MorderDTO getOrderNum(String id)throws Exception;

	public MorderDTO getDateReq(Integer mordNum)throws Exception;

	public List<MorderDTO> getOrderList(StartEndPageDTO dto)throws Exception;

	public int getOrderCount()throws Exception;


}
