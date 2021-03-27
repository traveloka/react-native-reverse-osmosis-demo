import React from 'react';
import {requireNativeComponent, ViewStyle} from 'react-native';

const DemoWidgetNativeComponent = requireNativeComponent('DemoWidget');

interface Props {
  buttonTitle: string;
  labelTitle: string;
  style?: ViewStyle;
}

export default function DemoWidget(props: Props) {
  return <DemoWidgetNativeComponent {...props} />;
}
