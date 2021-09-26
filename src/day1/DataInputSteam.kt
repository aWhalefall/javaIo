package day1

import day1.model.Member
import java.io.DataOutputStream
import java.io.File
import java.io.FileOutputStream

object DataInputSteam {

    @JvmStatic
    fun main(args: Array<String>) {

        test(args)

    }

    fun test(args: Array<String>) {
        val memberList = mutableListOf<Member>()
        memberList.add(Member("yang2",2))
        memberList.add(Member("yang20",20))
        memberList.add(Member("yang40",40))

        val outDesFile = File("example\\dataMember.txt")
        val dataOutputStream = DataOutputStream(FileOutputStream(args[0]))
        memberList.forEach {
            dataOutputStream.writeUTF(it.name)
            dataOutputStream.writeInt(it.age)
        }
        dataOutputStream.flush()
        dataOutputStream.close()

    }
}