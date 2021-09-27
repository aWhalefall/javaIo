package day3

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.StreamTokenizer

object StreamTokenizerDemo {
    private lateinit var fileReader: FileReader

    @JvmStatic
    fun main(args: Array<String>) {
        tokenStatic()
    }

    private fun tokenStatic() {

        try {
            val file = File("day3\\article.txt")
            if (!file.exists()) {
                file.createNewFile()
            }
            fileReader = FileReader(file)
            val streamTokenizer = StreamTokenizer(BufferedReader(fileReader))
            streamTokenizer.ordinaryChar('\''.toInt())
            streamTokenizer.ordinaryChar('\"'.toInt())
            streamTokenizer.ordinaryChar('/'.toInt())
            var s: String
            var numberSum = 0
            var wordSum = 0
            var symbolSum = 0
            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                //ttype字段将包含刚读取的标记的类型
                when (streamTokenizer.ttype) {
                    StreamTokenizer.TT_EOL -> break
                    StreamTokenizer.TT_NUMBER -> {
                        s = streamTokenizer.nval.toString()
                        println("数字有 $s")
                        numberSum++
                    }
                    StreamTokenizer.TT_WORD -> {
                        s = streamTokenizer.sval.toString()
                        println("单词有 $s")
                        wordSum++
                    }
                    else -> {
                        s = streamTokenizer.ttype.toString()
                        println("标点有 $s")
                        symbolSum++
                    }
                }
            }
            println("numSize=$numberSum wordSize=$wordSum symbolSum= $symbolSum total =${numberSum + wordSum + symbolSum}")
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fileReader.close()
        }
    }
}