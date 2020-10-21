package forrest.domain.ligoh;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
	Integer courseNum;
	String courseName;
	String courseContent;
	Integer coursePrice;
	Integer menuPrice;
	String menuName;
}
