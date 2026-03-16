package com.koderbit.andrestest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koderbit.andrestest.data.Animal
import com.koderbit.andrestest.di.modules.RandomNumber
import com.koderbit.andrestest.ui.theme.AndresTestTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AndresTestTheme {
                Scaffold { paddingValues ->
                    MainActivityView(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    )
                }
            }
        }
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val greetingService: IGreetingService,
    private val randomNumberService: RandomNumber,
    @param:Named("Canino") private val animalInjected: Animal,
    @param:Named("Felino") private val animalInjectedTwo: Animal
) : ViewModel() {

    private val _greeting = mutableStateOf<String?>(null)
    val greeting: State<String?> = _greeting

    private val _randomNumber = mutableStateOf<Int?>(null)
    val randomNumber: State<Int?> = _randomNumber

    private val _animal = mutableStateOf<String?>(null)
    val animal: State<String?> = _animal

    private val _animalTwo = mutableStateOf<String?>(null)
    val animalTwo: State<String?> = _animalTwo


    fun initializeViewModel() {
        viewModelScope.launch {
            _greeting.value = greetingService.getGreeting()
            _randomNumber.value = randomNumberService.number
            _animal.value = animalInjected.name
            _animalTwo.value = animalInjectedTwo.name
        }
    }

}

@Composable
fun MainActivityView(modifier: Modifier = Modifier, viewmodel: MainViewModel = hiltViewModel()) {

    val greeting = remember { viewmodel.greeting }
    val number = remember { viewmodel.randomNumber }

    LaunchedEffect(Unit) {
        viewmodel.initializeViewModel()
    }

    Column(
        modifier = modifier
    ) {
        Text(greeting.value ?: "No data")
        Text("Random number: ${number.value}")
        Text("Animal: ${viewmodel.animal.value}")
        Text("Animal Two: ${viewmodel.animalTwo.value}")
    }
}

