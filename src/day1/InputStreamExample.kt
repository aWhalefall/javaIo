package day1

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

/**
 * author =kuaidao@reworldgame.com
 * time=2021/9/24 16:54
 * 1.缓存大小设置：会影响到耗时操作
 * 2.不加缓存直接读取写入，耗时会增加30倍
 * 3.编码问题不统一会导致乱码。默认utf-8可以解决
 */
object InputStreamExample {

    var currenetTime=0L;
    @JvmStatic
    fun main(args: Array<String>) {
        currenetTime= System.currentTimeMillis()
        readFile()
        println("readFile 耗时 ${System.currentTimeMillis()- currenetTime}")
        currenetTime= System.currentTimeMillis()
        readFile2()
        println("readFile2 耗时 ${System.currentTimeMillis()- currenetTime}")
        readFile3()
    }

    fun readFile() {
        var buffer = ByteArray(500)
        println("buffer default =${Arrays.toString(buffer)}")
        val inSrcFile = File("example\\day1.txt")
        println("file bytes = ${inSrcFile.length()}")
        val outDesFile = File("example\\outputday1.txt")
        val input = FileInputStream(inSrcFile)
        val outPut = FileOutputStream(outDesFile)
        var numberRead = 0
        try {
            numberRead = input.read(buffer)
            println("首次读取$numberRead buffer =${Arrays.toString(buffer)}")
            while ((numberRead) != -1) {
                //numberRead的目的在于防止最后一次读取的字节小于buffer长度，
                outPut.write(buffer, 0, numberRead);
                //否则会自动被填充0
                numberRead = input.read(buffer)
                println("循环$numberRead buffer =${Arrays.toString(buffer)}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                input.close()
                outPut.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun readFile2() {
        val inSrcFile = File("example\\day1.txt")
        println("file bytes = ${inSrcFile.length()}")
        val outDesFile = File("example\\outputday1.txt")
        val input = FileInputStream(inSrcFile)
        val outPut = FileOutputStream(outDesFile)
        var count = 0
        try {
            var code = input.read()
            while (code != -1) {
                count++
                outPut.write(code)
                //numberRead的目的在于防止最后一次读取的字节小于buffer长度，
                 code = input.read()
                println("count =$count buffer =${code}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                input.close()
                outPut.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        print("count$count")
    }

    /**
     * ASCii 低 7位代表对应值。第八位0
     * https://tool.ip138.com/ascii_code/
     */
    fun readFile3(){
        val outDesFile = File("example\\outputday2.txt")
        val outPut = FileOutputStream(outDesFile)
        outPut.write(127)
        outPut.close()
    }

}