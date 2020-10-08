package forrest.mapper.han;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.han.DeptDTO;

@Component
@Repository
public interface DeptMapper {
	public void deptInsert(DeptDTO deptDTO)throws Exception;
	public List<DeptDTO> deptview();
	public DeptDTO deptdetailview(Integer deptNum)throws Exception;
	public void deptModiupdate(DeptDTO deptDTO)throws Exception;
}
