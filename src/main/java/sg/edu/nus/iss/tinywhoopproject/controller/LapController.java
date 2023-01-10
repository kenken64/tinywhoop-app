package sg.edu.nus.iss.tinywhoopproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import sg.edu.nus.iss.tinywhoopproject.model.Lap;
import sg.edu.nus.iss.tinywhoopproject.services.LapService;

@Controller
public class LapController {
    
    @Autowired
    private LapService lapService;
    
    
    // Race Course Pilots to Lap Timer Page
    @GetMapping(path={"/laptimer/{pilotId}/{raceId}"})
    public String lapTimer(Model model, @PathVariable String pilotId, @PathVariable Integer raceId) {
        List<Lap> laps = lapService.retrieveLapTimingsOfPilotsByRaceParticipation(pilotId,  raceId);
        model.addAttribute("lapTimings", laps);

        return "laptimer";
    }

    @GetMapping(path={"/show-laptimer"})
    public String showLapTimerForm(Model model, @RequestParam String pilotId, @RequestParam Integer raceId) {
        List<Lap> laps = lapService.retrieveLapTimingsOfPilotsByRaceParticipation(pilotId,  raceId);
        model.addAttribute("lapTimings", laps);

        return "laptimer";
    }

    @PostMapping(path={"/laptimer"})
    public String saveLapTiming(@Valid Lap lap, BindingResult binding, Model model){
        return "laptimer";
    }
    
}
