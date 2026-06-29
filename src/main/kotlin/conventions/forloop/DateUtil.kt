package conventions.forloop

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
