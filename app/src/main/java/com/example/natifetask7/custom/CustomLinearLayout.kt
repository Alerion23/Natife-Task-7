package com.example.natifetask7.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import com.example.natifetask7.R

class CustomLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    private var size = 18
    private var textColor: Int = 0
    private var textBackground: Int = 0
    private var padding = 4

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_component_view, this, true)
        orientation = VERTICAL
        textColor = context.getColor(R.color.white)
        textBackground = context.getColor(R.color.black)
    }

    fun addTextView(someText: String) {
        val textView = TextView(context)
        textView.apply {
            setTextColor(textColor)
            setBackgroundColor(textBackground)
            textSize = size.toFloat()
            setPadding(padding)
            text = someText
        }
        addView(textView)

    }

}