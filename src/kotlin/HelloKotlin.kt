package com.xosp.learn.kotlin

open class BaseClazz1(name: String) {

    val testProp1 = "xxx"

    val testProp2 = "hello $name"

    init {
        print("init")
    }
}

interface BaseClazz2 {

}

class TestClazz constructor(arg1: String, val prop1: String) {

    init {
        println("$prop1")
    }

    constructor(arg1: String): this(arg1, "test") {

    }

}

data class TestDataClazz(var val1: Int = 0, val val2: String) {
    fun testFun1() {

    }
}

fun String.testFun1(): String {
    return this + "test"
}



object Resource {
    val name = "reource"
}

inline fun <reified T: Any> fromJson() = {
    println(T::class.java)
}

fun main(args: Array<String>) {
    "hello world".testFun1()

    val obj1 = TestDataClazz(val2 = "hello world")
    val (p1, p2) = obj1

    val list = listOf(1, 2, 3)
    println(list::class)

    Resource?.name ?: null

    val p: String by lazy {
        "test_lazy"
    }

    println(p)

    list?.let {
        when(it) {
            null -> {
                println("y")
            }
            else -> {
                println("x")
            }
        }
        it
    }.forEach {
        println(it)
    }

    fun testSEF() = 43

    testSEF()

    with(obj1) {
        testFun1()
    }

    fromJson<TestDataClazz>()

    val asc = Array(5) { it * it}

}