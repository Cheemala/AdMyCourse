package com.cheemala.addmycourse.data

import androidx.room.TypeConverter


class DatabaseTypeConverter {
    private val seperator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        for (item in list) {
            stringBuilder.append(item).append(seperator)
        }
        stringBuilder.setLength(stringBuilder.length - seperator.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(myString: String): List<String> {
        return myString.split(seperator)
    }
}