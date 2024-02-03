package io.orid.clean_code.ch03_functions

// page 47

// bad case
// 1. 함수가 길다. 직원 유형이 추가될 때마다 함수 길이가 길어진다.
//    > OCP (Open Closed Principle) 위반 (확장에 열려있고, 변경에 닫혀 있어야 함)
// 2. '한 가지' 작업만 수행하지 않는다.
//    > SRP (Single Responsibility Principle) 위반
fun calculatePay(employee: BadEmployee): Money {
    return when (employee.type) {
        EmployeeType.COMMISSIONED ->
            calculateCommissionedPay(employee)
        EmployeeType.HOURLY ->
            calculateHourlyPay(employee)
        EmployeeType.SALARIED ->
            calculateSalariedPay(employee)
        else ->
            throw InvalidEmployeeType(employee.type)
    }
}

fun calculateCommissionedPay(employee: BadEmployee): Money {
    TODO("Not yet implemented")
}

fun calculateHourlyPay(employee: BadEmployee): Money {
    TODO("Not yet implemented")
}

fun calculateSalariedPay(employee: BadEmployee): Money {
    TODO("Not yet implemented")
}

class InvalidEmployeeType(type: EmployeeType)
    : Exception("${type.name} is a invalid employee type")

class BadEmployee(
    var type: EmployeeType,
)

enum class EmployeeType {
    COMMISSIONED,
    HOURLY,
    SALARIED,
    NOT_DEFINED,
}

data class Money(
    val dollars: Double,
)