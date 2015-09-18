def url = 'http://api.icndb.com/jokes/random'.toURL()

def map = [:]

def start = System.currentTimeMillis()

// run with GParsPool
groovyx.gpars.GParsPool.withPool(20) {
	
	// collectParallel
	(0..1000).collectParallel {

		def json = new groovy.json.JsonSlurper().parse(url)

		def id = json.value.id
		def joke = json.value.joke
		map << [(id): joke]
	}
}

def end = System.currentTimeMillis()

println end - start // 3,243 secs
println map.size()  // 457 jokes

