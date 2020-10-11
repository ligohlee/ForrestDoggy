package forrest.service.ligoh.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.FileName;
import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.EvaluationDTO;
import forrest.mapper.ligoh.EvaluationMapper;

@Service
@Component
public class EvalDetailService {
    @Autowired
    EvaluationMapper evaluationMapper;

	public void evDetail(String evalNum, Model model) throws Exception {
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1l, 1l, null, evalNum);
		EvaluationDTO dto = evaluationMapper.getEvalList(startEndPageDTO).get(0);
		String [] oriFile = dto.getIngrImg().split("`");
		List<FileName> fileList = new ArrayList<FileName>();
		 int i = 0;
	     for (String file : oriFile) {
	   	  FileName fileName = new FileName(file);
	   	  fileList.add(fileName);
	   	  i++;
		}
	    model.addAttribute("fileList", fileList);
		model.addAttribute("detail", dto);
			
		}
		
	}


