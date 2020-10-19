package forrest.mapper.jm;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.jm.WareDTO;

@Component
@Repository
public interface WareMapper {
	public List<WareDTO> getWareList(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getWareCount() throws Exception;
	public void wareInsert(WareDTO dto) throws Exception;
	public void wareDelete(String wareNum) throws Exception;
}
