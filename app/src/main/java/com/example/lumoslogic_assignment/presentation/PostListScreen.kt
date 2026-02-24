package com.example.lumoslogic_assignment.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.lumoslogic_assignment.presentation.PostListViewModel

@Composable
fun PostListScreen(
    navController: NavController,
    viewModel: PostListViewModel = hiltViewModel()
) {

    val posts = viewModel.posts.collectAsLazyPagingItems()

    when (posts.loadState.refresh) {

        is LoadState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is LoadState.Error -> {
            Text(
                text = "Error loading data" ,
                modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp, start = 20.dp)
            )
        }

        else -> {

            Scaffold { innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    items(posts.itemCount) { post ->
                        post.let {
                            Text(
                                text = posts[it]?.title ?: "",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        navController.navigate("detail/${posts[it]?.id ?: ""}")
                                    }
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}