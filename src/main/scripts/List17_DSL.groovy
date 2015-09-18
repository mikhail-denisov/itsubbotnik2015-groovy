
def show = { println it }

def square_root = { Math.sqrt(it) }

def please(action) {
	[
		the: { what ->
			[
				of: { n ->
					action(what(n))
				}
			]
		}
	]
}

please show the square_root of 1024
//>> 32.0

// what is really calling
please(show).the(square_root).of(1024)




	