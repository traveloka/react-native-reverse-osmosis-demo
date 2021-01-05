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
    <>
      <StatusBar barStyle="dark-content" />
      <SafeAreaView>
        <ScrollView
          contentInsetAdjustmentBehavior="automatic"
          style={styles.scrollView}>
          <DemoWidget />
          <View style={styles.box}>
            <Text style={styles.boxContent}>React Native View</Text>
          </View>
        </ScrollView>
      </SafeAreaView>
    </>
  );
};

const styles = StyleSheet.create({
  scrollView: {
    backgroundColor: '#f5f5f5',
  },
  box: {
    height: 100,
    backgroundColor: '#df4747',
    alignSelf: 'stretch',
    alignItems: 'center',
    justifyContent: 'center',
  },
  boxContent: {
    textAlign: 'center',
    color: '#ffffff',
    fontSize: 17,
  },
});

export default App;
