import groovy.json.JsonSlurper

def map = [:]

def start = System.currentTimeMillis()
def url = 'http://api.icndb.com/jokes/random'.toURL()

(0..1000).collect {

	def json = new JsonSlurper().parse(url)

	def id = json.value.id
	def joke = json.value.joke
	map << [(id): joke]
}

def end = System.currentTimeMillis()

println end - start //45,161 secs
println map.size()  //469 rows


