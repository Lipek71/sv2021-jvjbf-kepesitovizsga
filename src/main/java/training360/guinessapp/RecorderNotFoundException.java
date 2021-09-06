package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class RecorderNotFoundException extends AbstractThrowableProblem {

    public RecorderNotFoundException(Long id) {
        super(
                URI.create("guiness/not-found"),
                "Recorder not found",
                Status.NOT_FOUND,
                String.format("Not found with id '%d'", id));
    }
}
