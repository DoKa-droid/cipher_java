package com.example;

import com.example.caesar.Caesar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.caesar.Caesar.checkArgs;

class CipherTest {

    @Test
    void encryptTest() {
        Assertions.assertEquals(Caesar.encrypt("Task At QA", 3), "Wdvn Dw TD");
    }

    @Test
    void fewArgsTest() {
        String[] args = {"-e", "-o"};
        Assertions.assertFalse(checkArgs(args));
    }

    @Test
    void manyArgsTest() {
        String[] args = {"-e", "Test", "-o", "3", "-f"};
        Assertions.assertFalse(checkArgs(args));
    }

    @Test
    void wrongArgsTest() {
        String[] args = {"-f", "Test", "-o", "-3"};
        Assertions.assertFalse(checkArgs(args));
    }

    @Test
    void notPositiveOffsetTest() {
        String[] args = {"-e", "Test", "-o", "-3"};
        Assertions.assertFalse(checkArgs(args));
    }

    @Test
    void noArgsTest() {
        String[] args = {};
        Assertions.assertFalse(checkArgs(args));
    }

    @Test
    void reverseArgsTest() {
        Assertions.assertEquals(Caesar.encrypt(3, "Task At QA"), "Wdvn Dw TD");
    }

    @Test
    void decryptTest() {
        Assertions.assertEquals(Caesar.decrypt("Task At QA", 3), "Qxph Xq NX");
    }

    @Test
    void otherEncodingTest() {
        String[] args = {"-e", "Задание с тестами", "-o", "3"};
        Assertions.assertFalse(checkArgs(args));
    }
}
