package forrest.mapper.jm;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jm.COrderDTO;
import forrest.domain.jm.StartEndPageDTO;

@Component
@Repository
public interface COrderMapper {
	public List<COrderDTO> getCordList(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getCordCount() throws Exception;
	public void cordInsert(COrderDTO dto) throws Exception;
	public void cordDelete(String cordNum) throws Exception;
}
