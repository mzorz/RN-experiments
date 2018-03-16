// AztecTextRNInflatedView.js
import PropTypes from 'prop-types';
import { requireNativeComponent, ViewPropTypes } from 'react-native';

var iface = {
    name: 'AztecTextRNInflatedView',
    propTypes: {
      text: PropTypes.string,
        ...ViewPropTypes // include the default view properties
    }
}

module.exports = requireNativeComponent('AztecTextRNInflatedView', iface);
