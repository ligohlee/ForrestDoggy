package forrest.service.ligoh.contract;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.FileName;
import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.ContractDTO;
import forrest.mapper.ligoh.ContractMapper;

@Service
@Component
public class CtDetailService {
	
	@Autowired
	ContractMapper contractMapper;
	public void ctDetail(String ctNum, Model model)throws Exception {
	
	StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1l, 1l, null, ctNum);
	ContractDTO dto = contractMapper.getContractList(startEndPageDTO).get(0);
	String [] oriFile = dto.getCtImage().split("`");
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
