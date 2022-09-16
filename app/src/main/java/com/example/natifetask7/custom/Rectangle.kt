package com.example.natifetask7.custom

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.natifetask7.R
import kotlin.math.min

class Rectangle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var borderWidth = DEFAULT_BORDER_WIDTH
    private var rectangleColor = DEFAULT_RECTANGLE_COLOR
    private var cornerRadius = DEFAULT_CORNER_RADIUS
    private var rect: RectF? = null

    init {
        setupAttributes(attrs)
    }

    @SuppressLint("DrawAllocation")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        val size = min(measuredWidth, measuredHeight)
//        setMeasuredDimension(size, size)
        rect = RectF(
            borderWidth / 2,
            borderWidth / 2,
            measuredWidth.toFloat() - borderWidth / 2,
            measuredHeight.toFloat() - borderWidth / 2
        )
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
        paint.color = rectangleColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas != null) {
            drawRectangle(canvas)
        }

    }

    private fun drawRectangle(canvas: Canvas) {
        rect?.let {
            canvas.drawRoundRect(
                it,
                cornerRadius,
                cornerRadius,
                paint
            )
        }
    }

    companion object {
        private const val DEFAULT_RECTANGLE_COLOR = Color.BLACK
        private const val DEFAULT_BORDER_WIDTH = 15f
        private const val DEFAULT_CORNER_RADIUS = 50f
    }
}