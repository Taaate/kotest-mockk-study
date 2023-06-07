package com.example.kotestmockkstudy

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.NumberFormatException

class FunSpecTest : FunSpec() {

    init {
        // 테스트가 의미하는 내용을 작성
        test("String.length should return the length of the string") {
            val name = "hello kotest!"
            val actual = name.length
            actual shouldBe 13
        }

        //context를 통해서 중첩해서 가능
        context("toInt") {
            test("given number string should return integer value") {
                val number = "12345"
                val actual = number.toInt()
                actual shouldBe 12345
            }

            test("given not number string should return exception") {
                val str = "not a number"
                shouldThrow<NumberFormatException> {
                    str.toInt()
                }
            }
        }
    }
}