package forrest.mapper.sy;

import forrest.domain.sy.PointDTO;

public interface PointMapper {
	PointDTO selectPointSum(String id);

	void insertPoint(PointDTO dto);

}
