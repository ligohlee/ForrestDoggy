package forrest.command.jm;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerCommand {
	@NotNull
	Integer ptNum;
	@NotNull
	String ptName;
	@NotNull
	String ptPh;
	@NotNull
	String ptEmail;
	@NotNull
	String ptAddr;
	@NotNull
	String ptType;
	@NotNull
	Integer ptBusinessNum;
	@NotNull
	String ptAccount;
	String ptComent;
	@NotNull
	String ptCeo;
	
	MultipartFile report;
	
}
