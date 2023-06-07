package com.example.kotestmockkstudy

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ShouldSpecTest : ShouldSpec() {

    init {
        //funspec이랑 비슷하지만, should를 통해 작성한다.
        should("String.length should return the length of the string") {
            val name = "hello kotest!"
            val actual = name.length
            actual shouldBe 13
        }

        context("toInt") {
            should("given number string should return integer value") {
                val number = "12345"
                val actual = number.toInt()
                actual shouldBe 12345
            }

            should("given not number string should return exception") {
                val str = "not a number"
                shouldThrow<NumberFormatException> {
                    str.toInt()
                }
            }
        }
    }

}