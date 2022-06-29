package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.html.*
import kotlinx.html.body
import kotlinx.html.h1

fun Application.configureRouting() {

    var count = 1
    routing {
        get("/") {
            call.respondHtml(HttpStatusCode.OK) {
                body {
                    h1 {
                        +"Hello Ktor!! あなたは${count++}人目の来訪者です"
                    }
                }
            }
        }
    }
}

data class User(val id: Long, val name:String)