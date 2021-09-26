package day2.reader

import java.io.*

object PrintReaderDemo {
    @JvmStatic
    fun main(args: Array<String>) {
//        test()
        test2()
    }

    fun test() {
        val reader = InputStreamReader(FileInputStream(File("day2\\day2.txt")))
        val charArray = CharArray(200)
        var num = reader.read(charArray)
        while (num != -1) {
            println(String(charArray, 0, num))
            num = reader.read(charArray)
        }
        reader.close()
    }

    fun test2() {
        val fileReader = FileReader(File("day2\\day2.txt"))
        val charArray = CharArray(200)
        var num = fileReader.read(charArray)
        while (num != -1) {
            println(String(charArray, 0, num))
            num = fileReader.read(charArray)
        }
        fileReader.close()
    }
//    fun test2() {
//
//        val fileReader = FileReader(File("day2\\day2.txt"))
//        val buffReader=BufferedReader(fileReader)
//        val charArray = CharArray(200)
//        var line=buffReader.readLine()
//        while (line!=null) {
//           println()lin
//            num = fileReader.read(charArray)
//        }
//        fileReader.close()
//    }
}