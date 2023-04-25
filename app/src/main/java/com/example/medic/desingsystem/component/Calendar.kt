package com.example.medic.desingsystem.component

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.util.*

@Composable
fun Calendar(show:Boolean):String{
    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    fun convert(int: Int): String {
        when (int) {
            1 -> return "январь"
            2 -> return "февраль"
            3 -> return "март"
            4 -> return "апрель"
            5 -> return "май"
            6 -> return "июнь"
            7 -> return "июль"
            8 -> return "август"
            9 -> return "сентябрь"
            10 -> return "октябрь"
            11 -> return "ноябрь"
            12 -> return "декабрь"
        }
        return ""

    }

    // store date in string format
    val mDate = remember { mutableStateOf("") }
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth ${convert(mMonth + 1)} $mYear"
        }, mYear, mMonth, mDay
    )
    if(show){
        mDatePickerDialog.show()
    }
    return mDate.value
}