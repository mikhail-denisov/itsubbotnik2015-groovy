import com.epam.itsubbotnik2015.MagicSquare

// params - implicit parameter map
// ?: Elvis operator
def rank = params.rank ?: 3

def data = new MagicSquare().magicSquare(rank)

// html - implicit MarkupBuilder
html.html {

	body {

		form (action: 'magic2.groovy'){
			label 'Rank'
			input ( type:'text', name: 'rank', value: "$rank", size:2)
			button ( type:'submit', 'Run')
		}

		table {

			data.each { k ->
				tr {
					k.each { v -> td v }
				}
			}
		}
	}
}




