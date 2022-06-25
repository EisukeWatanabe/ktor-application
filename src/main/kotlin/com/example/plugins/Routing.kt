package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello Ktor!")
        }
        route("programming-languages") {
            get("Kotlin") {
                call.respondText("Hello Kotlin!")
            }
        }
        route("users") {
            get("{userId}") {
                val userId = call.parameters["userId"]!!.toLong()
                call.respondText("get user[id = $userId]")
            }
            post {
                call.respondText("create users")
            }
            put("{userId}") {
                val userId = call.parameters["userId"]!!.toLong()
                call.respondText("update user[id =$userId")
            }
            delete("{userId}") {
                val userId = call.parameters["userId"]!!.toLong()
                call.respondText("delete user[id = $userId")
            }
        }
    }
}

data class User(val id: Long, val name:String)