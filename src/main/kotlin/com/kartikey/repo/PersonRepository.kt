package com.kartikey.repo

import com.kartikey.entity.Person
import org.springframework.data.elasticsearch.annotations.Query
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface PersonRepository : ElasticsearchRepository<Person, String>{

    fun findByAddresses_CityAndAddresses_ZipCode(city: String, zipCode: String): List<Person>
}
