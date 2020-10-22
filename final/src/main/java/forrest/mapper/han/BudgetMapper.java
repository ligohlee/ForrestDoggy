package forrest.mapper.han;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.han.BudgetDTO;
import forrest.domain.han.GoogleDTO;

@Component
@Repository
public interface BudgetMapper {
	public void getbudInsert(BudgetDTO dto)throws Exception;
	public List<BudgetDTO> budlistview();
	public BudgetDTO buddetailview(Integer budNum)throws Exception;
	public List<GoogleDTO> googleview(Integer deptNum);
	public BudgetDTO budchartListview(Integer deptNum)throws Exception;
	
}
