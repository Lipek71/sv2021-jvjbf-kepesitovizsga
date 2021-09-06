package training360.guinessapp.worldrecord;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.NotBeatException;
import training360.guinessapp.RecorderNotFoundException;
import training360.guinessapp.WorldRecordNotFoundException;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;
import training360.guinessapp.recorder.Recorder;
import training360.guinessapp.recorder.RecorderRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private WorldRecordRepository worldRecordRepository;

    private RecorderRepository recorderRepository;

    private ModelMapper modelMapper;

    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand command) {
        Recorder recorder = recorderRepository.findById(command.getRecorderId()).orElseThrow(() -> new RecorderNotFoundException(command.getRecorderId()));
        WorldRecord worldRecord = new WorldRecord(command.getDescription(), command.getValue(), command.getUnitOfMeasure(), command.getDateOfRecord(), command.getRecorderId());
        worldRecordRepository.save(worldRecord);
        return modelMapper.map(worldRecord, WorldRecordDto.class);
    }

    public WorldRecordDto beatRecord(Long id, BeatWorldRecordCommand command) {
        Recorder recorder = recorderRepository.findById(id).orElseThrow(() -> new RecorderNotFoundException(id));
        WorldRecord worldRecord = worldRecordRepository.findById(command.getId()).orElseThrow(() -> new WorldRecordNotFoundException(command.getId()));

        if(command.getValue() <  worldRecord.getValue()){
            throw new NotBeatException(command.getId());
        }

        recorder.setRecorder(worldRecord);

        return modelMapper.map(worldRecord, WorldRecordDto.class);
    }
}
