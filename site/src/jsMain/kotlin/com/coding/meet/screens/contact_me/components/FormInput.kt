package com.coding.meet.screens.contact_me.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.image_slider_with_dot.MainButtonStyle
import com.coding.meet.screens.contact_me.styles.formStyle
import com.coding.meet.util.Constants
import com.coding.meet.util.Res
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.TextArea


@Composable
fun FormInput() {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        formStyle.toModifier().padding(top = 10.px)
    ) {
        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 2, xl = 2),
            modifier = Modifier.fillMaxWidth()
        ) {
            Input(InputType.Text) {
                id("first-name")
                attr("required", "")
                placeholder("First Name")
                onInput { event -> firstName = event.value }
            }
            Input(InputType.Text) {
                id("last-name")
                placeholder("Last Name")
                onInput { event -> lastName = event.value }
            }
        }

            Input(InputType.Text) {
                id("subject")
                placeholder("Subject")
                onInput { event -> subject = event.value }
            }

        TextArea {
            id("message")
            attr("required", "")
            placeholder("Message")
            onInput { event -> message = event.value }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(topBottom = 10.px),
            horizontalArrangement = Arrangement.spacedBy(10.px, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                attrs = MainButtonStyle.toAttrs {
                    onClick {
                        val finalSubject = subject.ifBlank { "No Subject" }
                        val finalName =  firstName + lastName

                        val body = """
                            ${finalName.ifNotBlank { "Name: $finalName" }}
                            ${finalSubject.ifNotBlank { "Subject: $finalSubject" }}
                            
                            ${message.ifNotBlank { "Message: $message" }}
                        """.trimIndent().replace("\n", "%0A")

                        window.open(
                            "mailto:${Constants.EMAIL_ID}?subject=$finalSubject&body=$body",
                        )
                    }
                }
            ) {
                SpanText(text = Res.Strings.SEND_MESSAGE)
            }
        }
    }
}
