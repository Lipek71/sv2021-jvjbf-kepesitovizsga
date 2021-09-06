package training360.guinessapp.worldrecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.recorder.Recorder;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "worldrecord")
public class WorldRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Double value;

    private String unitOfMeasure;

    private LocalDate dateOfRecord;

    private Long recorderId;

    @OneToOne(mappedBy = "recorder", cascade = CascadeType.ALL)
    private Recorder recorder;

    public WorldRecord(String description, Double value, String unitOfMeasure, LocalDate dateOfRecord, Long recorderId) {
        this.description = description;
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
        this.recorderId = recorderId;
    }
}
