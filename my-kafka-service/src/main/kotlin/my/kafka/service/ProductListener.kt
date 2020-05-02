package my.kafka.service

import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class ProductListener {

    @Topic("my-products")
    fun receiveProduct(@KafkaKey brand: String, name: String){
        println("Got product ${brand} - ${name}")
    }
}