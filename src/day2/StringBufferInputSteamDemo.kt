package day2

import java.io.StringBufferInputStream

/**
 * author =kuaidao@reworldgame.com
 * time=2021/9/26 17:13
 * 字符串转字符
 * https://vimsky.com/examples/usage/java-stringbufferinputstream-available-method-with-example-02.html
 */
object StringBufferInputSteamDemo {
    @JvmStatic
    fun main(args: Array<String>) {
        val stringBufferStream = StringBufferInputStream("Java Programming");
        var num = stringBufferStream.read()

        while (num != -1) {
            val char = num.toChar()
            println("available size =${stringBufferStream.available()}")
            println(char)
            num = stringBufferStream.read()
        }
        stringBufferStream.close()
    }
}