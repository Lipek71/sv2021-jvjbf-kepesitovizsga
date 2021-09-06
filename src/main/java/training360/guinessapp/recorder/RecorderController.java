package training360.guinessapp.recorder;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RecorderController {

    private RecorderService recorderService;

    @PostMapping("/recorders")
    public RecorderDto createRecorder(@RequestBody @Valid RecorderCreateCommand command){
        return recorderService.createRecorder(command);
    }

    @GetMapping("/recorder")
    public List<RecorderDto> listRecorders(){
        return recorderService.listRecorders();
    }


}
