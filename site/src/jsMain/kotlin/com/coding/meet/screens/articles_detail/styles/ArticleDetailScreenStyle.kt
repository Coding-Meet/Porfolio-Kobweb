package com.coding.meet.screens.articles_detail.styles

import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.OverflowWrap
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.css.WordBreak
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import com.varabyte.kobweb.compose.ui.graphics.Colors.Transparent
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderLeft
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.overflowWrap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.wordBreak
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.s

val ArticleContentStyle = CssStyle {
    val backgroundColor = when (colorMode) {
        ColorMode.LIGHT -> rgba(3, 250, 110, 0.15)
        ColorMode.DARK -> rgb(73, 80, 76)
    }
    val textColor = when (colorMode) {
        ColorMode.LIGHT -> rgb(0x008138)
        ColorMode.DARK -> rgb(0x03FA6E)
    }
    val sharedModifier2 = Modifier
        .fontWeight(800)
        .backgroundColor(backgroundColor)
        .color(textColor)
        .padding(2.px, 6.px)
        .borderRadius(4.px)
        .display(DisplayStyle.InlineBlock)
        .lineHeight(1.2)
    val sharedModifier5 = Modifier
        .overflowWrap(OverflowWrap.BreakWord)
        .margin(top = 2.cssRem, bottom = 1.cssRem)
    val sharedModifier6 = Modifier
        .maxWidth(100.percent)
        .boxSizing(BoxSizing.BorderBox)
        .margin(bottom = 1.5.cssRem)
        .padding(left = 1.5.cssRem)
    val sharedModifier20 = Modifier
        .color(rgb(0x858585))
    base {
        Modifier
            .lineHeight(1.5)
            .fontSize(1.cssRem)
            .textAlign(TextAlign.Left)
            .maxWidth(100.percent)
            .overflowWrap(OverflowWrap.BreakWord)
            .flexWrap(FlexWrap.Wrap)
    }
    cssRule(" p") {
        Modifier
            .margin(bottom = 1.5.cssRem)
    }
    cssRule(" strong") {
        sharedModifier2
    }
    cssRule(" b") {
        sharedModifier2
    }
    cssRule(" figure") {
        Modifier
            .margin(1.cssRem, 0.px)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .alignItems(AlignItems.Center)
            .justifyContent(JustifyContent.Center)
            .maxWidth(100.percent)
    }
    cssRule(" img") {
        Modifier
            .maxWidth(100.percent)
            .height(autoLength)
            .borderRadius(12.px)
    }
    cssRule(" h1") {
        sharedModifier5
    }
    cssRule(" h2") {
        sharedModifier5
    }
    cssRule(" h3") {
        sharedModifier5
    }
    cssRule(" ul") {
        sharedModifier6
    }
    cssRule(" ol") {
        sharedModifier6
    }
    cssRule(" li") {
        Modifier
            .overflowWrap(OverflowWrap.BreakWord)
            .margin(bottom = 0.5.cssRem)
    }
    cssRule(" blockquote") {
        Modifier
            .borderLeft(4.px, LineStyle.Solid, rgb(0x03FA6E))
            .margin(1.5.cssRem, 0.px)
            .fontStyle(FontStyle.Italic)
            .opacity(0.8)
            .overflowWrap(OverflowWrap.BreakWord)
            .padding(left = 1.cssRem)
    }
    cssRule(" pre") {
        Modifier
            .background(rgb(0x1e1e1e))
            .color(rgb(0xd4d4d4))
            .padding(2.5.cssRem, 1.5.cssRem, 1.5.cssRem, 1.5.cssRem)
            .borderRadius(12.px)
            .overflow { x(Overflow.Auto) }
            .margin(0.px)
            .fontFamily("Fira Code", "Courier New", "monospace")
            .boxShadow(0.px, 0.px,20.px, 10.px, rgba(0, 0, 0, 0.2f))
            .maxWidth(100.percent)
            .boxSizing(BoxSizing.BorderBox)
    }
    cssRule(" code") {
        Modifier
            .fontFamily("inherit")
            .color(rgb(0xce9178))
            .background(rgba(0, 0, 0, 0.05f))
            .padding(2.px, 6.px)
            .borderRadius(4.px)
            .overflowWrap(OverflowWrap.BreakWord)
    }
    cssRule(" pre code") {
        Modifier
            .background(Transparent)
            .padding(0.px)
            .color(rgb(0x9cdcfe))
            .whiteSpace(WhiteSpace.Pre)
            .overflowWrap(OverflowWrap.Normal)
    }
    cssRule(" .comment") {
        sharedModifier20
    }
    cssRule(" .token.comment") {
        sharedModifier20
    }
    cssRule(" .hljs-comment") {
        sharedModifier20
    }
}
val VideoContainerStyle = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
            .height(0.px)
            .overflow(Overflow.Hidden)
            .maxWidth(100.percent)
            .borderRadius(12.px)
            .margin(2.cssRem, 0.px)
            .boxShadow(0.px,0.px, 30.px, 10.px, rgba(0, 0, 0, 0.2f))
            .padding(bottom = 56.25.percent)
    }
    cssRule(" iframe") {
        Modifier
            .position(Position.Absolute)
            .top(0.px)
            .left(0.px)
            .border(0.px)
            .fillMaxSize()
    }
}
val LinkPreviewStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .margin(bottom = 1.5.cssRem)
            .overflow(Overflow.Hidden)
            .textDecorationLine(TextDecorationLine.None)
            .transition(Transition.of("all", 0.2.s, TransitionTimingFunction.Ease))
            .cursor(Cursor.Pointer)
    }

}
val LinkPreviewContentStyle = CssStyle.base {
    Modifier

}
val LinkPreviewTitleStyle = CssStyle.base {
    val backgroundColor = when (colorMode) {
        ColorMode.LIGHT -> rgba(3, 250, 110, 0.15)
        ColorMode.DARK -> rgb(73, 80, 76)
    }
    val textColor = when (colorMode) {
        ColorMode.LIGHT -> rgb(0x008138)
        ColorMode.DARK -> rgb(0x03FA6E)
    }
    Modifier
        .fontWeight(800)
        .backgroundColor(backgroundColor)
        .color(textColor)
        .padding(2.px, 6.px)
        .borderRadius(4.px)
        .display(DisplayStyle.InlineBlock)
        .lineHeight(1.2)
}
val LinkPreviewUrlStyle = CssStyle.base {
    Modifier
        .fontSize(0.9.cssRem)
        .opacity(0.7)
        .wordBreak(WordBreak.BreakAll)
}
val CodeWrapperStyle = CssStyle.base {
    Modifier
        .position(Position.Relative)
        .margin(2.5.cssRem, 0.px)
        .fillMaxWidth()
}
val CopyButtonStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .top(12.px)
            .right(12.px)
            .background(rgba(255, 255, 255, 0.05f))
            .color(rgb(0x888888))
            .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.1f))
            .padding(6.px, 14.px)
            .borderRadius(8.px)
            .cursor(Cursor.Pointer)
            .fontSize(0.8.cssRem)
            .transition(Transition.of("all", 0.2.s, TransitionTimingFunction.Ease))
            .fontFamily("Inter", "sans-serif")
            .fontWeight(500)
    }
    hover {
        Modifier
            .background(rgba(255, 255, 255, 0.15f))
            .color(rgb(0xffffff))
            .border { color(rgba(255, 255, 255, 0.3f)) }
    }
    active {
        Modifier
            .transform { scale(0.96) }
    }
}
