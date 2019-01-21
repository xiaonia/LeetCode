package groovy

//langs = ['Java':'', 'Cpp':'', 'Python':'']

def object = 1

println Integer.metaClass

Integer.metaClass.test1 {

}

println Integer.metaClass

Integer.metaClass.test2 {

}

println Integer.metaClass

println object.metaClass

object.metaClass.test { ->
    println 'hello test'
}

object.test()

println object.metaClass

println Integer.metaClass

/*xmlDoc = new groovy.xml.StreamingMarkupBuilder().bind {
    mkp.xmlDeclaration()
    mkp.declareNamespace(computer: 'Computer')
    languages {
        langs.each { key, value ->
            computer.language (name: key) {
                author (value)
            }
        }
    }
}

println xmlDoc */

