//
//  DemoWidgetViewManager.m
//  ReverseOsmosisDemo
//
//  Created by adrian.hartanto on 05/01/21.
//

#import "DemoWidgetViewManager.h"
#import "DemoWidgetViewController.h"
#import "WrapperView.h"

@implementation DemoWidgetViewManager

@synthesize bridge = _bridge;

RCT_EXPORT_MODULE(DemoWidget)

RCT_CUSTOM_VIEW_PROPERTY(buttonTitle, NSString *, WrapperView) {
  DemoWidgetViewController *widgetVC = (DemoWidgetViewController *)[view getContentViewController];
  [widgetVC setButtonLabel:json];
}

RCT_CUSTOM_VIEW_PROPERTY(labelTitle, NSString *, WrapperView) {
  DemoWidgetViewController *widgetVC = (DemoWidgetViewController *)[view getContentViewController];
  [widgetVC setLabelTitle:json];
}

- (UIView *)view {
  return [[WrapperView alloc] initWithBridge:_bridge contentViewController:[DemoWidgetViewController new]];
}

- (dispatch_queue_t)methodQueue {
  return dispatch_get_main_queue();
}

+ (BOOL)requiresMainQueueSetup {
  return NO;
}

@end
