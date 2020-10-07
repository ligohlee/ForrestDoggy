package forrest.service.han.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.domain.han.WorkerDTO;
import forrest.mapper.han.WorkerMapper;

@Component
@Service
public class WorkerDeleteService {
	@Autowired
	WorkerMapper workerMapper;
	public void delpro(Integer workNum)throws Exception{
		WorkerDTO dto = new WorkerDTO();
		dto.setWorkNum(workNum);
		workerMapper.workDel(dto);
	}
}
