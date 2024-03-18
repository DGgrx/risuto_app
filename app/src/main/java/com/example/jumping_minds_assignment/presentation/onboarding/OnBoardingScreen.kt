package com.example.jumping_minds_assignment.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jumping_minds_assignment.presentation.Dimens.HorizontalPadding1
import com.example.jumping_minds_assignment.presentation.Dimens.HorizontalPadding2
import com.example.jumping_minds_assignment.presentation.common.RisotuTextButton
import com.example.jumping_minds_assignment.presentation.common.RisutoButton
import com.example.jumping_minds_assignment.presentation.onboarding.components.OnBoardingPage
import com.example.jumping_minds_assignment.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxHeight()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])

        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(HorizontalPadding1),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(pageSize = pages.size, selectedPage = pagerState.currentPage)
            Spacer(modifier = Modifier.weight(1f))

            val scope = rememberCoroutineScope()

            if(buttonState.value[0].isNotEmpty()){
                RisotuTextButton(text = buttonState.value[0],
                    onClick = {
                      scope.launch{
                          pagerState.animateScrollToPage(page = pagerState.currentPage-1)
                      }
                    })
                Spacer(modifier = Modifier.width(HorizontalPadding2))

            }
            RisutoButton(text = buttonState.value[1], onclick = {
                scope.launch {
                    if(pagerState.currentPage<2) {
                        pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                    }
                    else{
                        //TODO
                    }
                }
            })

        }
    }
}