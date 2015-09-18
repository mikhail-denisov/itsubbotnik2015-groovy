def elementName = 'worker'

// some structured data with lists and maps
def workersData = [
	[	fname: 'John',
		lname: 'Doe',
		dob: '01-01-1980',
		skills: [java: 'expert',groovy: 'beginner']],
	[	fname: 'Jane',
		lname: 'Smith',
		dob: '28-02-1983']
]

def jsonTemplate = [
	event: [
		eventName:'NEW_WORKERS',
		workers: workersData.collect { [ (elementName): it ] }
	]
]

// data structure (map) as an argument of JSON builder
def builder = new groovy.json.JsonBuilder(jsonTemplate)

println groovy.json.JsonOutput.prettyPrint(builder as String)


