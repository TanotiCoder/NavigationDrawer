package com.example.navdrawer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationController() {
    val navController: NavController = rememberNavController()
    val scope: CoroutineScope = rememberCoroutineScope()
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: "a"

    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val route = listOf("a", "b", "c")
    NavHost(
        navController = navController as NavHostController,
        startDestination = "a"
    ) {
        composable("a") {
            NavDrawerScreen(
                content = { Favorite(onClick = { navController.navigate("b") }) },
                drawerState = drawerState,
                scope = scope,
                navigateOnClick = { navController.navigate(it) },
                route = route,
                items = items,
                selectedItem =  currentRoute
            )
        }
        composable("b") {
            NavDrawerScreen(
                content = { Face(onClick = { navController.navigate("c") }) },
                drawerState = drawerState,
                scope = scope,
                navigateOnClick = { navController.navigate(it) },
                route = route,
                items = items,
                selectedItem =  currentRoute
            )
        }
        composable("c") {
            NavDrawerScreen(
                content = { Email(onClick = { navController.navigate("a") }) },
                drawerState = drawerState,
                scope = scope,
                navigateOnClick = { navController.navigate(it) },
                route = route,
                items = items,
                selectedItem =   currentRoute
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawerScreen(
    content: @Composable () -> Unit,
    drawerState: DrawerState,
    scope: CoroutineScope,
    navigateOnClick: (route: String) -> Unit,
    items: List<ImageVector>,
    route: List<String>,
    selectedItem: String,
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(item.name) },
                        selected = selectedItem == route[index],
                        onClick = {
                            scope.launch { drawerState.close() }
                            navigateOnClick(route[index])
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedContainerColor = MaterialTheme.colorScheme.secondary,
                        ),
                    )
                }
            }
        },
        content = { content() },
    )
}