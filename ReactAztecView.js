// ReactAztecView.js
import PropTypes from 'prop-types';
import { requireNativeComponent, ViewPropTypes } from 'react-native';

var iface = {
    name: 'AztecTextRNView',
    propTypes: {
      text: PropTypes.string,
      onLineCountChange: PropTypes.bool,
      onChange: PropTypes.func,
        ...ViewPropTypes // include the default view properties
    }
}

module.exports = requireNativeComponent('AztecTextRNView', iface);
