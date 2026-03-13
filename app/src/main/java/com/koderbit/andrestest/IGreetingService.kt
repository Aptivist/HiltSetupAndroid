package com.koderbit.andrestest

interface IGreetingService {
    fun getGreeting() : String
}


interface Developer {
    fun Develop(computer: String)
    fun Debug(computer: String)
    fun Test(computer: String)
}

interface Admon {
    fun DarCursos (alumnos : List<String>)
}


class Andres : Developer{
    override fun Develop(computer: String) {
        println("Andres is developing on $computer")
    }
    override fun Debug(computer: String) {
        println("Andres is debugging on $computer")
    }

    override fun Test(computer: String) {
        println("Andres is testing on $computer")
    }
}


class Sergio : Developer, Admon{
    override fun Develop(computer: String) {
        println("Sergio is vibecoding on $computer")
    }
    override fun Debug(computer: String) {
        println("Sergio is debugging on $computer")
    }
    override fun Test(computer: String) {
        throw Exception("Sergio does not like to test")
    }

    override fun DarCursos(alumnos: List<String>) {
        println("Sergio is teaching to $alumnos")
    }
}

fun main() {
    val developer : Admon = Sergio()


    developer.DarCursos(listOf("Andres", "Sergio"))

}