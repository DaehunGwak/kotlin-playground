package io.orid.cleancode.ch03functions

// 48 page

// good case
// employee 봉급 계산 부분 - factory method from 을 분리 (SRP 확보)
// Employee 는 각 하위 타입에서 각 봉급 관련 메소드를 구현할 의무가 있음 (OCP 확보)
// 어딘가에서 switch 패턴이 한번 나타나는 건 어쩔 수 없다
sealed class Employee {
    companion object {
        fun from(record: EmployeeRecord): Employee {
            return when (record.type) {
                EmployeeType.COMMISSIONED -> CommissionedEmployee.from(record)
                EmployeeType.SALARIED -> SalariedEmployee.from(record)
                EmployeeType.HOURLY -> HourlyEmployee.from(record)
                else -> throw InvalidEmployeeType(record.type)
            }
        }
    }

    abstract fun isPayday(): Boolean

    abstract fun calculatePay(): Money

    abstract fun deliverPay(pay: Money)
}

class CommissionedEmployee : Employee() {
    companion object {
        fun from(record: EmployeeRecord): CommissionedEmployee = CommissionedEmployee()
    }

    override fun isPayday(): Boolean {
        TODO("Not yet implemented")
    }

    override fun calculatePay(): Money {
        TODO("Not yet implemented")
    }

    override fun deliverPay(pay: Money) {
        TODO("Not yet implemented")
    }
}

class SalariedEmployee : Employee() {
    companion object {
        fun from(record: EmployeeRecord): SalariedEmployee = SalariedEmployee()
    }

    override fun isPayday(): Boolean {
        TODO("Not yet implemented")
    }

    override fun calculatePay(): Money {
        TODO("Not yet implemented")
    }

    override fun deliverPay(pay: Money) {
        TODO("Not yet implemented")
    }
}

class HourlyEmployee : Employee() {
    companion object {
        fun from(record: EmployeeRecord): HourlyEmployee = HourlyEmployee()
    }

    override fun isPayday(): Boolean {
        TODO("Not yet implemented")
    }

    override fun calculatePay(): Money {
        TODO("Not yet implemented")
    }

    override fun deliverPay(pay: Money) {
        TODO("Not yet implemented")
    }
}

data class EmployeeRecord(
    val type: EmployeeType,
)
