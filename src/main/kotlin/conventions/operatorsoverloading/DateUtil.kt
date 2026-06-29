package conventions.operatorsoverloading

import java.util.Calendar

fun MyDate.followingDate(): MyDate {
    val c = Calendar.getInstance()
    c.set(year, month - 1, dayOfMonth)

    val millisecondsInDay = 24 * 60 * 60 * 1000L
    val timeInMillis = c.timeInMillis + millisecondsInDay

    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis

    return MyDate(
        result.get(Calendar.YEAR),
        result.get(Calendar.MONTH) + 1,
        result.get(Calendar.DAY_OF_MONTH)
    )
}

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, amount: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year + if (timeInterval == TimeInterval.YEAR) amount else 0, month - 1, dayOfMonth)

    var timeInMillis = c.timeInMillis
    val millisecondsInDay = 24 * 60 * 60 * 1000L

    timeInMillis += amount * when (timeInterval) {
        TimeInterval.DAY -> millisecondsInDay
        TimeInterval.WEEK -> 7 * millisecondsInDay
        TimeInterval.YEAR -> 0L
    }

    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis

    return MyDate(
        result.get(Calendar.YEAR),
        result.get(Calendar.MONTH) + 1,
        result.get(Calendar.DAY_OF_MONTH)
    )
}
