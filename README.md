# ApiCC98

Java wrap for [https://api.cc98.org](https://api.cc98.org)
Use Gradle Build Tools;
### Implementation

#### FroCC98
Network interface just copy from website with Retrofit's super convenient annotations.
And Asyn-event is handled with RxJava and Retrofit-rxjava-adapter;

This repo is designed as a network component of new forum app's design.

#### For Authorization
Setup a local mini http-server to handle Oauth2's callback, receice accesstoken.

### Dependency

```
dependencies {
    compile 'io.reactivex:rxjava:1.1.1'
    compile 'com.squareup.retrofit2:retrofit:2.0.2'
    compile 'com.squareup.retrofit2:converter-gson:2.0.2'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.0.2'
    testCompile group: 'junit', name: 'junit', version: '4.12'
}
```

