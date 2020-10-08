package forrest.mapper.jm;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jm.PartnerDTO;
import forrest.domain.jm.StartEndPageDTO;

@Component
@Repository
public interface PartnerMapper {
	public List<PartnerDTO> getPartnerList(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getPartnerCount() throws Exception;
	public void partnerUpdate(PartnerDTO dto) throws Exception;
	public void partnerInsert(PartnerDTO dto) throws Exception;
	public void partnerDelete(String ptNum) throws Exception;
	public List<PartnerDTO> partnerSearch(StartEndPageDTO dto);
}
