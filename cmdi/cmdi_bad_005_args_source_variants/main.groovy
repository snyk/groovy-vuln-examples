#!/usr/bin/env groovy



// IndirectCommandInjection VULNERABILITY HERE
def lsExec = { dir -> "ls ${dir}".execute() }
lsExec(args[1])

def myArg = args[2]


// IndirectCommandInjection VULNERABILITY HERE
"ls ${myArg}".execute()

// IndirectCommandInjection VULNERABILITY HERE
"ls ${args[1]}".execute()

// IndirectCommandInjection VULNERABILITY HERE
"ls ${args}".execute()