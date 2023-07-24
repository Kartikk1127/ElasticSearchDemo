package com.kartikey.controller

import com.kartikey.entity.Event
import com.kartikey.repo.EventRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/events")
class EventController(private val eventRepository: EventRepository) {

    @PostMapping
    fun saveEvent(@RequestBody event: Event): Event {
        return eventRepository.save(event)
    }

    @GetMapping("/{id}")
    fun getEventById(@PathVariable id: String): Event? {
        return eventRepository.findById(id).orElse(null)
    }

    @GetMapping
    fun getAllEvents(): List<Event> {
        return eventRepository.findAll().toList()
    }

    @DeleteMapping("/{id}")
    fun deleteEvent(@PathVariable id: String): String{
        eventRepository.deleteById(id)
        return "deleted"
    }
}

