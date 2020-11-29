package com.gitpub.rosatomtasktracker.model.domain

import kotlin.math.roundToInt

object AttachmentUrlPool {
    val list: List<String> = listOf(
        "http://cdn.fishki.net/upload/post/2018/08/01/2665724/c56e88a330ff0adac87686850b8f8cbb.jpg",
        "https://kz.zebraboss.com/wp-content/uploads/items/07/85/1167941927753900785.jpg",
        "https://bigpicture.ru/wp-content/uploads/2019/09/MilitaryGiantCats12.jpg"
    )

    fun getRandom() = list.random()

    fun getRandomList(upTo: Int): List<String> {
        val size = (Math.random() * upTo).roundToInt()
        return (0..size).map { getRandom() }
    }
}
