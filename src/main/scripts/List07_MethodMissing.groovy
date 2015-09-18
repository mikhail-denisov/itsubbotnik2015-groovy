class MyClass2 {
	
	def foo(args){
		"Call foo($args)"
	}
	
	def methodMissing(String name, args){
		"Call methodMissing for $name ($args)"	
	}
	
}

def object = new MyClass2()

assert object.foo() == 'Call foo(null)'

assert object.bar('hello') == 'Call methodMissing for bar ([hello])'

assert object.baz( [1:'one'] ) == 'Call methodMissing for baz ([[1:one]])'

//  Groovy Builders: 
//	groovy.xml.MarkupBuilder()
//	groovy.json.JsonBuilder()
//	groovy.util.AntBuilder()
//	groovy.swing.SwingBuilder()
//  ...

