package forrest.controller.han.REVIEW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import forrest.command.han.ReviewCommand;
import forrest.service.han.review.RevdetailService;
import forrest.service.han.review.ReviewService;
import forrest.service.han.review.ReviewlistService;

@Controller
@RequestMapping("worker")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	@Autowired
	ReviewlistService reviewlistService;
	@Autowired
	RevdetailService revdetailService;
	@RequestMapping("REVIEWList")
	public String list(Model model)throws Exception {
	reviewlistService.revview(model);
		return "thymeleaf/backOfficePage/html/review_manager/review_List";
	}
	@RequestMapping("revWrite")
	public String write() {
		return "thymeleaf/backOfficePage/html/review_manager/review_Write";
	}
	@RequestMapping("revwritePro")
	public String writePro(ReviewCommand reviewCommand)throws Exception {
		reviewService.revInsert(reviewCommand);
		return "redirect:/worker/REVIEWList";
	}
	@RequestMapping("ReviewDetail")
	public String detail(@RequestParam(value = "workNum")Integer workNum,Model model)throws Exception{
		revdetailService.detailview(workNum,model);
		return "thymeleaf/backOfficePage/html/review_manager/review_view";
	}
}
