package forrest.mapper.han;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.han.SalDTO;

@Component
@Repository
public interface SalMapper {
	public void salInsert(SalDTO salDTO)throws Exception;
	public List <SalDTO> Listview();
	public SalDTO salDetailview(Integer workNum)throws Exception;
}
