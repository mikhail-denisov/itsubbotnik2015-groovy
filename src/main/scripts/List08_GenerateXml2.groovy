import java.text.SimpleDateFormat

def xml = '''<?xml version='1.0' encoding='utf-8'?>
<event>
  <eventType>NEW_WORKERS</eventType>
  <worker>
    <firstName>John</firstName>
    <lastName>DOE</lastName>
    <dateOfBirth>01-01-1980</dateOfBirth>
    <skills java='expert' groovy='beginner' />
  </worker>
  <worker>
    <firstName>Jane</firstName>
    <lastName>SMITH</lastName>
    <dateOfBirth>28-02-1983</dateOfBirth>
    <skills />
  </worker>
</event>'''

def workers = [
	[ fname: 'John', lname: 'Doe', 	 dob: '01-01-1980', skills: [java: 'expert', groovy: 'beginner']],
	[ fname: 'Jane', lname: 'Smith', dob: '28-02-1983'] ]

def writer = new StringWriter()

def builder = new groovy.xml.MarkupBuilder(writer)

builder.mkp.xmlDeclaration(version: "1.0", encoding: "utf-8")

def elementName = 'worker' // externalized XML element name

builder.event {
	
	eventType 'NEW_WORKERS'
	
	// any Groovy code alloweed inside builder
	workers.each { wrk ->
		"$elementName" { // = worker
			firstName	wrk.fname
			lastName 	wrk.lname.toUpperCase()
			dateOfBirth wrk.dob
			skills 		wrk.skills
		}
	}
}

println writer as String

assert writer.toString() == xml
