# Toaster-Android

![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/5AbhishekSaxena/Toaster-Android?include_prereleases)
![GitHub](https://img.shields.io/github/license/5AbhishekSaxena/Toaster-Android)
![GitHub (Pre-)Release Date](https://img.shields.io/github/release-date-pre/5AbhishekSaxena/toaster-Android)
![Language](https://img.shields.io/badge/Language-Kotlin-blue?style=flat&logo=kotlin)

Toaster-Android is a simple open source library to customize toast messages in android applications.
It has some predefined templates for common use-cases like warning, error and success messages.

<a href="https://www.buymeacoffee.com/abhisheksaxena" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" width="160" ></a>

 ## Download

  #### Step 1
  Add the JitPack repository to your `build.gradle(project)`.
  ```Groovy
 allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
 ```

  #### Step 2
  Add the dependency to your `build.gradle(Module: app)`.
 
  ```Groovy
 dependencies {
	implementation 'com.github.5AbhishekSaxena.toaster-android:toaster:2.3.1'
	implementation 'com.github.5AbhishekSaxena.toaster-android:toaster-ktx:2.3.1' //for ktx support
}
   ```
   *Please Note:* toaster-ktx includes toaster module so, if you are using toaster-ktx version then you don't have to add taoster
  
 ## How to use Toaster-Android
  Video:


  <a href="https://youtu.be/qUfnW1DZljM">
         <img src="https://img.youtube.com/vi/qUfnW1DZljM/0.jpg" style="width:100%;">
      </a>
 
  
  A simple use case will look like this

   ```
  Toaster.pop(
                this,
                "A simple toast message"
            ).show()
  ```
  
  With a custom drawable
  
  ```
  Toaster.pop(
                this,
                "A simple toast message with image",
                R.drawable.ic_baseline_cloud_done_24 /* image */
            ).show()
  ```
  
  <img src="https://user-images.githubusercontent.com/19958130/90524897-3dfec800-e18c-11ea-9544-2ab673f10d40.jpeg" width="320">
  
  
  ### Code Snippets
  ##### Using templates
   - Success
  ```
  	Toaster.popSuccess(
                    this,
                    "This is a success message",
                    Toaster.LENGTH_SHORT
                ).show()
  ```
  
  <img src="https://user-images.githubusercontent.com/19958130/90525085-7b635580-e18c-11ea-8bbf-5aeffb49bd11.jpeg" width="280">
  
  - Warning
  ```
  	Toaster.popWarning(
                this,
                "This is a warning message",
                Toaster.LENGTH_SHORT
            ).show()
  ```
  
  <img src="https://user-images.githubusercontent.com/19958130/90441973-7bfddc80-e0f7-11ea-902c-0944e4499c5d.jpeg" width="240">
  
  - Error
  ```
  	Toaster.popError(
                this,
                "This is an error message",
                Toaster.LENGTH_SHORT
            ).show()
  ```
  
  <img src="https://user-images.githubusercontent.com/19958130/90441972-7a341900-e0f7-11ea-87f9-1cd10c912167.jpeg" width="230">
  
  ##### Custom Toast
  1. Create a toast config
  ```kotlin
        val toastConfig = Toaster.Config(
                message = "File uploaded successfully",
                leftDrawableRes = R.drawable.ic_baseline_cloud_done_24,
                leftDrawableTint = R.color.blue,
                stripTint = R.color.blue,
                duration = Toaster.LENGTH_SHORT,
            )
  ``` 
  2. Add the config to the `Toaster.pop`  
  ```kotlin
      Toaster.pop(toastConfig.make(context)).show()
  ```
  <img src="https://user-images.githubusercontent.com/19958130/90525146-91711600-e18c-11ea-8e26-3c862a483e95.jpeg" width="240">

  ##### Custom Toast (toaster-ktx)
  With the toaster-ktx, you can either make `Taoster` or directly create `Toast` with the provided functions.
  1. Create `Taoster` and then poping it. 
    
   - Create `Taoster` usign ktx
   ```kotlin
   val toaster = prepareToaster(this) {
                message = "File uploaded successfully"
                leftDrawableRes = R.drawable.ic_baseline_cloud_done_24
                leftDrawableTint = R.color.blue
                stripTint = R.color.blue
                duration = Toaster.LENGTH_SHORT
            }
   Toaster.pop(toaster).show()
   ```
   - Pop the Toast
   ```kotlin
   Toaster.pop(toaster).show()
   ```
  2. Directly make `Toast` and show it
   ```kotlin
   prepareToast(this) {
                message = "File uploaded successfully"
                leftDrawableRes = R.drawable.ic_baseline_cloud_done_24
                leftDrawableTint = R.color.blue
                stripTint = R.color.blue
                duration = Toaster.LENGTH_SHORT
    }.show()
   ```
   <img src="https://user-images.githubusercontent.com/19958130/90525146-91711600-e18c-11ea-8e26-3c862a483e95.jpeg" width="240">
   
    
 ## Contributing
  - For contributions in this repository, please read [Contribution guidelines for this project](/CONTRIBUTING.md) first. (Please pull the changes from this repo if you have already forked the repository and are facing conflicts)
  - If you like the repository, please star it.
  
  ## License
  MIT License. See the [LICENSE](LICENSE) file for details
  
 ## Author
 <a href="https://github.com/5AbhishekSaxena"><img src="https://img.shields.io/github/followers/5AbhishekSaxena?style=social"></a> 
 <a href="https://twitter.com/intent/follow?screen_name=abhisheks031&tw_p=followbutton"><img src="https://img.shields.io/twitter/follow/abhisheks031?label=%40abhisheks031&style=social"></a> 
<a href="https://www.youtube.com/channel/UC8Gl9fv7A1ipE3EaOMzxCSg"><img src="https://img.shields.io/badge/Developing%20Developer--brightgreen?style=social&logo=youtube"></a>
<a href="https://www.instagram.com/developing.developer/" target="_blank" rel="noopener noreferrer"><img src="https://img.shields.io/badge/@developing.developer--brightgreen?style=social&logo=instagram"></a>

  
 Abhishek Saxena 
