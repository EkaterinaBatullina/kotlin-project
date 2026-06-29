package conventions.operatorsoverloading

import conventions.operatorsoverloading.TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval { DAY, WEEK, YEAR }

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate =
    addTimeIntervals(timeInterval, amount = 1)

operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval): MyDate =
    addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)

operator fun TimeInterval.times(number: Int) =
    RepeatedTimeInterval(this, number)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
