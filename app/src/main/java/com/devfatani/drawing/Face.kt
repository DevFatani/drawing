package com.devfatani.drawing

/**
 * Created by devfatani on 11/2/16.
 */
import android.graphics.*

class Face(radius: Float) {

    var facePaint: Paint? = null
    var mePaint: Paint? = null

    var radius: Float = 0f
    var adjust: Float = 0f

    var mouthLeftX: Float = 0f
    var mouthRightX: Float = 0f
    var mouthTopY: Float = 0f
    var mouthBottomY: Float = 0f

    var mouthRectF: RectF? = null
    var mouthPath: Path? = null

    var eyeLeftRectF: RectF? = null
    var eyeRightRectF: RectF? = null

    var eyeLeftX: Float = 0f
    var eyeRightx: Float = 0f
    var eyeTopY: Float = 0f
    var eyeBottomY: Float = 0f

    init {
        this.radius = radius
        this.facePaint = Paint()
        this.facePaint!!.color = 0xfffed325.toInt()
        this.facePaint!!.isDither = true
        this.facePaint!!.strokeJoin = Paint.Join.ROUND
        this.facePaint!!.strokeCap = Paint.Cap.ROUND
        this.facePaint!!.pathEffect = CornerPathEffect(10f)
        this.facePaint!!.isAntiAlias = true
        this.facePaint!!.setShadowLayer(4f, 2f, 2f, 0x80000000.toInt())

        this.mePaint = Paint()
        this.mePaint!!.color = 0xff2a2a2a.toInt()
        this.mePaint!!.isDither = true
        this.mePaint!!.style = Paint.Style.STROKE
        this.mePaint!!.strokeJoin = Paint.Join.ROUND
        this.mePaint!!.strokeCap = Paint.Cap.ROUND
        this.mePaint!!.pathEffect = CornerPathEffect(10f)
        this.mePaint!!.isAntiAlias = true
        this.mePaint!!.strokeWidth = this.radius / 14.0f

        this.adjust = this.radius / 3.2f


        //Left eye
        this.eyeLeftX = this.radius - (this.radius * .43f)
        this.eyeRightx = this.eyeLeftX + (this.radius * .3f)
        this.eyeTopY = this.radius - (this.radius * .5f)
        this.eyeBottomY = this.eyeTopY + (this.radius * .4f)


        this.eyeLeftRectF =
                RectF(this.eyeLeftX + this.adjust, this.eyeTopY + this.adjust, this.eyeRightx + this.adjust, this.eyeBottomY + this.adjust)

        //Right eye
        this.eyeLeftX = this.eyeRightx + (this.radius * .3f)
        this.eyeRightx = this.eyeLeftX + (this.radius * .3f)

        this.eyeRightRectF =
                RectF(this.eyeLeftX + this.adjust, this.eyeTopY + this.adjust, this.eyeRightx + this.adjust, this.eyeBottomY + this.adjust)

        // Smiley Mouth
        this.mouthLeftX = this.radius - (this.radius / 2.0f)
        this.mouthRightX = mouthLeftX + this.radius
        this.mouthTopY = this.radius - (this.radius * .2f)
        this.mouthBottomY = mouthTopY + (this.radius * .5f)

        this.mouthRectF =
                RectF(this.mouthLeftX + this.adjust, this.mouthTopY + this.adjust, this.mouthRightX + this.adjust, this.mouthBottomY + this.adjust)

        this.mouthPath = Path()
        this.mouthPath!!.arcTo(this.mouthRectF, 30f, 120f, true)
    }


    fun draw(canvas: Canvas) {
        canvas.drawCircle(this.radius + this.adjust, this.radius + this.adjust, this.radius, this.facePaint)

        this.mePaint!!.style = Paint.Style.STROKE
        canvas.drawPath(this.mouthPath, this.mePaint)

        this.mePaint!!.style = Paint.Style.FILL
        canvas.drawArc(this.eyeLeftRectF, 0f, 160f, true, this.mePaint)
        canvas.drawArc(this.eyeRightRectF, 0f, 360f, true, this.mePaint)

    }

}