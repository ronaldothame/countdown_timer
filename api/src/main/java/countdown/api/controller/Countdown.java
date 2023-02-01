package countdown.api.controller;


import countdown.api.Tempo;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.File;

@RestController
@RequestMapping("countdown")
public class Countdown {
    @PostMapping
    public void timeInput(@RequestBody Tempo starterTime) throws IOException {
            Long currentEvent = starterTime.eventTime();
            BufferedWriter writer = new BufferedWriter(new FileWriter("eventFile.txt", true));
            writer.append(currentEvent + "\n");
            writer.close();
        }
    @GetMapping
    public ArrayList<Long> eventList () throws IOException {
        Path path = Paths.get("/Users/ronaldo.thame/countdown_timer/eventFile.txt");
        ArrayList <Long> eventTimeList = new ArrayList<>();
        Files.readAllLines(path).forEach(item -> eventTimeList.add(Long.valueOf(item) - System.currentTimeMillis()));
        return eventTimeList;
    }
    @DeleteMapping
    public void deleteEventList () {
        File eventToDelete = new File("/Users/ronaldo.thame/countdown_timer/eventFile.txt");
        boolean done = eventToDelete.delete();
    }

    }

