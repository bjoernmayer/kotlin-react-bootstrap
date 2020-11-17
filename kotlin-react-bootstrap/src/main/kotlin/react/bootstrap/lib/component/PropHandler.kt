package react.bootstrap.lib.component

fun interface PropHandler<P> {
    fun P.handle()
}
