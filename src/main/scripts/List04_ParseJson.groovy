import groovy.json.JsonOutput
import groovy.json.JsonSlurper

// get JSON as text
def text = 'http://api.icndb.com/jokes/random/3'.toURL().text

// print formatted JSON
println JsonOutput.prettyPrint(text)

// parse with JsonSlurper, no POJOs is needed
def json = new JsonSlurper().parseText(text)

// handling json tree with GPath
println 'id list: ' + json.value.id 

println '1st joke: ' + json.value.joke[0]		

println 'last joke: ' + json.value.joke[-1]		



def url = 'http://services.groupkt.com/country/search?text=un'.toURL()

// print formatted JSON
println JsonOutput.prettyPrint(url.text)

// parse with JsonSlurper
json = new JsonSlurper().parse(url)

// GPath + finder: find all country names started with U
json.RestResponse.result.findAll { it.name[0] == 'U' }.each {
	println it.name
}


