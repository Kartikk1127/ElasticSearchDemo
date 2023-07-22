package com.kartikey.controller

import com.kartikey.entity.Address
import com.kartikey.entity.Person
import com.kartikey.repo.PersonRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
class PersonController(
    val personRepository: PersonRepository
) {

    @GetMapping
    fun getAll(): List<Person> {
        return personRepository.findAll().toList()
    }

    @PostMapping
    fun save(@RequestBody person: Person): Person {
        val user = Person(
            name = person.name,
            addresses = person.addresses
        )
        personRepository.save(user)
        return user
    }

    @PutMapping
    fun updateNameById(@RequestParam id: String, @RequestParam name: String): Optional<Person> {
        val person = personRepository.findById(id)
        person.ifPresent {
            it.name = name
            personRepository.save(person.get())
        }
        return person
    }

    @DeleteMapping
    fun deleteById(@RequestParam id: String) {
        personRepository.deleteById(id)
    }

    @PostMapping("/search-by-address")
    fun searchByAddress(@RequestBody address: Address): List<Person> {
        return personRepository.findByAddresses_CityAndAddresses_ZipCode(
            address.city,
            address.zipCode
        )
    }

}
