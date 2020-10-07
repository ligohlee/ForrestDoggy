package forrest.service.han.worker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.WorkerDTO;
import forrest.mapper.han.WorkerMapper;

@Component
@Service
public class WorkerlistService {
	@Autowired
	WorkerMapper workerMapper;
	public void worklist(Model model)throws Exception {
		List <WorkerDTO> lists = workerMapper.getworkListview();
		model.addAttribute("lists", lists);
	}
}
