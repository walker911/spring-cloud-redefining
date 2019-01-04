package com.walker.proto;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

/**
 * @author walker
 * @date 2019/1/4
 */
public class PersonUseCase {
    public static void main(String[] args) {
        PersonModel.Person person = PersonModel.Person.newBuilder()
                .setId(1)
                .setName("walker")
                .setEmail("mail@163.com").build();

        for (byte b : person.toByteArray()) {
            System.out.print(b);
        }

        System.out.println("\nbytes 长度：" + person.toByteString().size());
        System.out.println("-------- byte end ---------------");

        System.out.println("-------- 反序列化开始 --------------");
        PersonModel.Person personCopy = null;
        try {
            personCopy = PersonModel.Person.parseFrom(person.toByteArray());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println(Objects.requireNonNull(personCopy).toString());
        System.out.println("-------- 反序列化结束 -------------");
    }
}
