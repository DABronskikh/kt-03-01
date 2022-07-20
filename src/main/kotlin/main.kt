fun main() {
    val time = 60 * 7 * 1
    println(agoToText(time))
}

fun agoToText(time: Int): String {
    val minute = 60
    val hour = minute * minute
    return "был(а) в сети " + when {
        (time <= minute) -> "только что"
        (time >= minute + 1 && time <= hour) -> getMinutes(time)
        (time >= hour + 1 && time < 24 * hour) -> getHours(time)
        (time >= 24 * hour && time <= 24 * hour * 2) -> "сегодня"
        (time >= 24 * hour * 2 + 1 && time <= 24 * hour * 3) -> "вчера"
        else -> "давно"
    }
}

fun getMinutes(time: Int): String {
    val minutes = time / 60
    var text = " минут"
    when {
        (minutes % 10 == 1 && minutes % 100 != 11) -> text = " минуту"
        (minutes % 10 in intArrayOf(2, 3, 4) && minutes % 100 !in intArrayOf(12, 13, 14)) -> text = " минуты"
    }
    return (minutes % 100).toString() + text + " назад"
}

fun getHours(time: Int): String {
    val hours = time / 60 / 60
    var text = " часов"
    when {
        (hours % 10 == 1 && hours % 100 != 11) -> text = " час"
        (hours % 10 in intArrayOf(2, 3, 4) && hours % 100 !in intArrayOf(12, 13, 14)) -> text = " часа"
    }
    return (hours % 100).toString() + text + " назад"
}
