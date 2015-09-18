
// Interface and some serviceMethod 
interface RemoteServiceInterface {

	def method1(String str)	
	def method2(String str1, String str2)	
	def method3(list)	
}

def serviceMethod(RemoteServiceInterface remoteService){
	def response = remoteService.method1('invoke remote service')
	// some response processing here
	response
} 

// Test for serviceMethod(MyInterface object)

def stub = [ method1: { str -> 'test response' } ] as RemoteServiceInterface
 
// method2 and method3 may not be implemented

assert serviceMethod(stub) == 'test response'

assert stub.class.name == 'com.sun.proxy.$Proxy6'





