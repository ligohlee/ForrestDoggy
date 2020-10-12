package forrest.domain.han;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
	Integer revNum;
	Integer workNum;
	Integer quality;
	Integer attain;
	Integer effort;
	Integer creativity;
	Integer responsibility;
	Integer cooper;
	Integer knowle;
	Timestamp revDate;
	String revWriter;
}
