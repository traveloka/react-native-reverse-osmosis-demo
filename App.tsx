/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
} from 'react-native';

import DemoWidget from './DemoWidget';

declare const global: {HermesInternal: null | {}};

const App = () => {
  return (
    <View style={styles.container}>
      <StatusBar barStyle="dark-content" />
      <SafeAreaView>
        <ScrollView contentInsetAdjustmentBehavior="automatic">
          <View style={{flexDirection: 'row'}}>
            <DemoWidget
              style={{flex: 1}}
              buttonTitle="Native Button A"
              labelTitle="Native Label A"
            />
            <DemoWidget
              style={{flex: 1}}
              buttonTitle="Native Button B"
              labelTitle="Native Label B"
            />
          </View>
          <Text style={[styles.label, {backgroundColor: 'green'}]}>
            React Native View A
          </Text>
          <DemoWidget
            buttonTitle="Native Button C"
            labelTitle="Native Label C"
            style={{margin: 24}}
          />
          <Text style={[styles.label, {backgroundColor: 'red'}]}>
            React Native View B
          </Text>
        </ScrollView>
      </SafeAreaView>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#474747',
  },
  label: {
    textAlign: 'center',
    color: '#ffffff',
    fontSize: 17,
    padding: 16,
  },
});

export default App;
