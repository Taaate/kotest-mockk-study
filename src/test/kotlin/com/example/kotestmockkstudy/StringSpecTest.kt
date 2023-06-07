package com.example.kotestmockkstudy

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.*
import kotlin.math.max

class StringSpecTest :StringSpec() {

    init {

        val testStr = "I am iron man"
        val testNum = 5
        val testList = listOf<String>("iron", "bronze", "silver")

        "strings.length 는 문자열의 길이를 리턴해야 한다" {
            "hello".length shouldBe 5
        }

        "일치 하는지" {
            testStr shouldBe "I am iron man"
        }

        "일치 하지 않는지" {
            testStr shouldNotBe "I am xxx man"
        }

        "해당 문자열로 시작하는지" {
            testStr shouldContain "iron"
        }

        "리스트에서 해당 리스트의 값들이 모두 포함 되는지" {
            testList shouldContainAll listOf("iron", "silver")
        }

        "대소문자 무시하고 일치 하는지" {
            testStr shouldBeEqualIgnoringCase "I AM IRON MAN"
        }

        "보다 크거나 같은지" {
            testNum shouldBeGreaterThanOrEqualTo 3
        }

        "해당 문자열과 길이가 같은지" {
            testStr shouldHaveSameLengthAs "I AM SUPERMAN"
        }

        "문자열 길이" {
            testStr shouldHaveLength 13
        }

        "여러개 체이닝" {
            testStr.shouldStartWith("I").shouldHaveLength(13).shouldContainIgnoringCase("IRON")
        }

        "두가지 숫자중 큰 수 리턴" {
            max(2,3) shouldBe 3
            max(0, 0) shouldBe 0
            max(4, -1) shouldBe 4
            max(-2, -1) shouldBe -1
        }



    }

    init {
        "ArithmeticException 발생 확인" {
            val exception = shouldThrow<ArithmeticException> {
                1 / 0
            }
            exception.message shouldStartWith ("/ by zero")
        }

        "예외 발생 확인" {
            val exception = shouldThrowAny {
                1 / 0
            }
            exception.message shouldStartWith ("/ by zero")
        }
    }

}