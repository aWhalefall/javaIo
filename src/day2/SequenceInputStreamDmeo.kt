package day2

import java.io.*
import java.util.*

object SequenceInputStreamDmeo {
    @JvmStatic
    fun main(args: Array<String>) {
//        test1()
        test2()
    }

    private fun test1() {
//        val inputstreamList = mutableListOf<FileInputStream>()
//        inputstreamList.add(FileInputStream(File("day2\\day2.txt")))
//        inputstreamList.add(FileInputStream(File("day2\\day2Out.txt")))
//        val sequenceInputStream = SequenceInputStream(inputstreamList[0], inputstreamList[1])

        val vector = Vector<InputStream>()
        vector.add(FileInputStream(File("day2\\day2.txt")))
        vector.add(FileInputStream(File("day2\\day2Out.txt")))
        val enumeration = vector.elements()
        val sequenceInputStream = SequenceInputStream(enumeration)
        val byteArray = ByteArray(200)

        try {
            var numByte = sequenceInputStream.read(byteArray)
            while (numByte != -1) {
                val string = String(byteArray, 0, numByte)
                println(string)
                numByte = sequenceInputStream.read(byteArray)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            sequenceInputStream.close()
        }


    }

    private fun test2() {
        val vector = Vector<InputStream>()
        vector.add(FileInputStream(File("day2\\day2.txt")))
        vector.add(FileInputStream(File("day2\\day2Out.txt")))
        val enumeration = vector.elements()
        val sequenceInputStream = SequenceInputStream(enumeration)
        val byteArray = ByteArray(200)

        val sequencePath = File("day2\\sequenceOut.txt")
        if (!sequencePath.exists()) {
            sequencePath.createNewFile()
        }
        val bufferedOutputStream = BufferedOutputStream(FileOutputStream(sequencePath))

        try {
            var numByte = sequenceInputStream.read(byteArray)
            while (numByte != -1) {
                val string = String(byteArray, 0, numByte)
                println(string)
                bufferedOutputStream.write(byteArray, 0, numByte)
                numByte = sequenceInputStream.read(byteArray)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                sequenceInputStream.close()
                bufferedOutputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }
}