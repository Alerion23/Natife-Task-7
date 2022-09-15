package com.example.natifetask7.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.natifetask7.R

class Rectangle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var borderWidth = DEFAULT_BORDER_WIDTH
    private var rectangleColor = DEFAULT_RECTANGLE_COLOR
    private var cornerRadius = DEFAULT_CORNER_RADIUS

    init {
        setupAttributes(attrs)
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs, R.styleable.Rectangle, 0, 0
        ).apply {
            borderWidth =
                getDimension(R.styleable.Rectangle_borderWidth, DEFAULT_BORDER_WIDTH)
            rectangleColor =
                getColor(R.styleable.Rectangle_rectangleColor, DEFAULT_RECTANGLE_COLOR)
            cornerRadius =
                getDimension(R.styleable.Rectangle_cornerRadius, DEFAULT_CORNER_RADIUS)
        }
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas != null) {
            drawRectangle(canvas)
        }

    }

    private fun drawRectangle(canvas: Canvas) {
        val rect = RectF(
            20f,
            20f,
            canvas.width.toFloat() - 20f,
            canvas.height.toFloat() - 20f
        )
        paint.color = rectangleColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        canvas.drawRoundRect(
            rect,
            cornerRadius,
            cornerRadius,
            paint
        )
    }

    companion object {
        private const val DEFAULT_RECTANGLE_COLOR = Color.BLACK
        private const val DEFAULT_BORDER_WIDTH = 15f
        private const val DEFAULT_CORNER_RADIUS = 50f
    }
}