#!/usr/bin/env groovy

def directory = System.getenv("TAINTED_INPUT")


// IndirectCommandInjection VULNERABILITY HERE
"ls ${directory}".execute()