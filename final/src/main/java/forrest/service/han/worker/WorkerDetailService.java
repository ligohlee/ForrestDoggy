package forrest.service.han.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.WorkerDTO;
import forrest.mapper.han.WorkerMapper;

@Component
@Service
public class WorkerDetailService {
	@Autowired
	WorkerMapper workerMapper;
	public void detailview(Integer workNum,Model model)throws Exception{
		WorkerDTO dto = workerMapper.getdetailview(workNum);
		model.addAttribute("dto", dto);
		
	}
}
