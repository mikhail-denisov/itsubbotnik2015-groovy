package com.epam.itsubbotnik2015

/*
 * WSDL: http://www.cs.fsu.edu/~engelen/magic.wsdl
 */
class MagicSquare {

	def magicSquare(rankValue){

		def client = new wslite.soap.SOAPClient('http://websrv.cs.fsu.edu/~engelen/magicserver.cgi')

		wslite.soap.SOAPResponse response = client.send (SOAPAction: 'urn:MagicSquare:magic') { // xmlns:methodName
			body (xmlns: 'urn:MagicSquare') { // xmlns are optional, e.g. body { ... }  
				magic {   rank rankValue   }
			}
		}

		// GPath - get first level items
		def items = response.envelope.Body.magicResponse.result.item

		/* convert to list of lists 
		 [
		 [6, 1, 8], 
		 [7, 5, 3], 
		 [2, 9, 4]
		 ]
		 */
		items.collect { it.item*.text()*.toInteger() }
	}
}


