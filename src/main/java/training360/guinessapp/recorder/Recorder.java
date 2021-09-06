package training360.guinessapp.recorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.worldrecord.WorldRecord;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recorder")
public class Recorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id")
    private WorldRecord recorder;

    public WorldRecord getRecorder() {
        return recorder;
    }

    public void setRecorder(WorldRecord recorder) {
        this.recorder = recorder;
    }

    public Recorder(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
