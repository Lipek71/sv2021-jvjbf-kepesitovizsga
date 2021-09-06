package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.recorder.Recorder;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecordCreateCommand {

    @NotBlank(message = "must not be blank")
    private String description;

    @NotNull(message = "must not be blank")
    private Double value;

    @NotBlank(message = "must not be blank")
    private String unitOfMeasure;

    @NotNull(message = "must not be blank")
    private LocalDate dateOfRecord;

    @NotNull(message = "must not be blank")
    private Long recorderId;
}
