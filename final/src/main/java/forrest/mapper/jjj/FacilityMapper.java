package forrest.mapper.jjj;



import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jjj.FacilityDTO;
@Repository
@Component
public interface FacilityMapper {

	public void insertFacility(FacilityDTO dto);

	public List<FacilityDTO> selectFacilityAll();

	public FacilityDTO selectFacility(FacilityDTO fac);

	public void updateFacility(FacilityDTO fac);





}
