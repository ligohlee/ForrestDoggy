package forrest.domain.han;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayDTO {
	Integer workNum;
	Timestamp holiDate;
	String holiSort;
}
