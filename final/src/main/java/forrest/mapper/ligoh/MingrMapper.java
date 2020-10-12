package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.ligoh.MingrDTO;

public interface MingrMapper {

	public void mingrInsert(MingrDTO dto) throws Exception;

	public List<MingrDTO> getMingrList(String menuNum)throws Exception;

}
