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
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text


@Composable
fun NavMenu(
    selectedSectionId : String,
    onSelectSectionId: (String) -> Unit
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Section.entries.forEach { section ->
            Link(
                modifier = NavigationItemStyle.toModifier()
                    .padding(leftRight = 20.px)
                    .fontFamily(Res.Font.FONT_FAMILY_REGULAR)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None)
                    .onClick {
                        onSelectSectionId(section.path)
                    },
                path = section.path,
                openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(section.title)
                    Box(
                        modifier = Modifier
                            .size(10.px)
                            .backgroundColor(
                                if (selectedSectionId == section.path) {
                                    CustomColor(
                                        lightColor = Theme.Primary,
                                        darkColor = Theme.Primary
                                    )
                                } else {
                                    CustomColor(
                                        lightColor = Theme.LightGray,
                                        darkColor = Theme.DarkGray
                                    )
                                }
                            )
                            .borderRadius(r = 20.px)
                    )
                }
            }
        }
    }
}