package my.kafka.service

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface ProductProducer {

    @Topic("my-products")
    fun sendProduct(@KafkaKey brand: String, name: String)

}