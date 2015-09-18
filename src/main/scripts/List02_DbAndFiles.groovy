import groovy.sql.Sql

// groovy Map syntax, def map = [:]
def datasource = [
	'url' : 'jdbc:h2:mem:itsubbotnik', // 'java.lang.String'
	"user": 'sa', // "groovy.lang.GString"
	password: '', // map key without quotes
	driverClassName: org.h2.Driver.name // class without '.class', .name == getName()
]

def connection = Sql.newInstance(datasource)

connection.execute 'create table ITSUBBOTNIK (id int, name varchar2(50))' // no (parentheses) in method call

def query = 'insert into ITSUBBOTNIK (id, name) values (?, ?)'

// closure - anonymous function
def execute = { line ->
	// closure parameter

	if(!line) // groovy truth
		return // return from iterator == continue

	// spread *. operator
	def data = line.split(/[;,]/)*.trim()

	// access to outbound context from closure
	connection.execute query, data
}

// open file with encoding specified
new File('ru-data.txt').getText('Cp1251').eachLine(execute)

// eachRow - iterator with 2 params: string and closure
connection.eachRow ('select * from ITSUBBOTNIK') { row ->
	// closure arguments

	// closure body
	println row
}

connection.close()
