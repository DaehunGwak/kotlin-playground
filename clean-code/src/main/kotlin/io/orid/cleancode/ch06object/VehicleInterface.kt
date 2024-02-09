package io.orid.cleancode.ch06object

// bad case
interface VehicleBad {
    var fuelTankCapacityInGallons: Double // var: getter, setter 자동 생성
    val gallonsOfGasoline: Double // val: getter 만 자동 생성
}

// good case: 단순 getter, setter X
interface Vehicle {
    val percentFuelRemaining: Double
        get() = TODO("fuelTankCapacityInGallons 과 gallonsOfGasoline 을 사용한 구현")
}
