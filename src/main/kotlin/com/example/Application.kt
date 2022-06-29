package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.response.*

val MyPlugin = createApplicationPlugin(name = "MyPlugin") {
    onCall { call -> call.response.header("MyHeader", "konnichiwa") }
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        install(MyPlugin)
    }.start(wait = true)
}
