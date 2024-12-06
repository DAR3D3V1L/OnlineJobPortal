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
public class QualificationDto {
    private int id;
    private String degree;
    private Date startDate;
    private Date endDate;

}
