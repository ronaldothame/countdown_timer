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
@CrossOrigin(origins = "*")
public class Countdown {
    @PostMapping
    public void timeInput(@RequestBody Tempo starterTime) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("eventFile.txt", true));
        writer.append(starterTime.eventName() + "|" + starterTime.eventTime() + "\n");
        writer.close();
    }
    @GetMapping
    public ArrayList<Tempo> eventList () throws IOException {
        Path path = Paths.get("/Users/ronaldo.thame/countdown_timer/eventFile.txt");
        ArrayList <Tempo> eventTimeList = new ArrayList<>();
        Files.readAllLines(path).forEach(item -> {
                String [] itens = item.split("\\|");
                eventTimeList.add(new Tempo(itens[0],itens[1]));
        });
        return eventTimeList;
    }
    @DeleteMapping
    public void deleteEventList () {
        File eventToDelete = new File("/Users/ronaldo.thame/countdown_timer/eventFile.txt");
        boolean done = eventToDelete.delete();
    }

}

