package forrest.mapper.jm;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jm.COrderDTO;
import forrest.domain.jm.StartEndPageDTO;

@Component
@Repository
public interface COrderMapper {
	public List<COrderDTO> getCOrderList(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getCOrderCount() throws Exception;
	public void corderInsert(COrderDTO dto) throws Exception;
	public void corderDelete(String cordNum) throws Exception;
}
