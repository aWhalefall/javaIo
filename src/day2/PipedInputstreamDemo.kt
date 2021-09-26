package day2

import java.io.PipedInputStream
import java.io.PipedOutputStream

/**
 * author =kuaidao@reworldgame.com
 * time=2021/9/26 16:33
 * 1.管道输出流 必须与管道输入流绑定
 * 线程A 中向PipedOutPutSteam 中写数据
 * 线程B 从PipedInPutSteam 中读数据
 *
 * 注意：
 * JavaIO中必须是一个线程通过PipedOutputStream 写入数据,另外的线程通过与他相连接的PipedInputStream读取数据
 *
 * 场景
 * 本地上传临时文件到云端。
 * 旧： 内存中整合--》写入磁盘   从磁盘读取--》上传云端
 * 新  内存中整合 -上传云端
 *
 * link ：https://www.yisu.com/zixun/526004.html
 */
object PipedInputstreamDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        test()
    }

    private fun test() {
        var pipedOutputStream = PipedOutputStream()
        val pipedInputStream = PipedInputStream(pipedOutputStream)
        Thread() {
            pipedOutputStream?.write("hello world".toByteArray())
            pipedOutputStream?.flush()
            pipedOutputStream.close()
        }.start()


        var receive: Int = pipedInputStream.read()
        while (receive != -1) {
            System.err.print(receive.toChar())
            receive = pipedInputStream.read()
        }

        pipedInputStream.close()
    }
}