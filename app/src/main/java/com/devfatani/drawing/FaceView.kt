package com.devfatani.drawing

import android.view.View
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log

/**
 * Created by devfatani on 11/2/16.
 */
class FaceView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var radius: Float = 0f
    var face: Face? = null

    init {
//        Log.v(toString(), "FaceView::init")
        val a = this.context.theme.obtainStyledAttributes(attrs, R.styleable.FaceView, 0, 0)
        try {
            this.radius = a.getDimension(R.styleable.FaceView_radius, 20f)
        } finally {
            a.recycle()
        }

        this.face = Face(this.radius)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        this.face!!.draw(canvas!!)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val desiredWidth: Int = (this.radius * 2).toInt() + (Math.ceil(this.radius / 1.70)).toInt()
        val desiredHeight: Int = (this.radius * 2).toInt() + (Math.ceil(this.radius / 1.70)).toInt()
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val width: Int
        val height: Int

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize)
        } else {
            width = desiredWidth
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize)
        } else {
            height = desiredHeight
        }


        this.setMeasuredDimension(width, height)

    }


}