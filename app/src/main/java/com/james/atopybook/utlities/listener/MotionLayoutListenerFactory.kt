package com.james.atopybook.utlities.listener

import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.alpha
import com.james.atopybook.R

class MotionLayoutListenerFactory {
    companion object{
        fun create(startListener:(()->Unit)?=null,changeListener:(()->Unit)?=null,completeListener:(()->Unit)?=null,triggerListener:(()->Unit)?=null):MotionLayout.TransitionListener{
            return object : MotionLayout.TransitionListener {
                override fun onTransitionStarted(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int
                ) {
                    startListener?.invoke()
                }

                override fun onTransitionChange(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float
                ) {
                    changeListener?.invoke()
                }

                override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                   completeListener?.invoke()
                }

                override fun onTransitionTrigger(
                    motionLayout: MotionLayout?,
                    triggerId: Int,
                    positive: Boolean,
                    progress: Float
                ) {
                    triggerListener?.invoke()
                }
            }
        }
    }
}