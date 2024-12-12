#!/usr/bin/env groovy
import java.lang.Runtime

// IndirectCommandInjection VULNERABILITY HERE
Runtime.getRuntime().exec(args)