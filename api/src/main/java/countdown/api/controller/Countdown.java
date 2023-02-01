package countdown.api.controller;

import countdown.api.Tempo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("countdown")
public class Countdown {
    @PostMapping
    public Long timeInput(@RequestBody Tempo starterTime){
        Long finalTime = starterTime.eventTime() - System.currentTimeMillis();
        return finalTime;
        }
}
