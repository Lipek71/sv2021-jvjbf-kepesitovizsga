package training360.guinessapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatWorldRecordCommand {

    @NotNull(message = "must not be blank")
    private Long id;

    @NotNull(message = "must not be blank")
    private Double value;
}
