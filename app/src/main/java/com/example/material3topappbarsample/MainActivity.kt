package com.example.material3topappbarsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.material3topappbarsample.ui.theme.Material3TopAppBarSampleTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3TopAppBarSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * Why toolbar?
                     * Give the user a hint where he is currently is
                     * We also have the option to add some icons (to navigate back, to mark sth as
                     * favorite etc
                     */

                    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
                    // Scaffold is a container for that typically material designed components
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .nestedScroll(scrollBehavior.nestedScrollConnection),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "My notes")
                                },
                                navigationIcon = {
                                    IconButton(onClick = {}) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "Go back"
                                        )
                                    }
                                },
                                actions = {// additional options like add to fav..
                                    IconButton(onClick = {}) {
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "Mark as favorite"
                                        )
                                    }
                                    IconButton(onClick = {}) {
                                        Icon(
                                            imageVector = Icons.Default.Edit,
                                            contentDescription = "Edit a note"
                                        )
                                    }
                                },
                                scrollBehavior = scrollBehavior
                            )
                        }
                    ) { values ->
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(values)
                        ) {
                            items(100) {
                                Text(text = "Item $it", modifier = Modifier.padding(16.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}