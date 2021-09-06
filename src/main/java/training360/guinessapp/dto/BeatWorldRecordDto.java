package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatWorldRecordDto {

    private String description;

    private String unitOfMeasure;

    private String oldRecorderName;

    private String newRecorderName;

    private Double newRecordValue;

    private Double recordDifference;

}
