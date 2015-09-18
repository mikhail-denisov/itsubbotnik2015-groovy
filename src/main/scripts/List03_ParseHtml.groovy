'http://epam.com'.toURL().eachLine { // it -> implicit argument
	 
	if(it ==~ /(?i).*epam.*systems.*/)
		println it
		 
}


