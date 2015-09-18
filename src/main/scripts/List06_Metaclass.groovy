class MyClass {
	def foo() {
		'foo'
	} // implicit return
}

// invoke regular method foo()
def object1 = new MyClass()
assert 'foo' == object1.foo()

// add and invoke method bar() to the object1
object1.metaClass.bar = { arg -> (arg as String).toUpperCase() }

assert object1.bar('Metaobject Protocol') == 'METAOBJECT PROTOCOL'
assert object1.bar(1234) == '1234'

// method has been added only to "object1"
def object2 = new MyClass()
try {
	object2.bar('Exception')
} catch (e) {
	assert e.class.name == MissingMethodException.name
}

// add and invoke static method baz() to the whole class
MyClass.metaClass.static.baz = { arg -> "static $arg" }

assert MyClass.baz('baz method') == 'static baz method'




// invoke undefined method
try {
	' abc def '.toCamelCase() // result should be AbcDef
} catch (e) {
	assert e.class.name == MissingMethodException.name
}

// modify java.lang.String
String.metaClass.toCamelCase = {

	def words = []
	
	// implicit closure parameters: this, delegate, owner
	// java.util.regex.Matcher, delegate =~ /(\b\w)(\w*)/
	
	delegate.eachMatch (/(\b\w)(\w*)/) { 
		words << it[1].toUpperCase()+it[2]
	}
	words.join('')
}

// all Strings
assert 'abc 123 def jj '.toCamelCase() == 'Abc123DefJj'
assert ' abc def '.toCamelCase() == 'AbcDef'

println 'success'



