package com.divyansh.demo.controllers;

import com.divyansh.demo.models.Session;
import com.divyansh.demo.repositories.SessionRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionControllers {

    @Autowired
    private SessionRepo sessionRepo;

    @GetMapping
    public List<Session> getAllSession(){
        return sessionRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session getID(@PathVariable Long id){
        return sessionRepo.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session){
        return sessionRepo.saveAndFlush(session);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        sessionRepo.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public  Session update(@PathVariable Long id, @RequestBody Session session){
        // get the existing session id to update.
        Session existingSession = sessionRepo.getOne(id);
        // update everything except the primary key value i.e. session_id
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepo.saveAndFlush(existingSession);
    }
}
