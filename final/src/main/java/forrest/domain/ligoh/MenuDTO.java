package forrest.domain.ligoh;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
	 Integer menuNum;
	 String menuName;
	 Double menuPrice;
	 String recipe;
	 String menuIntro;
	 String allergy; 
	 String menuImage;

}
