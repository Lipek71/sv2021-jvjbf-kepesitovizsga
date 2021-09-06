package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotBeatException extends AbstractThrowableProblem {

    public NotBeatException(Long id) {
        super(
                URI.create("guiness/bad-request"),
                "Can not beat",
                Status.BAD_REQUEST,
                String.format("Not beat id '%d'", id));
    }
}