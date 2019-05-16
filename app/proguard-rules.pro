# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#保留crash日志的行号
-optimizations !field/removal/writeonly,!field/marking/private,!class/merging/*,!code/allocation/variable
-keepattributes LocalVariableTable,LocalVariableTypeTable
-keep,allowshrinking,allowoptimization class * { <methods>; }
-keepattributes SourceFile,LineNumberTable

-dontwarn com.google.**
-dontwarn com.android.**

-dontwarn com.unionpay.**
-keep class org.simalliance.openmobileapi.** {*;}
-keep class org.simalliance.openmobileapi.service.** {*;}
-keep class com.unionpay.** {*;}
-keep class com.UCMobile.** {*;}
