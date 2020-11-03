package forrest.service.jm;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Component
@Service
public class LoginBackService {
	public void loginBack(HttpServletRequest request, Model model) throws Exception{
		
		String path = "/main";
		if (request.getHeader("referer") != null) {
			int hostLength = request.getHeader("referer").indexOf(request.getHeader("host")) + request.getHeader("host").length();
			path = request.getHeader("referer").substring(hostLength);
		}
		System.out.println(path);
		model.addAttribute("backpath", path);
		
	}

}
