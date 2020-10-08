
package forrest.service.ligoh.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.WorkerDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.han.WorkerMapper;

@Service
@Component
public class WorkSearchService {
	@Autowired
	 WorkerMapper workerMapper;
		public void wkSel(String ptName, Model model) throws Exception {
			
			
			StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, ptName, null);
			
			List<WorkerDTO> lists = workerMapper.workSearch(dto);
		       System.out.println(ptName);
			model.addAttribute("lists", lists);
			
		}

}
