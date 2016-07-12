// Include Default Settings
def slurper = new ConfigSlurper()
slurper.classLoader = this.class.classLoader
def conf = slurper.parse(readFileFromWorkspace(new File('Config', 'settings.groovy').path))

job('t3rookies_temp_job') {
    logRotator(
            conf.logRotator.daysToKeepInt,
            conf.logRotator.numToKeepInt,
            conf.logRotator.artifactDaysToKeepInt,
            conf.logRotator.artifactNumToKeepInt
    )

    // Delivery Pipelien Configuration
    deliveryPipelineConfiguration('Build', 'Build')

}
