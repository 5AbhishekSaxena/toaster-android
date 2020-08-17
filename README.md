# Toaster-Android

![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/5AbhishekSaxena/Toaster-Android?include_prereleases)
![GitHub](https://img.shields.io/github/license/5AbhishekSaxena/Toaster-Android)
![GitHub (Pre-)Release Date](https://img.shields.io/github/release-date-pre/5AbhishekSaxena/toaster-Android)

Toaster-Android is a simple open source library to customize toast messages in android applications.
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
	implementation 'com.github.5AbhishekSaxena:Toaster-Android:0.2.0'
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
                R.drawable.ic_baseline_check_circle_24 /* image */
            ).show()
  ```
  
  <img src="https://user-images.githubusercontent.com/19958130/90441978-7dc7a000-e0f7-11ea-8d6f-d6dd7b0c9146.jpeg" width="240">
  
  
  ### Code Snippets
  ##### Using templates
  - Error
  ```
  	Toaster.popError(
                this,
                "This is an error message",
                Toaster.LENGTH_SHORT
            ).show()
  ```
  
  <img src="https://user-images.githubusercontent.com/19958130/90441972-7a341900-e0f7-11ea-87f9-1cd10c912167.jpeg" width="240">
  
  - Warning
  ```
  	Toaster.popWarning(
                this,
                "This is a warning message",
                Toaster.LENGTH_SHORT
            ).show()
  ```
  
  <img src="https://user-images.githubusercontent.com/19958130/90441973-7bfddc80-e0f7-11ea-902c-0944e4499c5d.jpeg" width="240">
  
  ##### Custom Toast
  1. Create a toast buidler
  ```
        val toastBuilder = Toaster.Builder(requireContext())
            .setMessage("Login Success")
            .setLeftDrawable(R.drawable.ic_baseline_check_circle_24)
            .setLeftDrawableTint(R.color.dirty_green)
            .setStripTint(R.color.dirty_green)
  ``` 
  2. Add the builder to the `Toaster.pop`  
  ```
      Toaster.pop(toastBuilder.make()).show()
  ```
  <img src="https://user-images.githubusercontent.com/19958130/90441968-7902ec00-e0f7-11ea-9c2a-eb095654bec9.jpeg" width="240">
    
 ## Contributing
  - For contributions in this repository, please read [Contribution guidelines for this project](docs/CONTRIBUTING.md) first. (Please pull the changes from this repo if you have already forked the repository and are facing conflicts)
  - If you like the repository, please star it.
  
  ## License
  MIT License. See the [LICENSE](LICENSE) file for details
  
 ## Author
 ![GitHub followers](https://img.shields.io/github/followers/5AbhishekSaxena?style=social)
 ![Twitter Follow](https://img.shields.io/twitter/follow/abhisheks031?style=social)
  
 Abhishek Saxena 
