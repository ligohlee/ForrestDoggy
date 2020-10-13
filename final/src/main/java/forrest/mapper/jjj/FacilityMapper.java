package forrest.mapper.jjj;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jjj.FacilityDTO;
@Repository
@Component
public interface FacilityMapper {

	void insertFacility(FacilityDTO dto);

	List<FacilityDTO> selectFacilityAll();

	void updateFacility(FacilityDTO dto);

	void deleteFacility(int facilityNum);

	FacilityDTO selectFacility(FacilityDTO facilityNum1);



}
