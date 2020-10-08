package forrest.service.han.dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.han.DeptCommand;
import forrest.domain.han.DeptDTO;
import forrest.mapper.han.DeptMapper;

@Component
@Service
public class DeptmodiProService {
	@Autowired
	DeptMapper mapper;
	public void deptModipro(DeptCommand command)throws Exception{
		DeptDTO dto = new DeptDTO();
		dto.setDeptName(command.getDeptName());
		dto.setDeptNum(command.getDeptNum());
		dto.setDeptPh(command.getDeptPh());
		mapper.deptModiupdate(dto);
	}
}
