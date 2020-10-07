package forrest.service.han.worker;

import java.io.File;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.han.WorkerCommand;
import forrest.domain.han.WorkerDTO;
import forrest.mapper.han.WorkerMapper;

@Component
@Service
public class WorkermodifyProService {
	@Autowired
	WorkerMapper workerMapper;
	public String insertmodify(WorkerCommand workerCommand, HttpSession session)throws Exception{
		WorkerDTO dto = new WorkerDTO();
		dto.setWorkName(workerCommand.getWorkName());
		dto.setWorkPh(workerCommand.getWorkPh());
		dto.setWorkEmail(workerCommand.getWorkEmail());
		Timestamp hireDate = new Timestamp(workerCommand.getHireDate().getTime());
		dto.setHireDate(hireDate);
		Timestamp worDate = new Timestamp(workerCommand.getWorkBorn().getTime());
		dto.setWorkBorn(worDate);
		dto.setPosition(workerCommand.getPosition());
		dto.setJob(workerCommand.getJob());
		dto.setWorkHoli(workerCommand.getWorkHoli());
		dto.setWorkAddr(workerCommand.getWorkAddr());
		
		
		String originalfile = (String)session.getAttribute("dto.workImg");
		System.out.println(originalfile);
		
		String workImg = "`";
		String location = "";
		String path = "/static/worker/upload";
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
		
		workerMapper.getupdatefile(dto);
		if (originalfile != null) {
			file = new File(filePath + "/" + originalfile);
			if (file.exists()) file.delete();
		}
		session.removeAttribute("dto.workImg");
		
		location = "redirect:/worker/WorkerDetail?workNum=" + workerCommand.getWorkNum();
		return location;
	}
	}
