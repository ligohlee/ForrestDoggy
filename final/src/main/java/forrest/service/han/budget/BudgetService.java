package forrest.service.han.budget;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.thoughtworks.qdox.parser.ParseException;

import forrest.command.han.BudgetCommand;
import forrest.domain.han.BudgetDTO;
import forrest.mapper.han.BudgetMapper;

@Component
@Service
public class BudgetService {
	@Autowired
	BudgetMapper budgetMapper;
	public void budInsert(BudgetCommand budgetCommand)throws Exception{
		BudgetDTO dto = new BudgetDTO();
		dto.setBudBasic(budgetCommand.getBudBasic());
		dto.setBudEtc(budgetCommand.getBudEtc());
		dto.setBudFacility(budgetCommand.getBudFacility());
		dto.setBudNum(budgetCommand.getBudNum());
		dto.setBudSalary(budgetCommand.getBudSalary());
		dto.setBudSup(budgetCommand.getBudSup());
		dto.setDeptNum(budgetCommand.getDeptNum());
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date =  inputFormat.parse(budgetCommand.getBudYear());
		} catch (ParseException e) {
			System.out.println("Date Format Not Supported");
			e.printStackTrace();
			// TODO: handle exception
		}
		Timestamp ts =  new Timestamp(date.getTime());
		

		dto.setBudYear(ts);
		System.out.println(dto);
		budgetMapper.getbudInsert(dto);
		
	}
}
