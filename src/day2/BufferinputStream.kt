package day2

import java.io.*

/**
 * author =kuaidao@reworldgame.com
 * time=2021/9/26 14:28
 * 缓冲区概念引入
 * 1.等待缓冲区满进行序列化
 * 2.设置每次读取字节个数
 * 3.一个是立马写入本地磁盘，缓存区满进行一次性写入
 */
object BufferinputStream {

    @JvmStatic
    fun main(args: Array<String>) {
//        bufferInputTest1()
        bufferInputTest2()
    }

}

private fun bufferInputTest1() {
    val inSrcFile = File("day2\\day2.txt")
    val fileInputStream = FileInputStream(inSrcFile)
    val bufferInputStream = BufferedInputStream(fileInputStream)
    val byteArray = ByteArray(512)
    try {
        var bytesRead = bufferInputStream.read(byteArray)
        while (bytesRead != -1) {
            val chunk = String(byteArray, 0, bytesRead)
            println(chunk)
            bytesRead = bufferInputStream.read(byteArray)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            bufferInputStream.close()
            fileInputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
private fun bufferInputTest2() {
    val inSrcFile = File("day2\\day2.txt")
    val outDesFile = File("day2\\day2out.txt")
    val fileInputStream = FileInputStream(inSrcFile)
    val bufferInputStream = BufferedInputStream(fileInputStream)

    if(!outDesFile.exists()){
        outDesFile.createNewFile()
    }
    val fileOutputStream=FileOutputStream(outDesFile)
    val bufferedOutputStream=BufferedOutputStream(fileOutputStream)

    val byteArray = ByteArray(512)
    try {
        var bytesRead = bufferInputStream.read(byteArray)
        while (bytesRead != -1) {
            val chunk = String(byteArray, 0, bytesRead)
            println(chunk)
            bufferedOutputStream.write(byteArray,0,bytesRead)
            bytesRead = bufferInputStream.read(byteArray)
        }
        bufferedOutputStream.flush()
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            bufferInputStream.close()
            fileInputStream.close()
            fileOutputStream.close()
            bufferInputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}


