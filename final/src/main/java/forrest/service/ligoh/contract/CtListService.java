package forrest.service.ligoh.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.ligoh.ContractDTO;
import forrest.mapper.ligoh.ContractMapper;

@Service
@Component
public class CtListService {
	@Autowired
	ContractMapper contractMapper;
	
	public void ctList(Model model) throws Exception {
	List<ContractDTO> lists = contractMapper.getContractList();
	// 자료실테이블에 있는 레코드가 몇개인지 가져오
	int count = contractMapper.getContractCount();
	
	model.addAttribute("count", count);
	model.addAttribute("lists", lists);
	
	}

}