package payload;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto {

    private int id;
    private String company;
    private String position;
    private Date startDate;
    private Date endDate;


}
