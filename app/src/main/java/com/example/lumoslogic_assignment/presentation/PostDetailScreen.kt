package com.example.lumoslogic_assignment.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lumoslogic_assignment.domain.Post
import com.example.lumoslogic_assignment.presentation.PostDetailViewModel

@Composable
fun PostDetailScreen(
    id: Int,
    viewModel: PostDetailViewModel = hiltViewModel()
) {
    var post by remember { mutableStateOf<Post?>(null) }

    LaunchedEffect(Unit) {
        post = viewModel.getPost(id)
    }

    post?.let {
        Column(Modifier.padding(16.dp)) {
            Spacer(Modifier.height(80.dp))
            Text(it.title)
            Spacer(Modifier.height(80.dp))
            Text(it.body)
        }
    }
}