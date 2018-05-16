# consider placing these instructions directly in your .bashrc or .zshrc file

# JAVA_HOME may already be set - this is the Mac way of setting this
export JAVA_HOME=$(/usr/libexec/java_home)

export LAB_HOME=`git rev-parse --show-toplevel`/lab-files

# Assumes a path relative to lab home - unless you've installed
# GemFire elsewhere
export GEMFIRE=~/Courses-Installed/gemfire-developer-labfiles/pivotal-gemfire-9.3.0
export PATH=$PATH:$GEMFIRE/bin


