// setup connection with parameters list, Map also possible [username:'sa', ...] 
def connection = groovy.sql.Sql.newInstance('jdbc:h2:mem:itsubbotnik', 'sa', '', org.h2.Driver.name)

// execute DDL query
connection.execute 'create table ITSUBBOTNIK (id int, name varchar2(50))' // no braces

// open file with encoding specified
new File('ru-data.txt').getText('Cp1251').eachLine { line ->
	
	if(!line) // Groovy-truth, empty string == false
		return // return from current closure only, not from whole cicle
	
	def params = line.split(/[;,]/)*.trim() // trim each value with spread (*.) operator
	
	// execute DML query with params
	connection.execute 'insert into ITSUBBOTNIK (id, name) values (?, ?)', params
	
	println "insert into ITSUBBOTNIK (id, name) values (${params[0]}, '${params[1]}');"
	// insert into ITSUBBOTNIK (id, name) values (100, 'EPAM ITSubbotnik');
	// insert into ITSUBBOTNIK (id, name) values (101, '17 Сентября 2015');
}

// fetch resultset from the table
connection.eachRow ('select * from ITSUBBOTNIK') { row ->
	println row.id 	// fetch column value 
	println row.NAME
}
connection.close()



