package training360.guinessapp.recorder;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecorderService {

    private RecorderRepository recorderRepository;

    private ModelMapper modelMapper;

    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        recorderRepository.save(recorder);
        return modelMapper.map(recorder, RecorderDto.class);
    }

    public List<RecorderDto> listRecorders() {
        return recorderRepository.findAll().stream()
                .filter(r -> r.getName().startsWith("B") || r.getName().contains("e"))
                .map(m -> modelMapper.map(m, RecorderDto.class))
                .sorted()
                .collect(Collectors.toList());
    }
}
