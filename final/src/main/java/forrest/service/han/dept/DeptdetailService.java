package forrest.service.han.dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.DeptDTO;
import forrest.mapper.han.DeptMapper;

@Component
@Service
public class DeptdetailService {
	@Autowired
	DeptMapper deptMapper;
	public void deptdetail(Integer deptNum,Model model)throws Exception{
		DeptDTO dto = deptMapper.deptdetailview(deptNum);
		model.addAttribute("dto", dto);
	}
}
