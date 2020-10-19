package forrest.mapper.han;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.han.CalcDTO;

@Component
@Repository
public interface CalcMapper {
	public void calcInsert(CalcDTO calcDTO)throws Exception;
}
