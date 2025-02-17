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
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px


@Composable
fun NavigationMenu(
    selectedSectionId: String,
) {
    Section.entries.forEach { section ->
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
                    section.title.uppercase(),
                    modifier = Modifier.fontWeight(if (selectedSectionId == section.path) FontWeight.Bold else FontWeight.Normal)
                        .color(
                            CustomColor(
                                lightColor = Theme.LightFontColor,
                                darkColor = Theme.DarkFontColor
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .size(width = 20.px, height = 10.px)
                        .backgroundColor(
                            CustomColor(
                                lightColor = Theme.LightFontColor,
                                darkColor = Theme.DarkFontColor
                            )
                        )
                        .borderRadius(r = 10.px)
                        .visibility(if (selectedSectionId == section.path) Visibility.Visible else Visibility.Hidden)
                )
            }
        }
    }
}