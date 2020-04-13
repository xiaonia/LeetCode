package groovy


class TestUtils {

    //*
    def static notDefineMethod(TestSuper self, Object obj) {
        println "notDefineMethod by TestUtils."
    } //*/

    def static methodMissing(TestSuper self, String name, Object args) {
        println(self)
        println "methodMissing by TestUtils."
    }
}

class TestSuper extends GroovyObjectSupport {

    //*
    def notDefineMethod = { obj ->
        println "notDefineMethod by TestSuper Property."
    } //*/

    /*
    static def notDefineMethod(Object obj) {
        println "notDefineMethod by TestSuper."
    } //*/

    def methodMissing(String name, Object args) {
        println "methodMissing by TestSuper."
    }
}

class TestThis extends TestSuper {

    /*
    def notDefineMethod = { obj ->
        println "notDefineMethod by TestThis Property."
    } //*/

    //*
    def notDefineMethod(Object obj) {
        super.notDefineMethod(obj)
        println "notDefineMethod by TestThis."
    } //*/

    def methodMissing(String name, Object args) {
        println "methodMissing by TestThis."
    }
}

TestSuper.metaClass {
    /*
    notDefineMethod { obj ->
        println "notDefineMethod by MetaClass."
    } //*/
}

TestThis.metaClass {
    /*
    notDefineMethod { obj ->
        println "notDefineMethod by MetaClass."
    } //*/

    /*
    define(TestSuper) {
        notDefineMethod { obj ->
            println "notDefineMethod by SubClass."
        }
    } //*/

    /*
    define (TestSuper) {
        invokeMethod { name, args ->
            println "invokeMethod by SubClass."
        }
    } //*/
}

use (TestUtils) {
    def testObject = new TestThis()
    testObject.notDefineMethod("hello world!")
}
