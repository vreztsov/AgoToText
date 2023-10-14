package ru.netology

fun main() {
    println(agoToText(30))
    println(agoToText(1 * 60 + 20))
    println(agoToText(2 * 60 + 20))
    println(agoToText(5 * 60 + 20))
    println(agoToText(10 * 60 + 20))
    println(agoToText(11 * 60 + 20))
    println(agoToText(54 * 60 + 20))
    println(agoToText(1 * 60 * 60 + 20))
    println(agoToText(8 * 60 * 60 + 20))
    println(agoToText(13 * 60 * 60 + 20))
    println(agoToText(23 * 60 * 60 + 20))
    println(agoToText(1 * 24 * 60 * 60 + 20))
    println(agoToText(2 * 24 * 60 * 60 + 20))
    println(agoToText(5 * 24 * 60 * 60 + 20))
}

fun agoToText(time: Int): String {
    val ago: String = getTimeText(time)
    return "был(а) в сети $ago"
}

fun getTimeText(time: Int): String {
    val unit: String
    val num: Int
    when {
        time >= 0 && time <= 60 -> return "только что"
        time >= 61 && time <= 60 * 60 -> {
            num = time / 60
            unit = getMinuteWord(num)
            return "$num $unit назад"
        }
        time >= 60 * 60 + 1 && time <= 24 * 60 * 60 -> {
            num = time / (60 * 60)
            unit = getHourWord(num)
            return "$num $unit назад"
        }
        time >= 24 * 60 * 60 + 1 && time <= 2 * 24 * 60 * 60 -> return "вчера"
        time >= 2 * 24 * 60 * 60 + 1 && time <= 3 * 24 * 60 * 60 -> return "позавчера"
        time > 3 * 24 * 60 * 60 -> return "давно"
        else -> return ""
    }
}

fun getMinuteWord(time: Int): String {
    val is1020 = time % 100 > 10 && time % 100 < 20
    if (!is1020) {
        when (time % 10) {
            1 -> return "минуту"
            2, 3, 4 -> return "минуты"
        }
    }
    return "минут"
}

fun getHourWord(time: Int): String {
    val is1020 = time % 100 > 10 && time % 100 < 20
    if (!is1020) {
        when (time % 10) {
            1 -> return "час"
            2, 3, 4 -> return "часа"
        }
    }
    return "часов"
}