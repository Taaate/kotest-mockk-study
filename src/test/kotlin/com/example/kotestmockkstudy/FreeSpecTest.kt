package com.example.kotestmockkstudy

import io.kotest.assertions.asClue
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.withClue
import io.kotest.core.datatest.forAll
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.shouldBe

class FreeSpecTest : FreeSpec() {

    init {
        "Clues" - {
            data class HttpResponse(val status: Int, val body: String)
            val response = HttpResponse(404, "the content")

            "Not Use Clues" {
                response.status shouldBe 200
                response.body shouldBe "the content"
            }
            "With Clues" {
                withClue("status는 200이여야 되고 body 에는 'the content' 여야 한다.") {
                    response.status shouldBe 200
                    response.body shouldBe "the content"
                }
            }
            "As Clues" {
                response.asClue {
                    it.status shouldBe 200
                    it.body shouldBe "the content"
                }
            }
        }

        "Soft Assertions" - {
            val testStr = "I am iron man"
            val testNum = 5

            "Not Soft" {
                testStr shouldBe "IronMan"
                testNum shouldBe 1
                // 결과: expected:<"IronMan"> but was:<"I am iron man">
            }
            "Use Soft" {
                assertSoftly {
                    testStr shouldBe "IronMan"
                    testNum shouldBe 1
                }
                // 결과: expected:<"IronMan"> but was:<"I am iron man">
                //      expected:<1> but was:<5>
            }
        }

    }

}