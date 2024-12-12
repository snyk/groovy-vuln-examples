#!/usr/bin/env groovy

// IndirectCommandInjection VULNERABILITY HERE
Runtime.getRuntime().exec(args)

// IndirectCommandInjection VULNERABILITY HERE
java.lang.Runtime.getRuntime().exec(args)