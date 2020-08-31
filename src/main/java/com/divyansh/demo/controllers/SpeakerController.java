package com.divyansh.demo.controllers;

import com.divyansh.demo.models.Speaker;
import com.divyansh.demo.repositories.SpeakerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepo speakerRepo;

    @GetMapping
    public List<Speaker> getAllSpeakers() { return speakerRepo.findAll();}

    @GetMapping
    @RequestMapping
    public Speaker getId(@PathVariable Long id){
        return speakerRepo.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker) {return speakerRepo.saveAndFlush(speaker);}

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepo.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, Speaker speaker){
        Speaker existingSpeaker =  speakerRepo.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return  speakerRepo.saveAndFlush(existingSpeaker);

    }
}
