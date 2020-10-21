package forrest.mapper.ligoh;

import forrest.domain.ligoh.MorderDTO;

public interface MorderMapper {

	public void firstRegist(MorderDTO dto) throws Exception;

	public MorderDTO getOrderNum(String id)throws Exception;

	public void updateReq(MorderDTO dto) throws Exception;

}
