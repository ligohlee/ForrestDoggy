package forrest.service.han.worker;

import java.io.File;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.han.WorkerCommand;
import forrest.domain.han.WorkerDTO;
import forrest.mapper.han.WorkerMapper;

@Component
@Service
public class WorkerService {
	@Autowired
	WorkerMapper workerMapper;
	public String workInsert(WorkerCommand workerCommand, HttpServletRequest request)throws Exception {
		WorkerDTO dto = new WorkerDTO();
		dto.setDeptNum(workerCommand.getDeptNum());
		
		dto.setWorkNum(workerCommand.getWorkNum());
		dto.setWorkName(workerCommand.getWorkName());
		dto.setWorkPh(workerCommand.getWorkPh());
		dto.setWorkEmail(workerCommand.getWorkEmail());
		dto.setWorkPass(workerCommand.getWorkPass());
		dto.setPosition(workerCommand.getPosition());
		dto.setJob(workerCommand.getJob());
		dto.setWorkHoli(workerCommand.getWorkHoli());
		dto.setWorkAddr(workerCommand.getWorkAddr());
		
		Timestamp workDate = new Timestamp(workerCommand.getWorkBorn().getTime());
		dto.setWorkBorn(workDate);
		System.out.println(workDate);
		Timestamp hireDate = new Timestamp(workerCommand.getHireDate().getTime());
		dto.setHireDate(hireDate);
		System.out.println(hireDate);
		String workImg = "`";
		String location = "";
		String path = "/static/upload/worker";
		String filePath = "C:/Users/Han/git/ForrestDoggy/final/src/main/resources/static/upload/worker";
		
		MultipartFile mf = workerCommand.getWorkImg();
		String img = mf.getOriginalFilename();
		File file = new File(filePath + "/" + img);
		try {
			mf.transferTo(file);
		} catch (Exception e) {
			// TODO: handle exception
			location = "thymeleaf/backOfficePage/html/worker_manager/worker_regist";
			e.printStackTrace();
		}
		dto.setWorkImg(img);
		workerMapper.workerInsert(dto);
		location = "redirect:/worker/workContract";
		return location;
	}
}
