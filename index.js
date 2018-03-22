import React from 'react';
import {AppRegistry, TextInput, StyleSheet, Text, View} from 'react-native';
import AztecTextRNView from './ReactAztecView';
import AztecTextRNInflatedView from './ReactAztecInflatedView';

class HelloWorld extends React.Component {

constructor (props) {
    super(props);
    this.state = { text: 'THIS IS A TEST', lineCount: 0};
    this._onChange = this._onChange.bind(this);
    this.state.lineCount = 0
    console.log("setting constructor value: " + this.state.lineCount);
  }

  _onChange(event: Event) {
    console.log('_onChange: ' + event.nativeEvent.message);
    console.log('_onChange: ' + event.nativeEvent.lineCount);
    console.log('_onChange: ' + event.nativeEvent.newHeight);
    // if (!this.props.onChangeMessage) {
    //   return;
    // }
    // this.props.onChangeMessage(event.nativeEvent.message);
    console.log('_onChange current state: ' + JSON.stringify(this.state));
    //this.state.lineCount = event.nativeEvent.lineCount;
    // this.setState(() => {
    //             console.log('setting state');
    //             return { text: 'ESTO ES UNA PRUEBA', lineCount: event.nativeEvent.lineCount};
    //         });

    this.setState({ text: 'THIS IS A TEST', lineCount: event.nativeEvent.lineCount, newHeight: event.nativeEvent.newHeight});

    console.log("setting this state value lineCount: " + this.state.lineCount);
    console.log("setting this state value: newHeight: " + this.state.newHeight);
  }

  _aztecwrapperviewStyle() {
    console.log("the calculation should give this: "+ (this.state.lineCount+1) * 40);
    return {
      flex: 1,
      justifyContent: 'center',
      borderColor: 'gray', 
      borderWidth: 2,
      //height: (this.state.lineCount+1) * 40,
      minHeight:  (this.state.lineCount+1) * 40
      //minHeight: this.state.newHeight * flex
      //height: this.state.newHeight
      //height: 200
    }
  }

  render() {
    console.log("render called")
    return (
      <View style={styles.container}>
        <View style={this._aztecwrapperviewStyle()}>
          <AztecTextRNView
           style={styles.hello}
           color = {'black'}
           text = {'AztecTextRNView hello thi is a atest from js\n new line here let us see'}
           onChange={this._onChange}
           onLineCountChange = {true}
           //minHeight = {this.state.lineCount * 40} 
           //onChange={(text) => this.setState({text})}
          />
        </View>
        <TextInput
          style={{borderColor: 'gray', borderWidth: 1}}
          value={this.state.text}
          editable = {true}
          multiline = {true}
          autoGrow = {false}
          onChangeText={(text) => this.setState({text})}
        />
        <Text style={styles.hello}>
          TEXT: {JSON.stringify(this.state)}
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
    flex:4
  },
});

AppRegistry.registerComponent('MyReactNativeApp', () => HelloWorld);
