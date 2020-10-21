package forrest.command.han;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayCommand {
	Integer workNum;
	String holiDate;
	String holiSort;
}
