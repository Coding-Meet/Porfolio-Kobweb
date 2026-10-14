package com.coding.meet.screens.articles_detail.styles

import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
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
    val codeBgColor = when (colorMode) {
        ColorMode.LIGHT -> rgba(16, 185, 129, 0.1)
        ColorMode.DARK -> rgba(16, 185, 129, 0.18)
    }
    val codeTextColor = when (colorMode) {
        ColorMode.LIGHT -> rgb(5, 150, 105)
        ColorMode.DARK -> rgb(52, 211, 153)
    }

    val sharedModifier6 = Modifier
        .maxWidth(100.percent)
        .boxSizing(BoxSizing.BorderBox)
        .margin(bottom = 1.5.cssRem)
        .padding(left = 1.5.cssRem)

    val commentColor = Modifier.color(rgb(0x858585))

    val sharedModifier2 = Modifier
        .fontWeight(800)
        .backgroundColor(codeBgColor)
        .color(codeTextColor)
        .padding(leftRight = 6.px, topBottom = 2.px)
        .borderRadius(4.px)
        .display(DisplayStyle.InlineBlock)
        .lineHeight(1.2)

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

    cssRule(" h1") {
        Modifier
            .fontFamily(Res.Font.FONT_FAMILY_HEADING)
            .fontSize(1.9.cssRem)
            .fontWeight(FontWeight.Bold)
            .lineHeight(1.25)
            .margin(top = 2.4.cssRem, bottom = 1.cssRem)
            .overflowWrap(OverflowWrap.BreakWord)
    }

    cssRule(" h2") {
        Modifier
            .fontFamily(Res.Font.FONT_FAMILY_HEADING)
            .fontSize(1.55.cssRem)
            .fontWeight(FontWeight.Bold)
            .lineHeight(1.3)
            .margin(top = 2.cssRem, bottom = 0.8.cssRem)
            .overflowWrap(OverflowWrap.BreakWord)
    }

    cssRule(" h3") {
        Modifier
            .fontFamily(Res.Font.FONT_FAMILY_HEADING)
            .fontSize(1.3.cssRem)
            .fontWeight(FontWeight.Bold)
            .lineHeight(1.35)
            .margin(top = 1.6.cssRem, bottom = 0.6.cssRem)
            .overflowWrap(OverflowWrap.BreakWord)
    }

    cssRule(" a") {
        Modifier
            .color(Theme.Primary.color)
            .fontWeight(FontWeight.SemiBold)
            .textDecorationLine(TextDecorationLine.Underline)
            .transition(Transition.of("opacity", 0.2.s, TransitionTimingFunction.Ease))
    }

    cssRule(" a:hover") {
        Modifier.opacity(0.8)
    }

    cssRule(" figure") {
        Modifier
            .margin(1.5.cssRem, 0.px)
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
            .borderRadius(14.px)
            .boxShadow(0.px, 4.px, 20.px, null, rgba(0, 0, 0, 0.15))
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
            .lineHeight(1.65)
    }

    cssRule(" blockquote") {
        Modifier
            .borderLeft(4.px, LineStyle.Solid, Theme.Primary.color)
            .margin(1.5.cssRem, 0.px)
            .fontStyle(FontStyle.Italic)
            .opacity(0.88)
            .overflowWrap(OverflowWrap.BreakWord)
            .padding(top = 4.px, bottom = 4.px, left = 1.2.cssRem)
    }

    cssRule(" code") {
        Modifier
            .fontFamily("Fira Code", "monospace")
            .color(codeTextColor)
            .backgroundColor(codeBgColor)
            .padding(leftRight = 6.px, topBottom = 2.px)
            .borderRadius(5.px)
            .fontSize(0.9.cssRem)
            .overflowWrap(OverflowWrap.BreakWord)
    }

    cssRule(" pre") {
        Modifier
            .backgroundColor(rgb(0x1e1e1e))
            .color(rgb(0xd4d4d4))
            .padding(top = 2.8.cssRem, leftRight = 1.5.cssRem, bottom = 1.5.cssRem)
            .borderRadius(14.px)
            .overflow { x(Overflow.Auto) }
            .margin(0.px)
            .fontFamily("Fira Code", "Courier New", "monospace")
            .boxShadow(0.px, 6.px, 25.px, null, rgba(0, 0, 0, 0.35))
            .maxWidth(100.percent)
            .boxSizing(BoxSizing.BorderBox)
            .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.1))
    }

    cssRule(" pre code") {
        Modifier
            .backgroundColor(Transparent)
            .padding(0.px)
            .color(rgb(0x9cdcfe))
            .fontSize(0.9.cssRem)
            .whiteSpace(WhiteSpace.Pre)
            .overflowWrap(OverflowWrap.Normal)
    }

    // Code copy wrapper & button
    cssRule(" .code-wrapper") {
        Modifier
            .position(Position.Relative)
            .margin(topBottom = 2.cssRem)
            .fillMaxWidth()
    }

    cssRule(" .copy-button") {
        Modifier
            .position(Position.Absolute)
            .top(12.px)
            .right(12.px)
            .backgroundColor(rgba(255, 255, 255, 0.08))
            .color(rgb(0xcccccc))
            .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.15))
            .padding(leftRight = 12.px, topBottom = 6.px)
            .borderRadius(6.px)
            .cursor(Cursor.Pointer)
            .fontSize(0.78.cssRem)
            .fontFamily(Res.Font.FONT_FAMILY_REGULAR)
            .fontWeight(FontWeight.SemiBold)
            .transition(Transition.of("all", 0.2.s, TransitionTimingFunction.Ease))
    }

    cssRule(" .copy-button:hover") {
        Modifier
            .backgroundColor(Theme.Primary.color)
            .color(rgb(255, 255, 255))
            .border(1.px, LineStyle.Solid, Theme.Primary.color)
    }

    cssRule(" .copy-button:active") {
        Modifier.transform { scale(0.96) }
    }

    // Video container embed
    cssRule(" .video-container") {
        Modifier
            .position(Position.Relative)
            .height(0.px)
            .overflow(Overflow.Hidden)
            .maxWidth(100.percent)
            .borderRadius(14.px)
            .margin(topBottom = 2.cssRem)
            .boxShadow(0.px, 6.px, 25.px, null, rgba(0, 0, 0, 0.25))
            .padding(bottom = 56.25.percent)
    }

    cssRule(" .video-container iframe") {
        Modifier
            .position(Position.Absolute)
            .top(0.px)
            .left(0.px)
            .border(0.px)
            .fillMaxSize()
    }

    // Link previews
    cssRule(" .link-preview") {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .margin(topBottom = 1.4.cssRem)
            .padding(leftRight = 16.px, topBottom = 12.px)
            .backgroundColor(if (colorMode.isLight) rgba(0, 0, 0, 0.03) else rgba(255, 255, 255, 0.04))
            .border(1.px, LineStyle.Solid, if (colorMode.isLight) rgba(0, 0, 0, 0.08) else rgba(255, 255, 255, 0.1))
            .borderRadius(12.px)
            .textDecorationLine(TextDecorationLine.None)
            .transition(Transition.of("all", 0.2.s, TransitionTimingFunction.Ease))
            .cursor(Cursor.Pointer)
    }

    cssRule(" .link-preview:hover") {
        Modifier
            .backgroundColor(if (colorMode.isLight) rgba(16, 185, 129, 0.06) else rgba(16, 185, 129, 0.1))
            .border(1.px, LineStyle.Solid, Theme.Primary.color)
    }

    cssRule(" .link-preview-title") {
        Modifier
            .fontWeight(FontWeight.Bold)
            .color(Theme.Primary.color)
            .fontSize(0.95.cssRem)
            .margin(bottom = 4.px)
    }

    cssRule(" .link-preview-url") {
        Modifier
            .fontSize(0.85.cssRem)
            .color(if (colorMode.isLight) rgb(100, 116, 139) else rgb(148, 163, 184))
            .wordBreak(WordBreak.BreakAll)
    }

    cssRule(" .comment") {
        commentColor
    }

    cssRule(" .token.comment") {
        commentColor
    }

    cssRule(" .hljs-comment") {
        commentColor
    }
}
