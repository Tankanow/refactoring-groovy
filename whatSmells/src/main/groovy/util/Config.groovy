package util

public interface Config {
	def loadConfig()
	def getValue(String key)
	def setValue(String key)	
}