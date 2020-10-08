package forrest.service.han.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.DeptDTO;
import forrest.mapper.han.DeptMapper;

@Component
@Service
public class DeptlistService {
	@Autowired
	DeptMapper deptMapper;
	public void deptlist( Model model)throws Exception {
		List<DeptDTO> lists = deptMapper.deptview();
		model.addAttribute("lists", lists);
	}
}
