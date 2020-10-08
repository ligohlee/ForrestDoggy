package forrest.service.han.dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.han.DeptCommand;
import forrest.domain.han.DeptDTO;
import forrest.mapper.han.DeptMapper;

@Component
@Service
public class DeptService {
	@Autowired 
	DeptMapper deptMapper;
	public void deptinsert(DeptCommand deptCommand)throws Exception{
		DeptDTO dto = new DeptDTO();
		dto.setDeptName(deptCommand.getDeptName());
		dto.setDeptNum(deptCommand.getDeptNum());
		dto.setDeptPh(deptCommand.getDeptPh());
		deptMapper.deptInsert(dto);
	}
}
