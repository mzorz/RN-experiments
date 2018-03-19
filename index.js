import React from 'react';
import {AppRegistry, TextInput, StyleSheet, Text, View} from 'react-native';
import AztecTextRNView from './ReactAztecView';
import AztecTextRNInflatedView from './ReactAztecInflatedView';

class HelloWorld extends React.Component {

constructor (props) {
    super(props);
    this.state = { text: 'ESTO ES UNA PRUEBA', lineCount: 0};
    this._onChange = this._onChange.bind(this);
  }

  updateState = () => {
    console.log("estamos en updateState del parent");
      // this.setState({
      //     //show: !this.state.show
      // });
  }

  _onChange(event: Event) {
    console.log('_onChange: ' + event.nativeEvent.message);
    console.log('_onChange: ' + event.nativeEvent.lineCount);
    // if (!this.props.onChangeMessage) {
    //   return;
    // }
    // this.props.onChangeMessage(event.nativeEvent.message);
    console.log('current state: ' + JSON.stringify(this.state));
    this.state.lineCount = event.nativeEvent.lineCount;
  }

  render() {
    return (
      <View style={styles.container}>
        <Child
         style={styles.hello}
         color = {'black'}
         text = {'AztecTextRNView hello thi is a atest from js'}
         maxImagesWidth = {300}
         editable = {true}
         autoGrow = {true}
         multiline = {true}

         onChange={this._onChange}
         onLineCountChange = {true}
         minHeight={this.state.lineCount * 40}
         //onChange={(text) => this.setState({text})}
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

class Child extends React.Component {
  constructor (props) {
      super(props);
      this.state = { text: 'THIS IS A TEST - CHILD', lineCount: 0};
      //this._onChange = this._onChange.bind(this);
    }

  _onChange = () => {
      console.log("_onChange in Child");
      console.log("_onChange in Child: " + JSON.stringify(this.props));
      this.props.updateState();
    }
  render() {
    return (
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
         minHeight={this.state.lineCount * 40}
         //onChange={(text) => this.setState({text})}
        />
    );
  }
}

AppRegistry.registerComponent('MyReactNativeApp', () => HelloWorld);
