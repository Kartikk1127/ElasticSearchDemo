package com.kartikey.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import org.springframework.data.elasticsearch.annotations.Mapping

@Document(indexName = "my-index")
@Mapping(mappingPath = "/mapping.json")
data class Person(
    @Id
    var id: String? = null,

    var name: String,

    @Field(type = FieldType.Nested)
    var addresses: List<Address>? = null
)
