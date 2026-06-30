package properties.delegatesexamples

class LazyProperty(val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}