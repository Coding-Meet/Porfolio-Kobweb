package com.coding.meet.sections.navigation_bar.components

import androidx.compose.runtime.Composable
import com.coding.meet.models.Section
import com.coding.meet.sections.navigation_bar.styles.NavigationItemStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px


@Composable
fun NavMenu() {
    Row(
        modifier = Modifier
            .borderRadius(r = 20.px)
            .backgroundColor(
                CustomColor(
                    lightColor = Theme.LightGray,
                    darkColor = Theme.DarkGray
                )
            )
            .padding(all = 20.px),
        horizontalArrangement = Arrangement.Center
    ) {
        Section.entries.forEach { section ->
            Link(
                modifier = NavigationItemStyle.toModifier()
                    .padding(leftRight = 15.px)
                    .fontFamily(Res.Font.FONT_FAMILY_REGULAR)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None),
                path = section.id,
                text = section.title,
                openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
            )
        }
    }
}