package com.example.keefecalculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.keefecalculator.ui.theme.Pink40
import com.example.keefecalculator.ui.theme.Pink80
import com.example.keefecalculator.ui.theme.Purple40
import com.example.keefecalculator.ui.theme.PurpleGrey40


@Composable
fun MainCalculatorUI(parser: Parser) {
    val display = parser.input
    Column() {
        Spacer(modifier = Modifier.height(250.dp))
        Row {
            //output of calculator
            Spacer(modifier = Modifier.width(200.dp))
            Text(
                text = display.value,
                fontSize = 50.sp,
                textAlign = TextAlign.Right
            )
        }
        HorizontalDivider(
            color = PurpleGrey40,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .padding(top = 16.dp)
        )
        Column(modifier = Modifier.padding(all = 8.dp)) {
            // main column
            Row(modifier = Modifier.padding(all = 8.dp)) {
                //buttons line 1
                Button(
                    "AC",
                    Pink40,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.clear()
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "(",
                    Purple40,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("(")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    ")",
                    Purple40,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add(")")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "÷",
                    Purple40,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("/")
                        }
                )
            }
            Row(modifier = Modifier.padding(all = 8.dp)) {
                //buttons line 2
                Button(
                    "7",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("7")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "8",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("8")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "9",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("9")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "×",
                    Purple40,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("*")
                        }
                )
            }
            Row(modifier = Modifier.padding(all = 8.dp)) {
                //buttons line 3
                Button(
                    "4",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("4")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "5",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("5")
                        })
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "6",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("6")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "-",
                    Purple40,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("-")
                        })
            }
            Row(modifier = Modifier.padding(all = 8.dp)) {
                //buttons line 4
                Button(
                    "1",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("1")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "2",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("2")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "3",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("3")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "+",
                    Purple40,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("+")
                        })
            }
            Row(modifier = Modifier.padding(all = 8.dp)) {
                //buttons line 5
                Button(
                    "0",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add("0")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    ".",
                    Pink80,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.add(".")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "Del",
                    Pink40,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            parser.remove()
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    "=",
                    PurpleGrey40,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            //parser.add("5.5 / 22 + 3")
                            parser.evaluate()
                        }
                )
            }
        }
    }
}


