package forrest.mapper.han;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.han.WorkerDTO;
import forrest.domain.jm.StartEndPageDTO;

@Component
@Repository
public interface WorkerMapper {
	public void workerInsert(WorkerDTO workerDTO)throws Exception;
	public WorkerDTO SelectWorker(Integer workNum);
	public WorkerDTO getdetailview(Integer workNum)throws Exception;
	public void getinsertModi(WorkerDTO workerDTO)throws Exception;
	public void getupdatefile(WorkerDTO dto)throws Exception;
	public void workDel(WorkerDTO dto)throws Exception;
	public List<WorkerDTO> getworkListview()throws Exception;
	public List<WorkerDTO> workSearch(StartEndPageDTO dto)throws Exception;
}
