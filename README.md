# Toaster-Android

![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/5AbhishekSaxena/Toaster-Android?include_prereleases)
![GitHub](https://img.shields.io/github/license/5AbhishekSaxena/Toaster-Android)
![GitHub (Pre-)Release Date](https://img.shields.io/github/release-date-pre/5AbhishekSaxena/toaster-Android)

Toaster-Android is a simple open source library to customize toast messages in adnroid applications.
It has some predefined templates for common use-cases like warning, error and success messages.

 ## Download

  #### Step 1
  Add the JitPack repository to your `build.gradle(project)`.
  ```
 allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
 ```

  #### Step 2
  Add the dependency to your `build.gradle(Module: app)`.
 
  ```
 dependencies {
	implementation 'com.github.5AbhishekSaxena:Toaster-Android:0.1.0-beta02'
}
   ```
  
 ## How to use Toaster-Android
  
  A simple use case will look like this

   ```
  val message = "Some Message" 
  
  Toaster.pop(
                this,
                message
            ).show()
  ```
  
  With a custom drawable
  
  ```
  val message = "Some Message" 
  
  Toaster.pop(
                this,
                message,
                R.drawable.ic_baseline_all_inclusive_24 /* image */
            ).show()
  ```
  
  ## Contributing
  - For contributions in this repository, please read [Contribution guidelines for this project](docs/CONTRIBUTING.md) first. (Please pull the changes from this repo if you have already forked the repository and are facing conflicts)
  - If you like the repository, please star it.
  
 ## Author
 ![GitHub followers](https://img.shields.io/github/followers/5AbhishekSaxena?style=social)
 ![Twitter Follow](https://img.shields.io/twitter/follow/abhisheks031?style=social)
  
 Abhishek Saxena 
