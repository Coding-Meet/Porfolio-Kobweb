package com.coding.meet.common.components.navigation_bar.components

import androidx.compose.runtime.Composable
import com.coding.meet.common.components.navigation_bar.styles.NavigationItemStyle
import com.coding.meet.models.Section
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@Composable
fun NavigationMenu(
    selectedSectionId: String,
) {
    Section.entries.forEach { section ->
        val isSelected = selectedSectionId == section.path
        Link(
            modifier = NavigationItemStyle.toModifier(),
            path = section.path,
            openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpanText(
                    section.title,
                    modifier = Modifier
                        .fontWeight(if (isSelected) FontWeight.SemiBold else FontWeight.Medium)
                        .color(
                            if (isSelected) Theme.Primary.color
                            else CustomColor(
                                lightColor = Theme.LightFontColor,
                                darkColor = Theme.DarkFontColor
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .margin(top = 4.px)
                        .size(width = if (isSelected) 16.px else 0.px, height = 2.px)
                        .backgroundColor(Theme.Primary.color)
                        .borderRadius(r = 9999.px)
                        .boxShadow(0.px, 0.px, 6.px, null, rgba(16, 185, 129, 0.5))
                        .visibility(if (isSelected) Visibility.Visible else Visibility.Hidden)
                )
            }
        }
    }
}