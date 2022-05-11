package com.theoxao.dura.good.utils

import net.sourceforge.pinyin4j.PinyinHelper
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType.UPPERCASE
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType.WITHOUT_TONE
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType.WITH_V


fun String.py(short:Boolean = false):String {
    val format = HanyuPinyinOutputFormat().apply {
        this.toneType= WITHOUT_TONE
        this.vCharType = WITH_V
        this.caseType = UPPERCASE
    }
    return this.toCharArray().joinToString("") {char->
        PinyinHelper.toHanyuPinyinStringArray(char, format).getOrNull(0)?.let { if (short) it.first().toString() else it }?:char.toString()
    }
}

fun String.pys():String = this.py(true)
