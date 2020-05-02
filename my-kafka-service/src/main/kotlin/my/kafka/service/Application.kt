package my.kafka.service

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("my.kafka.service")
                .mainClass(Application.javaClass)
                .start()
    }
}