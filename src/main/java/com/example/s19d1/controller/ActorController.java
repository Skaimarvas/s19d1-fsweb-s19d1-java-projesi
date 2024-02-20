package com.example.s19d1.controller;

import com.example.s19d1.dto.ActorDto;
import com.example.s19d1.entity.Actor;
import com.example.s19d1.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/actors")
public class ActorController {

    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ActorDto findById(@PathVariable("id") Long id) {
        Actor actor = actorService.findById(id);
        return new ActorDto(actor.getId(), actor.getFirstName(), actor.getLastName());
    };

    @PostMapping
    public ActorDto save(@RequestBody Actor actor) {
        Actor actorSaved = actorService.save(actor);

        return new ActorDto(actorSaved.getId(), actorSaved.getFirstName(), actorSaved.getLastName());
    }

    @DeleteMapping(path = "/{id}")
    public ActorDto delete(@PathVariable("id") Long id) {
        Actor removedActor = actorService.delete(id);
        return new ActorDto(removedActor.getId(), removedActor.getFirstName(), removedActor.getLastName());
    }

    @PostMapping(path = "/{id}")
    public ActorDto update(@PathVariable("id") Long id, @RequestBody Actor actor) {
        Actor updatedActor = actorService.update(id, actor);
        return new ActorDto(updatedActor.getId(), updatedActor.getFirstName(), updatedActor.getLastName());
    }

    @PostMapping(path = "/{actorId}/{movieId}")
    public Actor addMovie(@PathVariable("actorId") Long actorId, @PathVariable("movieId") Integer movieId) {
        return actorService.addMovie(actorId, movieId);

    }

}
