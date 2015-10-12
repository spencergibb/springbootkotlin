package com.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@RestController
open class DemokotlinApplication {

    val counter = AtomicLong()

    @RequestMapping("/")
    public fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }

    companion object {
        @JvmStatic public fun main(args: Array<String>) {
            SpringApplication.run(DemokotlinApplication::class.java, *args)
        }
    }
}