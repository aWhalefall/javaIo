package day3

import java.io.*

/**
 * author =kuaidao@reworldgame.com
 * time=2021/9/27 18:20
 * 缓冲字符流。多个文件写入一个文件。
 *
 */
object BufferReader {
    @JvmStatic
    fun main(args: Array<String>) {
        val file = File("day2\\day2.txt")
        val file2 = File("day2\\day2out.txt")
        val file3 = File("day2\\sequenceOut.txt")
        test(file.absolutePath,file2.absolutePath,file3.absolutePath)
    }

    fun test(vararg args: String) {
        val file = File("day3\\vararg.txt")
        if (!file.exists()) {
            file.createNewFile()
        }
        val bufferedWriter = BufferedWriter(FileWriter(file))
        args.forEach {
            val bufferedReader = BufferedReader(FileReader(it))
            var lineString = bufferedReader.readLine()
            while (lineString != null) {
                println(lineString)
                bufferedWriter.write(lineString)
                bufferedWriter.newLine()
                lineString = bufferedReader.readLine()
            }

        }
        bufferedWriter.flush()
    }
}