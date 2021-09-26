package day1;

import day1.model.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DataInput {

    public static void main(String[] args) {
        try {
            List memberList = new ArrayList<Member>();
            List memberList2 = new ArrayList<Member>();
            memberList.add(new Member("yang2", 2));
            memberList.add(new Member("yang20", 20));
            memberList.add(new Member("yang40", 40));

            File outDesFile = new File("example2\\dataMember.txt");
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outDesFile.getAbsolutePath()));
            memberList.forEach(new Consumer<Member>() {
                @Override
                public void accept(Member it) {
                    try {
                        dataOutputStream.writeUTF(it.getName());
                        dataOutputStream.writeInt(it.getAge());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            dataOutputStream.flush();
            dataOutputStream.close();
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(outDesFile.getAbsolutePath()));
            //读出数据并还原为对象
            for (int i = 0; i < memberList.size(); i++) {
                //读出UTF字符串
                String name = dataInputStream.readUTF();
                //读出int数据
                int score = dataInputStream.readInt();
                memberList2.add(new Member(name, score));
            }
            //关闭流
            dataInputStream.close();
            for (int i = 0; i < memberList2.size(); i++) {
                Member member = (Member) memberList2.get(i);
                System.out.printf("%s\t%d%n", member.getName(), member.getAge());

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
