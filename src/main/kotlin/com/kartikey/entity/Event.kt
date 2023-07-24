package com.kartikey.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "events")
data class Event(
    @Id val id: String?,
    val name: String,
    val dataOldJson: String?,
    val transactionId: String,
    val merchant: String,
    val timestamp: String,
    val tenantId: String,
//    @Field(type = FieldType.Nested, includeInParent = true)
    val message: EventMessage,
    val pkAssistId: Int
)

data class EventMessage(
    val message: String,
    val access_key: String,
    val secret_key: String,
//    @Field(type = FieldType.Nested, includeInParent = true)
    val refundPaymentResponseBody: RefundPaymentResponseBody,
    val refundPaymentResponseStatusCode: String
)

data class RefundPaymentResponseBody(
    val status_code: Int,
    val status: String,
//    @Field(type = FieldType.Nested, includeInParent = true)
    val error: RefundPaymentError
)

data class RefundPaymentError(
    val code: String,
    val c_message: String,
    val m_message: String,
    val retry_allowed: Boolean,
    val raise_alarm: Boolean
)
