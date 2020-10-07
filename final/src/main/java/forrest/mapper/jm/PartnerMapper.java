package forrest.mapper.jm;

import java.util.List;

import forrest.domain.jm.PartnerDTO;

public interface PartnerMapper {
	public List<PartnerDTO> getPartnerList(PartnerDTO dto) throws Exception;

}
