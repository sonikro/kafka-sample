package my.kafka.service

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

data class ProductDTO(
        val brand: String,
        val name: String
)
@Controller("/product")
class ProductController(
        private val productProducer: ProductProducer
) {
    @Post
    fun postProduct(@Body productDTO: ProductDTO){
        return productProducer.sendProduct(brand = productDTO.brand, name = productDTO.name)
    }
}