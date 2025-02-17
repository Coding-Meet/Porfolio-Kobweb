package com.coding.meet.screens.home.components

import androidx.compose.runtime.Composable
import com.coding.meet.screens.home.styles.HomeProfileImageStyle
import com.coding.meet.screens.home.styles.MainButtonStyle
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.borderRight
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text


@Composable
fun HomeScreen() {
    Image(
        modifier = HomeProfileImageStyle.toModifier()
            .margin(topBottom = 2.px)
            .display(DisplayStyle.Block)
            .borderRadius(100.percent)
            .boxSizing(BoxSizing.BorderBox)
            .border(5.px, LineStyle.Solid, Theme.Primary.color),
        src = Res.Image.profile,
        alt = "Main Image",
    )
    H1(
        attrs = Modifier
            .margin(topBottom = 0.px).toAttrs()
    ) {
        Text("Hi, I'm Meet")
    }
    H2(
        attrs = Modifier
            .margin(topBottom = 5.px)
            .lineHeight(1)
            .toAttrs()
    ) {
        SpanText(
            text = "I am into Android Developer",
            modifier = Modifier.borderRight(
                width = 0.08.em,
                style = LineStyle.Solid,
                color = Color("#666")
            )
        )
    }

//    H2(
//        attrs = Modifier
//            .margin(topBottom = 0.px).toAttrs()
//    ) {
//        Text("I focus on building intuitive Android apps that are accessible, scalable, and high-performance.")
//    }
//    Button(
//        attrs = MainButtonStyle.toModifier()
//            .height(40.px)
//            .border(width = 0.px)
//            .borderRadius(r = 5.px)
//            .backgroundColor(Theme.Primary.color)
//            .color(Colors.White)
//            .cursor(Cursor.Pointer)
//            .toAttrs()
//    ) {
//        Link(
//            modifier = Modifier
//                .color(Colors.White)
//                .textDecorationLine(TextDecorationLine.None),
//            text = "Hire me",
//            path = ""
//        )
//    }
}