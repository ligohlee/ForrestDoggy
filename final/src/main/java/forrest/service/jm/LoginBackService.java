package forrest.service.jm;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Component
@Service
public class LoginBackService {
	public void loginBack(HttpServletRequest request, Model model) throws Exception{
		
		String path = "/";
		if (request.getHeader("referer") != null) {
			path = request.getHeader("referer");
		}
		
		model.addAttribute("backpath", path);
		
	}

}
