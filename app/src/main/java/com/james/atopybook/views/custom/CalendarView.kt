package com.james.atopybook.views.custom

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.withStyledAttributes
import androidx.core.view.children
import com.james.atopybook.R
import com.james.atopybook.utlities.CalendarUtils.Companion.WEEKS_PER_MONTH
import org.joda.time.DateTime
import org.joda.time.DateTimeConstants.DAYS_PER_WEEK
import kotlin.math.max

class CalendarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = R.attr.calendarViewStyle,
    @StyleRes defStyleRes: Int = R.style.Calendar_CalendarViewStyle
) : ViewGroup(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private var _height: Float = 0f

    init {
        context.withStyledAttributes(attrs, R.styleable.CalendarView, defStyleAttr, defStyleRes) {
            _height = getDimension(R.styleable.CalendarView_dayHeight, 0f)
        }
    }

    /**
     * Measure
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val h = paddingTop + paddingBottom + max(suggestedMinimumHeight, (_height * WEEKS_PER_MONTH).toInt())
        setMeasuredDimension(getDefaultSize(suggestedMinimumWidth, widthMeasureSpec), h)
    }

    /**
     * Layout
     */
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val iWidth = (width / DAYS_PER_WEEK).toFloat()
        // +1 headerText
        val iHeight = (height / (WEEKS_PER_MONTH + 1)).toFloat()

        var index = 0
        children.forEach { view ->
            val left = (index % DAYS_PER_WEEK) * iWidth
            val top = (index / DAYS_PER_WEEK) * iHeight

            view.layout(left.toInt(), top.toInt(), (left + iWidth).toInt(), (top + iHeight).toInt())

            index++
        }
    }

    /**
     * 달력 그리기 시작한다.
     * @param firstDayOfMonth   한 달의 시작 요일
     * @param list              달력이 가지고 있는 요일과 이벤트 목록 (총 42개)
     */
    fun initCalendar(firstDayOfMonth: DateTime, list: List<DateTime>) {

        val headers = listOf<String>("S","M","T","W","T","F","S")
        headers.forEach {
            addView(DayItemView(
                context = context,
                firstDayOfMonth = firstDayOfMonth,
                headerText = it,
                date = null
            ))
        }

        list.forEach {
            addView(DayItemView(
                context = context,
                date = it,
                firstDayOfMonth = firstDayOfMonth
            ))
        }
    }
}