package com.taknikiniga.furnitureapp.fragments.utils



import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import androidx.core.content.ContextCompat
import com.taknikiniga.furnitureapp.R


class SimpleSpanBuilder(context: Context) {
    private val spanSections: MutableList<SpanSection>
    private val stringBuilder: StringBuilder
    var relativeSmallSpan: RelativeSizeSpan
    private val context: Context

    init {
        this.context = context
        stringBuilder = StringBuilder()
        spanSections = ArrayList()
        relativeSmallSpan = RelativeSizeSpan(0.8f)
    }

    fun append(text: String, formattingStyle: Int): SimpleSpanBuilder {
        spanSections.add(SpanSection(text, stringBuilder.length, formattingStyle))
        stringBuilder.append(text)
        return this
    }

    fun build(): SpannableStringBuilder {
        val ssb = SpannableStringBuilder(stringBuilder.toString())
        for (section in spanSections) {
            section.apply(ssb)
        }
        return ssb
    }

    override fun toString(): String {
        return stringBuilder.toString()
    }

    private inner class SpanSection(
        private val text: String,
        private val startIndex: Int,
        private val formattingStyle: Int
    ) {
        fun apply(spanStringBuilder: SpannableStringBuilder?) {
            if (spanStringBuilder == null) return
            when (formattingStyle) {
                FORMATTING_STYLE_DARK_BOLD -> {
                    val boldColorSpan =
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.md_theme_light_inversePrimary))
                    spanStringBuilder.setSpan(
                        boldColorSpan, startIndex, startIndex + text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                    )
                }
                FORMATTING_STYLE_DARK_BOLD_SMALL -> {
                    val testColorSpan1 =
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.md_theme_dark_scrim))
                    spanStringBuilder.setSpan(
                        testColorSpan1, startIndex, startIndex + text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                    )
                }
                FORMATTING_STYLE_DIM_ITALIC_LIGHT -> {
                    val dimColorSpan =
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue))
                    spanStringBuilder.setSpan(
                        dimColorSpan, startIndex, startIndex + text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                    )
                }
                FORMATTING_STYLE_DIM_ITALIC_LIGHT_SMALL -> {
                    val testColorSpan2 =
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.md_theme_dark_errorContainer))
                    spanStringBuilder.setSpan(
                        testColorSpan2, startIndex, startIndex + text.length,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
                    )
                }
            }
        }
    }

    companion object {
        const val FORMATTING_STYLE_DARK_BOLD = 1
        const val FORMATTING_STYLE_DARK_BOLD_SMALL = 2
        const val FORMATTING_STYLE_DIM_ITALIC_LIGHT = 3
        const val FORMATTING_STYLE_DIM_ITALIC_LIGHT_SMALL = 4
    }
}