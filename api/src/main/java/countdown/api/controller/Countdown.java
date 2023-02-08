package countdown.api.controller;


import countdown.api.Tempo;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
    public ArrayList<Tempo> eventList () {
        ArrayList<Tempo> eventTimeList = new ArrayList<>();
        try {
            Path path = Paths.get("/Users/ronaldo.thame/countdown_timer/eventFile.txt");
            Files.readAllLines(path).forEach(item -> {
                String[] itens = item.split("\\|");
                eventTimeList.add(new Tempo(itens[0], itens[1]));
            });
            return eventTimeList;
        } catch (IOException ex) {
            return eventTimeList;
        }
    }
    @DeleteMapping
    public void deleteEventList () throws IOException {
        new PrintWriter("/Users/ronaldo.thame/countdown_timer/eventFile.txt").close();
    }
}

