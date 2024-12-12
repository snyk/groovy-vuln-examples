import groovy.util.Eval

def tainted_code = System.getenv("TAINTED_INPUT")

// CodeInjection VULNERABILITY HERE
Eval.me(tainted_code)


// CodeInjection VULNERABILITY HERE
Eval.x("arg_1", tainted_code)


// CodeInjection VULNERABILITY HERE
Eval.xy("arg_1", "arg_2", tainted_code)


// CodeInjection VULNERABILITY HERE
Eval.xyz("arg_1", "arg_2", "arg_3", tainted_code)


// NOT VULNERABLE TO CodeInjection HERE
Eval.x(tainted_code, "print(x)")

// Shouldn't sink on arg 1 if 3 args are given
// NOT VULNERABLE TO CodeInjection HERE
Eval.me(tainted_code, "a value", 'print("tainted_code sets variable name, ")')
