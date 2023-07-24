package com.kartikey.repo

import com.kartikey.entity.Event
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : ElasticsearchRepository<Event, String>

