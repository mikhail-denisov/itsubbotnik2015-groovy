import com.epam.itsubbotnik2015.MagicSquare

def rankValue = params.rank ?: 3
def data = new MagicSquare().magicSquare(rankValue)

html.html {
	head {
		title 'Magic Square'

		// <link rel='stylesheet' type='text/css' href='../css/magic.css'></link>
		link (rel: "stylesheet", type: "text/css", href:"../css/magic.css")
	}
	body {
		form (action: 'magic3.groovy'){
			label 'Rank'
			input ( type:'text', name: 'rank', value: "$rankValue", size:2)
			button ( type:'submit', 'Run')
		}
		label (class : 'magic', 'Magic Value:') // <label class='magic'>Magic Value:</label>
		label (class : 'magic', data[0].sum()) // GPath

		p() // empty element - <p/>

		table {
			data.each { k -> tr { k.each { v -> td v } } }
		}
	}
}




