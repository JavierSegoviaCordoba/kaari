# detekt

## Metrics

* 43 number of properties

* 32 number of functions

* 25 number of classes

* 11 number of packages

* 34 number of kt files

## Complexity Report

* 1,095 lines of code (loc)

* 917 source lines of code (sloc)

* 544 logical lines of code (lloc)

* 31 comment lines of code (cloc)

* 47 cyclomatic complexity (mcc)

* 15 cognitive complexity

* 22 number of total code smells

* 3% comment source ratio

* 86 mcc per 1,000 lloc

* 40 code smells per 1,000 lloc

## Findings (22)

### empty-blocks, EmptyFunctionBlock (1)

Empty block of code detected. As they serve no purpose they should be removed.

[Documentation](https://detekt.dev/docs/rules/empty-blocks#emptyfunctionblock)

* samples/features/jvm/main/kotlin/com/javiersc/samples/features/_theme/Theme.jvm.kt:9:86
```
This empty block of code can be removed.
```
```kotlin
6  @Composable
7  actual fun colorScheme(dynamicColor: Boolean, isDarkTheme: Boolean): ColorScheme = LightColorScheme
8  
9  @Composable actual fun AndroidConfig(colorScheme: ColorScheme, isDarkTheme: Boolean) {}
!                                                                                       ^ error
10 

```

### naming, FunctionNaming (10)

Function names should follow the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#functionnaming)

* kaari-presentation-core/common/main/kotlin/com/javiersc/kaari/presentation/core/KaariPresentation.kt:17:16
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
14     @Composable public fun state(): State
15 
16     @Composable
17     public fun CollectedEffect(block: suspend CoroutineScope.(effect: Effect) -> Unit) {
!!                ^ error
18         LaunchedEffect(Unit) { events.collect { effect -> block(this, effect) } }
19     }
20 

```

* samples/apps/android/main/kotlin/com/javiersc/kaari/samples/android/MainActivity.kt:44:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
41 
42 @Preview
43 @Composable
44 fun MainScreenPreview() {
!!     ^ error
45     ComposePlaygroundTheme {
46         MainScreen(
47             state =

```

* samples/features/android/main/kotlin/com/javiersc/samples/features/Preview.android.kt:7:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
4  import com.javiersc.samples.features._theme.ComposePlaygroundTheme
5  
6  @Composable
7  fun KaariPreview(composable: @Composable () -> Unit) {
!      ^ error
8      ComposePlaygroundTheme { composable() }
9  }
10 

```

* samples/features/android/main/kotlin/com/javiersc/samples/features/_theme/Theme.android.kt:27:12
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
24     }
25 
26 @Composable
27 actual fun AndroidConfig(colorScheme: ColorScheme, isDarkTheme: Boolean) {
!!            ^ error
28     val view = LocalView.current
29     if (!view.isInEditMode) {
30         SideEffect {

```

* samples/features/android/main/kotlin/com/javiersc/samples/features/main/MainScreenPreview.android.kt:10:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
7  
8  @Preview
9  @Composable
10 fun MainScreenPreview() = KaariPreview {
!!     ^ error
11     val uuid = UUID.randomUUID().toString()
12     MainScreen(
13         MainState(

```

* samples/features/common/main/kotlin/com/javiersc/samples/features/_theme/Theme.kt:31:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
28     )
29 
30 @Composable
31 fun ComposePlaygroundTheme(
!!     ^ error
32     isDarkTheme: Boolean = isSystemInDarkTheme(),
33     // Dynamic color is available on Android 12+
34     dynamicColor: Boolean = true,

```

* samples/features/common/main/kotlin/com/javiersc/samples/features/_theme/Theme.kt:44:24
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
41 
42 @Composable expect fun colorScheme(dynamicColor: Boolean, isDarkTheme: Boolean): ColorScheme
43 
44 @Composable expect fun AndroidConfig(colorScheme: ColorScheme, isDarkTheme: Boolean)
!!                        ^ error
45 

```

* samples/features/common/main/kotlin/com/javiersc/samples/features/main/MainScreen.kt:18:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
15 import java.util.*
16 
17 @Composable
18 fun MainScreen(
!!     ^ error
19     state: MainState,
20     onAddCharacter: (Character) -> Unit = {},
21 ) {

```

* samples/features/common/main/kotlin/com/javiersc/samples/features/main/MainScreen.kt:60:5
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
57 }
58 
59 @Composable
60 fun Character(name: String) {
!!     ^ error
61     Text(name)
62 }
63 

```

* samples/features/jvm/main/kotlin/com/javiersc/samples/features/_theme/Theme.jvm.kt:9:24
```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```
```kotlin
6  @Composable
7  actual fun colorScheme(dynamicColor: Boolean, isDarkTheme: Boolean): ColorScheme = LightColorScheme
8  
9  @Composable actual fun AndroidConfig(colorScheme: ColorScheme, isDarkTheme: Boolean) {}
!                         ^ error
10 

```

### naming, MatchingDeclarationName (2)

If a source file contains only a single non-private top-level class or object, the file name should reflect the case-sensitive name plus the .kt extension.

[Documentation](https://detekt.dev/docs/rules/naming#matchingdeclarationname)

* kaari-viewmodel/android/main/kotlin/com/javiersc/kaari/viewmodel/ViewModel.android.kt:7:30
```
The file name 'ViewModel.android' does not match the name of the single top-level declaration 'ViewModel'.
```
```kotlin
4  import kotlinx.coroutines.CoroutineScope
5  import kotlinx.coroutines.cancel
6  
7  public actual abstract class ViewModel : AndroidViewModel() {
!                               ^ error
8  
9      public actual abstract val scope: CoroutineScope
10 

```

* kaari-viewmodel/jvm/main/kotlin/com/javiersc/kaari/viewmodel/ViewModel.jvm.kt:6:30
```
The file name 'ViewModel.jvm' does not match the name of the single top-level declaration 'ViewModel'.
```
```kotlin
3  import kotlinx.coroutines.CoroutineScope
4  import kotlinx.coroutines.cancel
5  
6  public actual abstract class ViewModel actual constructor() {
!                               ^ error
7  
8      public actual abstract val scope: CoroutineScope
9  

```

### naming, PackageNaming (6)

Package names should match the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#packagenaming)

* samples/features/android/main/kotlin/com/javiersc/samples/features/_theme/Theme.android.kt:1:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 package com.javiersc.samples.features._theme
! ^ error
2 
3 import android.app.Activity
4 import android.os.Build

```

* samples/features/common/main/kotlin/com/javiersc/samples/features/_di/presentationModule.kt:1:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 package com.javiersc.samples.features._di
! ^ error
2 
3 import com.javiersc.samples.features.main.MainViewModel
4 import org.koin.core.module.dsl.singleOf

```

* samples/features/common/main/kotlin/com/javiersc/samples/features/_theme/Color.kt:3:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 @file:Suppress("MagicNumber")
2 
3 package com.javiersc.samples.features._theme
! ^ error
4 
5 import androidx.compose.ui.graphics.Color
6 

```

* samples/features/common/main/kotlin/com/javiersc/samples/features/_theme/Theme.kt:1:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 package com.javiersc.samples.features._theme
! ^ error
2 
3 import androidx.compose.foundation.isSystemInDarkTheme
4 import androidx.compose.material3.ColorScheme

```

* samples/features/common/main/kotlin/com/javiersc/samples/features/_theme/Type.kt:1:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 package com.javiersc.samples.features._theme
! ^ error
2 
3 import androidx.compose.material3.Typography
4 import androidx.compose.ui.text.TextStyle

```

* samples/features/jvm/main/kotlin/com/javiersc/samples/features/_theme/Theme.jvm.kt:1:1
```
Package name should match the pattern: [a-z]+(\.[a-z][A-Za-z0-9]*)*
```
```kotlin
1 package com.javiersc.samples.features._theme
! ^ error
2 
3 import androidx.compose.material3.ColorScheme
4 import androidx.compose.runtime.Composable

```

### style, ForbiddenComment (1)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* kaari-presentation-core/common/main/kotlin/com/javiersc/kaari/presentation/core/KaariPresentation.kt:29:5
```
This comment contains 'TODO:' that has been defined as forbidden in detekt.
```
```kotlin
26         scope.launch { events.emit(effect) }
27     }
28 
29     // TODO: Doesn't work due Compose compiler bug
!!     ^ error
30     // @Suppress("NOTHING_TO_INLINE")
31     // @Composable
32     // inline operator fun getValue(thisObj: Any?, property: KProperty<*>): State = state()

```

### style, MagicNumber (2)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence it's unclear what the purpose of this number is. It's better to declare such numbers as constants and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* samples/features/android/main/kotlin/com/javiersc/samples/features/main/MainScreenPreview.android.kt:19:45
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
16                 listOf(
17                     com.javiersc.samples.strategies.characters.Character(
18                         uuid,
19                         "Rick + ${uuid.take(7)}"
!!                                             ^ error
20                     ),
21                 ),
22         )

```

* samples/features/common/main/kotlin/com/javiersc/samples/features/main/MainScreen.kt:41:67
```
This expression contains a magic number. Consider defining it to a well named constant.
```
```kotlin
38                                 onAddCharacter(
39                                     Character(
40                                         id = uuid,
41                                         name = "Foo + ${uuid.take(7)}",
!!                                                                   ^ error
42                                     ),
43                                 )
44                             },

```

generated with [detekt version 1.22.0](https://detekt.dev/) on 2023-03-04 20:45:28 UTC
