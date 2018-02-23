# RN-experiments

This is a project that allows you to choose on testing 2 different activities, one is all native, the other one is a React Native activity, and the third one (to be implemented) is a native REcyclerview with RN views as items.

### To test on a real device

If you’re running on a real device, you’ll need to make the server  available to it through the use of 
https://github.com/facebook/react-native/issues/15388

`adb reverse tcp:8081 tcp:8081`


Then you’ll be able to do `npm start`  and then on Android Studio run the project to access the ReactNative activity.

