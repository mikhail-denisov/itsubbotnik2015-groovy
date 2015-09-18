def url = 'http://news.google.com/news?ned=us&topic=h&output=rss'

def rss = new XmlSlurper().parse(url)

// pretty print xml text
println groovy.xml.XmlUtil.serialize(rss)

println rss.channel.title

rss.channel.item.each { println "- ${it.title}" }


