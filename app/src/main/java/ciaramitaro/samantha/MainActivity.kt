package ciaramitaro.samantha

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //This creates variable with initial textview vertical coordinates
        val initialTextViewTranslationY = textView_progress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            //progress is current progress level that is in the seekbar range of min..max. auto min max is 0..100
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView_progress.text = progress.toString()
                //I THINK the algo is current coordinate + current progress level * move by 5dp -1.
                val translationDistance = (initialTextViewTranslationY + progress
                        * resources.getDimension(R.dimen.text_anim_step) * -1)
                textView_progress.animate().translationY(translationDistance)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                textView_progress.setTextColor(Color.BLUE)
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                textView_progress.setTextColor(Color.BLACK)
            }

        })

        button_reset.setOnClickListener{v ->

            textView_progress.animate().rotationBy(360f).setDuration(1000)
                .translationY(initialTextViewTranslationY)
            seekBar.progress =0



        }
    }
}
