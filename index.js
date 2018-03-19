import React from 'react';
import {AppRegistry, TextInput, StyleSheet, Text, View} from 'react-native';
import AztecTextRNView from './ReactAztecView';
import AztecTextRNInflatedView from './ReactAztecInflatedView';

class HelloWorld extends React.Component {

constructor (props) {
    super(props);
    this.state = { text: 'ESTO ES UNA PRUEBA'};
    //this._onChange = this._onChange.bind(this);
  }

  _onChange(event: Event) {
    console.log('_onChange: ' + event.nativeEvent.message);
    console.log('_onChange: ' + event.nativeEvent.lineCount);
    // if (!this.props.onChangeMessage) {
    //   return;
    // }
    // this.props.onChangeMessage(event.nativeEvent.message);
  }

  render() {
    return (
      <View style={styles.container}>
        <AztecTextRNView
         style={styles.hello}
         color = {'black'}
         text = {'AztecTextRNView hello thi is a atest from js'}
         maxImagesWidth = {300}
         editable = {true}
         autoGrow = {true}
         multiline = {true}
         onChange={this._onChange}
         onLineCountChange = {true}
         //onChange={(text) => this.setState({text})}
        />
        <TextInput
          style={{borderColor: 'gray', borderWidth: 1}}
          value={this.state.text}
          editable = {true}
          multiline = {true}
          autoGrow = {false}
          onChangeText={(text) => this.setState({text})}
        />
        <Text style={styles.hello}>
          TEXTO: {JSON.stringify(this.state.text)}
        </Text>
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
    //minHeight: 200,
    flex:1
  },
});

AppRegistry.registerComponent('MyReactNativeApp', () => HelloWorld);
