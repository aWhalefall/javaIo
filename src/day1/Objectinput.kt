package day1

import java.io.*

/**
 * author =kuaidao@reworldgame.com
 * time=2021/9/24 18:33
 * 优点：每次读取一个对象，无需判断是否读取完成
 */
object Objectinput {

    @JvmStatic
    fun main(args: Array<String>) {
        test()
    }


    fun test() {
        //val inSrcFile = File("example2\\student.txt")
        val outDesFile = File("example2\\studentOut.txt")
        val byteArray = ByteArray(512)
        val numberRead = 0
        var objectInputStream: ObjectInputStream? = null
        var objectOutputStream: ObjectOutputStream? = null
        try {
            objectOutputStream = ObjectOutputStream(FileOutputStream(outDesFile.absolutePath))
            objectOutputStream.writeObject(Student("张三", 20))
            objectOutputStream.writeObject(Student("李四", 21))
            objectOutputStream.writeObject(Student("王五", 23))
            objectInputStream = ObjectInputStream(FileInputStream(outDesFile.absolutePath))
            println(objectInputStream.readObject())
            println(objectInputStream.readObject())
            println(objectInputStream.readObject())

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                objectInputStream?.close()
                objectInputStream?.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    internal class Student(private val name: String, private val age: Int) : Serializable {
        override fun toString(): String {
            return "Student [name=$name, age=$age]"
        }
    }


}