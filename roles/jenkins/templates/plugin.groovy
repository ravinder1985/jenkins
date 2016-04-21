import jenkins.model.*

def pluginParameter="{{ plugins }}"
def plugins = pluginParameter.split()
def instance = Jenkins.getInstance()
def pm = instance.getPluginManager()
def uc = instance.getUpdateCenter()
def installed = false
def initialized = false

uc.updateAllSites()

plugins.each {
  println pm.getPlugin(it)
  if (!pm.getPlugin(it)) {
    println "exist"
    if (!initialized) {
      uc.updateAllSites()
      initialized = true
    }
    def plugin = uc.getPlugin(it)
    if (plugin) {
    	plugin.deploy()
      installed = true
    }
  }
}
if (initialized) {
  instance.save()
  instance.doSafeRestart()
}
