package forrest.command.jjj.ticket;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchCommand {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date ticketSeason;
}
