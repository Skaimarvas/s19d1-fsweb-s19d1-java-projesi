package com.example.s19d1.service;

import com.example.s19d1.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();

    Actor findById(Long id);

    Actor update(Long id, Actor actor);

    Actor save(Actor actor);

    Actor delete(Long id);

    Actor addMovie(Long actorId, Integer movieId);
}
