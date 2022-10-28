import java.lang.Thread.sleep
import java.util.concurrent.Executor
import java.util.concurrent.Executors

fun main(args: Array<String>) {
    val lock1 = Any()
    val lock2 = Any()
    val exec = Executors.newFixedThreadPool(2)

    exec.execute {
        synchronized(lock1) {
            sleep(1000)
            synchronized(lock2) {
                sleep(1000)
                println("Sloth2")
            }
        }
    }

    exec.execute {
        synchronized(lock2) {
            sleep(1000)
            synchronized(lock1) {
                sleep(1000)
                println("Sloth1")
            }
        }
    }
}