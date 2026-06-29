package introdaction

fun joinOptions(options: Collection<String>) =
    options.joinToString(prefix = "[", postfix = "]")