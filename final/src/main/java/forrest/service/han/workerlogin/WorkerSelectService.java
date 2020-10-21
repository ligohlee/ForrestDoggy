package forrest.service.han.workerlogin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.AuthInfoHeadOffice;
import forrest.domain.han.WorkerDTO;
import forrest.mapper.han.WorkerMapper;

@Component
@Service
public class WorkerSelectService {
	@Autowired
	WorkerMapper mapper;
	
	AuthInfoHeadOffice auth;
	public String selectWorker(Integer workNum, String workPass, HttpSession session) {
		WorkerDTO dto = mapper.SelectWorker(workNum);
		if (workPass == dto.getWorkPass()) {
			auth = new AuthInfoHeadOffice(dto.getWorkNum(),dto.getWorkPass());
			System.out.println(auth.getId());
			
			session.setAttribute("auth", auth);
			session.setAttribute("login", workNum);
			return "redirect:/backoffice/login";
		}else {
			return "thymeleaf/backOfficePage/html/total_management";
		}
	}
}
