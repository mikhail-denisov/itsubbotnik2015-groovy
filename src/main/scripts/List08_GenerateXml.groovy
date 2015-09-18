// Groovy multiline strings
def xml = '''<?xml version='1.0' encoding='utf-8'?>
<event>
  <eventType>NEW_WORKERS</eventType>
  <workers>
    <worker>
      <firstName>John</firstName>
      <lastName>Smith</lastName>
      <dateOfBirth>01-01-1980</dateOfBirth>
      <skills java='expert' groovy='beginner' />
    </worker>
    <worker>
      <firstName>Jane</firstName>
      <lastName>Doe</lastName>
      <dateOfBirth>28-02-1983</dateOfBirth>
      <skills />
    </worker>
  </workers>
</event>'''

def writer = new StringWriter()

def builder = new groovy.xml.MarkupBuilder(writer)

builder.mkp.xmlDeclaration(version: "1.0", encoding: "utf-8")

builder.event() {

	eventType ('NEW_WORKERS')
	workers {
		worker {
			firstName	'John'
			lastName	'Smith'
			dateOfBirth '01-01-1980'
			skills 	(java: 'expert', groovy: 'beginner' )
		}
		worker {
			firstName	'Jane'
			lastName	'Doe'
			dateOfBirth '28-02-1983'
			skills ()
		}
	}
}

println writer as String // print formatted XML

assert writer.toString() == xml
