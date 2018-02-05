# Elizabethan Insult Application

This application generates an insult from a random set of words

## Directions

In order to run this application, you must have an OpenShift instance running. For my demos, I am using the 3.3 version
of Minishift/Container Development Kit. Once you have that installed and running, login with your credentials and select
your project. From there, you can run `mvn clean fabric8:deploy -Popenshift`. This will build and deploy the services to
the current project.
