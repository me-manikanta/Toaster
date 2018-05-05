# Toaster
[![](https://jitpack.io/v/Mani-Itachi/Toaster.svg)](https://jitpack.io/#Mani-Itachi/Toaster)

Still using normal toast are you living under rock.
## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.Mani-Itachi:Toaster:1.0.0'
}
```


## Why Toaster?

<b>Normal toast:</b> 

```
Toast.maketext(this,"This is a toast",Toast.LENGTH_SHORT).show();
```

<b>Toast with toaster:</b> 
```
Toaster.maketext(this,"This is a toaster toast",Toast.LENGTH_SHORT).show();
```

What is the advantage?
Hmm...

Toaster has some inbuilt methods that help you to customise your toasts

## Usage

To display a normal Toast:
``` java
Toaster.makeText(this, "Hi! This is a sample toast",Toast.LENGTH_SHORT).show();
```

To display a Toast with an icon:
``` java
Toaster.makeText(this, "A toast with a cute cat",Toast.LENGTH_SHORT).setIcon(R.drawable.cat)
                        .setBackgroundColor(Color.parseColor("#FFFFFF"))
                        .setTextColor(Color.parseColor("#000000"))
                        .show();
```

To display a error Toast:
``` java
Toaster.error(this, "Oops! Error occurred",Toast.LENGTH_SHORT).show();
```

To display a success Toast:

``` java
Toaster.success(this, "Yay, it's  a success",Toast.LENGTH_SHORT).show();
```
To display an info Toast:

``` java
Toaster.info(this, "Hey, here is some info",Toast.LENGTH_SHORT).show();
```
To display a warning Toast:

``` java
Toaster.warning(this, "This is a warning",Toast.LENGTH_SHORT).show();
```

## Extra customisation

You can further customise toast by calling other methods
``` 
Toaster.maketText(this,"Custom toast") -> returns a toaster object
```
```
setTextColor() -> change text color
```
```
setBackgroundColor() -> change the background color of the toast
```
```
setDuration() -> set the duration of the toast
```
```
setFont() -> change font of the toast
```
```
setGravity() -> change the position of the toast
```
```
setIcon() -> set an Icon for the toast
```

You can pass formatted text to toaster too 😎

## Special Mentions

Open an  ```issue``` so that you can be here.
