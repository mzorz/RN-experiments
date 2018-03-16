import React from 'react';
import {AppRegistry, StyleSheet, Text, View} from 'react-native';
import AztecTextRNView from './ReactAztecView';

class HelloWorld extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <AztecTextRNView
         style={styles.hello}
         color = {'black'}
         text = {'hello thi is a atest from js'}
         maxImagesWidth = {300}
         editable = {true}
         autoGrow = {true}
         multiline = {true}
        />
      </View>
    );
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
    minHeight: 200,
  },
});

AppRegistry.registerComponent('MyReactNativeApp', () => HelloWorld);
