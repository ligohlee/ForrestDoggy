package forrest.service.ligoh.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.WorkerDTO;
import forrest.mapper.han.WorkerMapper;

@Service
@Component
public class WorkSearchService {
	@Autowired
	 WorkerMapper workerMapper;

		public void wkSel(String workName, Model model) throws Exception {
			WorkerDTO dto = new WorkerDTO();
			dto.setWorkName(workName);
			List<WorkerDTO> lists = workerMapper.workSearch(dto);
		       System.out.println(workName);
			model.addAttribute("lists", lists);
			
		}

}
