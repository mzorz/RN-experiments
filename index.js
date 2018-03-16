import React from 'react';
import {AppRegistry, TextInput, StyleSheet, Text, View} from 'react-native';
import AztecTextRNView from './ReactAztecView';
import AztecTextRNInflatedView from './ReactAztecInflatedView';

class HelloWorld extends React.Component {
  constructor(props) {
    super(props);
    this.state = { text: 'ESTO ES UNA PRUEBA RN TEXT INPUT' };
  }

  render() {
    return (
      <View style={styles.container}>
        <View style={styles.container}>
          <AztecTextRNView
           style={styles.hello}
           color = {'black'}
           text = {'AztecTextRNView hello thi is a atest from js'}
           maxImagesWidth = {300}
           editable = {true}
           autoGrow = {true}
           multiline = {true}
          />
        </View>
        <View style={styles.container}>
          <AztecTextRNInflatedView
           style={styles.hello}
           color = {'black'}
           text = {'AztecTextRNInflatedViewINFLATED VIEW HERE'}
           editable = {true}
           multiline = {true}
          />
        </View>
        <View style={styles.container}>
          <TextInput
            style={{borderColor: 'gray', borderWidth: 1}}
            value={this.state.text}
            editable = {true}
            multiline = {true}
            autoGrow = {true}
            onChangeText={(text) => this.setState({text})}
          />
        </View>
      </View>
    );
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    borderColor: 'gray', 
    borderWidth: 1,
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
    minHeight: 200,
  },
});

AppRegistry.registerComponent('MyReactNativeApp', () => HelloWorld);
