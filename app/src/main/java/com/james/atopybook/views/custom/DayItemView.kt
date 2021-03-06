package com.james.atopybook.views.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.withStyledAttributes
import com.james.atopybook.R
import com.james.atopybook.utlities.CalendarUtils.Companion.getDateColor
import com.james.atopybook.utlities.CalendarUtils.Companion.isSameMonth

import org.joda.time.DateTime

class DayItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes private val defStyleAttr: Int = R.attr.itemViewStyle,
    @StyleRes private val defStyleRes: Int = R.style.Calendar_ItemViewStyle,
    private val date: DateTime?,
    private val firstDayOfMonth: DateTime = DateTime(),
    private val headerText:String?=null
    ) : View(ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr) {

    private val bounds = Rect()

    private var paint: Paint = Paint()

    init {
        /* Attributes */
        context.withStyledAttributes(attrs, R.styleable.CalendarView, defStyleAttr, defStyleRes) {
            val dayTextSize = getDimensionPixelSize(R.styleable.CalendarView_dayTextSize, 0).toFloat()

            /* 흰색 배경에 유색 글씨 */
            paint = TextPaint().apply {
                isAntiAlias = true
                textSize = dayTextSize
                color = date?.dayOfWeek?.let {
                        getDateColor(it)
                    } ?: Color.parseColor("#000000")

                date?.let {
                    if (!isSameMonth(date, firstDayOfMonth)) {
                        alpha = 0
                    }
                }

            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return

        val text = date?.dayOfMonth?.toString() ?: headerText ?: ""
        paint.getTextBounds(text, 0, text.length, bounds)
        canvas.drawText(
            text,
            (width / 2 - bounds.width() / 2).toFloat() - 2,
            (height / 2 + bounds.height() / 2).toFloat(),
            paint
        )
    }
}