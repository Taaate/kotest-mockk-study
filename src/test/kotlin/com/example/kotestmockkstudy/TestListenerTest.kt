package com.example.kotestmockkstudy

import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult

class TestListenerTest: StringSpec() {

    override fun beforeSpec(spec: Spec) {
        println("beforeSpec >> spec이 정해지고 맨처음 한번 실행")
    }

    override fun beforeContainer(testCase: TestCase) {
        println("beforeContainer >> 테스트컨테이너 실행 시 실행")
    }

    override fun beforeAny(testCase: TestCase) {
        println("beforeAny >> TestCase Instance를 파라미터로 가진 테스트실행 전 실행")
    }

    override fun beforeEach(testCase: TestCase) {
        println("beforeEach >> ")
    }

    override fun beforeTest(testCase: TestCase) {
        println("beforeTest >> [각 테스트실행 전에 실행] ${testCase.displayName} 시작합니다.")

    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        println("afterTest >> [각 테스트실행이 완료된 후에 실행, 테스트가 실패해도 실행됩니다] 테스트 ${testCase.displayName} 의 결과는 $result 입니다.")
    }

    init {
        "테스트1" {
            println("테스트1 입니다.")
        }

        "테스트2" {
            println("테스트2 입니다.")
        }
    }
}